package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoServer extends Application {
	
	// 4. 필드 생성
	TextArea textarea;											// 지역변수로 두면 문제가 발생할 수 있기때문에 필드로 올려서 사용
	Button startBtn;	
	Button stopBtn;
	ServerSocket server;
	Socket s;
	
	PrintWriter pr;
	BufferedReader br;
	
	
	// 12. 매번 11번처럼 하는 것 보다 메소드를 만드는게 나음
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});							
	}
	
	
	
	@Override
	public void start(Stage primaryStage ) throws Exception {	// 1. Stage의 객체가 창. primaryStage
		// 5. 창의 화면 구성을 하게 됨
		// Layout
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);								//Layout의 가로,세로 크기
		
		// 5.
		textarea = new TextArea();
		root.setCenter(textarea);
		
		// 5.
		startBtn = new Button("서버시작!");
		startBtn.setPrefSize(150, 40);
//		startBtn.setOnAction(null);								// 6. 버튼을 클릭했을 때(클릭은 ActionEvent) 이벤트 처리가 나옴
		
		
																// 10. 이벤트처리는 Listner객체(Handler객체)가 담당 => delegation model		
//		startBtn.setOnAction(new EventHandler<ActionEvent>() { 
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			} 
//			
//		}); 이 주석과 밑이 같음
		
		startBtn.setOnAction(e -> {
//			textarea.appendText("서버가 시작되었어요!" +"\n");
//			for(long k=0; k<9000000000000L; k++);				// 시간 끌기용. busy waiting
			// blocking method! 실행되는 동안 수행이 잠시 중지됨
			// 이렇게하면 안 됨
			// 순차처리를 안 하기 위해서 당연히 Thread를 사용해야 함
			printMsg("서버가 시작되었어요!");
			try {												// 13. 여기까지하고 Client 코드짜기
				server = new ServerSocket(5000);
				printMsg("클라이언트 접속 대기중");
				(new Thread(() ->  {							// 스레드 만들고 run이라는 객체
					try {
						s = server.accept();
						printMsg("클라이언트 접속 성공!");
																// 14.
						pr = new PrintWriter(s.getOutputStream());
						br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						
						while(true) {
							// 보냈으니 받아야함
							String msg = br.readLine();
							printMsg("클라이언트의 메시지 : " + msg);
							
							if(msg.equals("/exit")) {			// 문자열 비교 : equals
								break;
							}
							pr.println(msg);
	 						pr.flush();
						}
						
						printMsg("클라이언트 종료! & 서버 Process 종료");
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				})).start();									
//				server.accept();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}					
		});
			
//			Platform.runLater(new Runnable() {					// Platform.runLater 라는 static메소드
//				
//				@Override
//				public void run() {
//				}
//			});
//			new Thread(()->{});
			
			// 11.
//			Platform.runLater(()->{
//				textarea.appendText("서버가 시작되었어요!" +"/n");
//			});							// 위에 코드와 같음
		

		// 5.
		stopBtn = new Button("서버중지!");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(null);								// 6.
		
		// 7.
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));			// Insets는 여백객체를 만들어서 패딩을 설정함
		flowPane.setColumnHalignment(HPos.CENTER);				// Column : 정렬
		flowPane.setHgap(10);									// 버튼간 간격 HGap
		
		flowPane.getChildren().add(startBtn);	
		flowPane.getChildren().add(stopBtn);
		
		
		root.setBottom(flowPane);								// 9.
		// 8. 레이어드로 씬을 만들고
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);							// 씬을 생성				
		
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();									// 2. show : 창객체를(화면을) 띄운다
		
	}
	

	public static void main(String[] args) {
		launch();												// 3. launch는 static 메소드
																// GUI Thread가 생성돼서 창이 실행됨				
	}
}


