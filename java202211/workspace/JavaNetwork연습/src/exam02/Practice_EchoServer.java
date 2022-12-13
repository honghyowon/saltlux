package exam02;

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

public class Practice_EchoServer extends Application{

	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	ServerSocket server;
	Socket s;
	
	PrintWriter pr;
	BufferedReader br;
	
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});							
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// 창의 화면 구성
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startBtn = new Button("서버시작!");
		startBtn.setPrefSize(150, 40);
		
		startBtn.setOnAction(e -> {
			printMsg("서버가 시작되었어요!");
			
			try {
				server = new ServerSocket(5000);
				printMsg("클라이언트 접속 대기중");
				(new Thread(() ->  {
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

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}					
		});
		
		stopBtn = new Button("서버중지 !");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(null);	
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));			// Insets는 여백객체를 만들어서 패딩을 설정함
		flowPane.setColumnHalignment(HPos.CENTER);				// Column : 정렬
		flowPane.setHgap(10);									// 버튼간 간격 HGap
		
		flowPane.getChildren().add(startBtn);	
		flowPane.getChildren().add(stopBtn);

		root.setBottom(flowPane);								
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);							// 씬을 생성				
		
		primaryStage.setTitle("Echo Server Program");
		
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}//
