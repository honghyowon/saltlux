package exam03;


import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


//class MyServerRunnable implements Runnable {					// 10. 스레스 생성을 위해 class 생성
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}										
//	
//	
//}

class MyRunnable implements Runnable {							// 10-1
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
	
	public MyRunnable() {
		// TODO Auto-generated constructor stub
	}
		
	
	public MyRunnable(Socket socket) {
		super();
		this.socket = socket;
		try {
			this.pr = new PrintWriter(socket.getOutputStream());
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void run() {											// 12. 클라이언트와 통신하는 코드
		
		try {
			while(true) {
				String msg = br.readLine();
				
				pr.println(msg);
				pr.flush();
			}				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}			

public class Exam03_MultiEchoServer extends Application{			// 1. 상속

	TextArea textArea;
	Button startBtn;
	Button stopBtn;
	
	ServerSocket server;
	
	
	private void printMsg(String msg) {								// 13.
		Platform.runLater(()->{
			textArea.appendText(msg + "\n");
		});

	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {		// 2. 오버라이딩 4. 창 이름 바꾸기(안 바꿔도 됨)
		// 화면 구성을 해요
		// primaryStage => 얘가 실제 window에요
		
		
		// 화면을 구성할 layout 먼저 만들기								// 5.
		// 우리는 화면 구성을 BorderPane을 이용해서 구성할 거에요 (동서남북 중앙 화면 5등분)
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);									// 7.
		
		// 실제 화면구성을 해보자										// 6.
//		TextArea textArea = new TextArea();							// 지역변수로 start에 하면 다른 method에 사용할 수 없어 곤란해짐 => 필드로 올리자
		textArea = new TextArea();	
		root.setCenter(textArea);	// 가운데에 textarea가 붙음
		
		startBtn = new Button("서버기동!!");							// 8.
		startBtn.setPrefSize(150, 40);
		// 버튼의 이벤트 처리코드를 먼저 작성
		startBtn.setOnAction(e -> {
			// 이벤트 처리 코드가 나옴 Java Lambda
			// 여기가 실행될 동안 window는 잠시 block된다
			// 하필이면..클라이언트의 접속을 무한정 기다리는 코드가 나와야함
			// 이 문제를 해결하기 위해.. Thread를 생성해서 사용함			// 10.
//			MyServerRunnable r = new MyServerRunnable();
		
			(new Thread(()->{										// 10. 시작되면 run만 하니까 축약해서 표현. 이를 Lamda. {}가 run
				try {
					// port가 다른 프로그램에서 사용되고 있는 중일 수 있기 때문에
					// 예외상황이 발생할 수 있음. 그래서 이 코드는 예외처리가 강제됨
					server = new ServerSocket(7777);	// port 번호 7777
					
					while(true) {									// 10-2 While
						Socket socket = server.accept();	// 클라이언트의 접속을 기다림!
						// 대기하고 있다가 클라이언트가 접속하면 해당 클라이언트와
						// 연결된 Socket 객체를 하나 생성해요 !
						
						// socket을 이용해서 직접 클라이언트와 통신하는 기능을 수행하는
						// Thread를 하나 생성해야 해요
						// Thread를 만들기 위한 클래스가 있어야겠죠. 클래스를 작성해보아요
						
						printMsg("새로운 클라이언트 접속 !!");			// 13-1
						
						MyRunnable r = new MyRunnable(socket);		// 10-1
						Thread t = new Thread(r);
						t.start();
					}	
								
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			})).start();							
//			t.start();												
			
		});
		
		stopBtn = new Button("서버중지!!");							// 8.
		stopBtn.setPrefSize(150, 40);
		// 버튼의 이벤트 처리코드를 먼저 작성
		stopBtn.setOnAction(e -> {
			// 이벤트 처리 코드가 나옴 Java Lambda
		});
		
		
		// BorderPane의 아래부분(Bottom)에 버튼을 부착시키고 싶어요
		// 공간은 하나인데 버튼은 2개. -> 붙일 수가 없음
		// 일단 판자(FlowPane)을 하나 만들어서 버튼 2개를 차례대로 붙이고
		// 이 판자를 BorderPane의 아래부분(Bottom)에 붙여요
		FlowPane flowPane = new FlowPane();
		// 이 판자에 버튼을 2개 붙일 거에요. 그런데 설정(Padding, 정렬)을 안 하면
		// 안 예쁨 - 보기가 좋지 않음 -> 설정이 좀 들어가야 함
		flowPane.setPadding(new Insets(10,10,10,10));	//padding(여백) 설정
		flowPane.setColumnHalignment(HPos.CENTER);		// 정렬
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		
		// 판자 설정이 끝났으니 이제 판자에 버튼을 붙여야함					//9.
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(stopBtn);
		
		// 판자를 BorderPane
		root.setBottom(flowPane);
		
		// 5. 이런 layout을 이용해서 화면에 보여줄 장면(Scene)을 만든다
		Scene scene = new Scene(root);	// 장면 객체 필요, 이 장면을 윈도우에 내용을 붙인다(무대에 올린다)
		
		// 5. 이제 만들어진 장면을 Window에 넣는다
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Server Program");				// 8.
		
		primaryStage.show();			//화면 띄움	
		
	}				
	
	public static void main(String[] args) {						// 3. main method
		// main thread에 의해서 최초로 실행되는 method
		// entry point
		// GUI Thread를 하나 생성할 거에요
		launch();
		
	}

	
}
