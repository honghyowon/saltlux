//package exam02;
//
//import java.awt.TextField;
//import java.io.IOException;
//import java.net.ServerSocket;
//
//import javafx.application.Application;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
//import javafx.stage.Stage;
//
//public class Exam02_EchoClient extends Application {
//	// 1. 필드 생성
//	TextArea textarea;
//	Button connBtn;
//	TextField textField;
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		
//		// 5. 창의 화면 구성을 하게 됨
//		// Layout
//		BorderPane root = new BorderPane();
//		root.setPrefSize(700, 500);								//Layout의 가로,세로 크기
//		
//		// 5.
//		textarea = new TextArea();
//		root.setCenter(textarea);
//		
//		// 5.
//		connBtn = new Button("서버접속!");
//		connBtn.setPrefSize(150, 40);
//		connBtn.setOnAction(e -> { 
//			
//		});														// 10. 이벤트처리는 Listner객체(Handler객체)가 담당 => delegation model		
//		
//		textField = new TextField();
//		textField.setPrefSize(200, 40);
//		textField.setOnAction(e -> {
//			textField.clear();
//		});
//		
//		
//		// 7.
//		FlowPane flowPane = new FlowPane();
//		flowPane.setPadding(new Insets(10,10,10,10));			// Insets는 여백객체를 만들어서 패딩을 설정함
//		flowPane.setColumnHalignment(HPos.CENTER);				// Column : 정렬
//		flowPane.setHgap(10);									// 버튼간 간격 HGap
//		
//		flowPane.getChildren().add(connBtn);	
//		flowPane.getChildren().add(textField);
//		
//		
//		root.setBottom(flowPane);								// 9.
//		// 8. 레이어드로 씬을 만들고
//		Scene scene = new Scene(root);
//		
//		primaryStage.setScene(scene);							// 씬을 생성				
//		
//		primaryStage.setTitle("Echo Client Program");
//		primaryStage.show();									// 2. show : 창객체를(화면을) 띄운다
//	
//		
//	}
//	
//	public static void main(String[] args) {
//		
//	}
//
//}
//////////////////////////////내 코드

package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {

	TextArea textarea;
	Button connBtn;
	TextField textField;
	TextField idField;
	
	Socket s;
	
	PrintWriter pr;				// 소켓과 연결된 통로
	BufferedReader br;

	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});							
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 창의 화면 구성을 하게 되요!
		// Layout
		BorderPane root = new BorderPane();
		root.setPrefSize(700,500); // Layout의 가로세로 크기
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		connBtn = new Button("서버접속!!");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {			
			try {
				s = new Socket("127.0.0.1", 5000);
				printMsg("서버에 연결이 성공했습니다.");
				textField.setDisable(false);
				pr = new PrintWriter(s.getOutputStream());
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));

//				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	// 1. 서버를 연결하려면 소켓을 만들면 됨
			
		});
		
		idField = new TextField();
		idField.setPrefSize(200, 40);

		textField = new TextField();
		textField.setPrefSize(200, 40);
		textField.setDisable(true);
		textField.setOnAction(e -> {
			String msg = textField.getText();		// 2.
			String id = idField.getText();
//			pr.println(msg);						// 3.
			pr.println(id + ">" + msg);
			pr.flush();			
			
			if(!msg.equals("/exit")) {
				try {
					printMsg(br.readLine());			// 서버가 뭔가 주기를 기다리고 있음
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				printMsg("클라이언트가 서버와 연결이 종료되었어요!");
			}
			textField.clear();
		});
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);  // 정렬
		flowPane.setHgap(10);
		
		flowPane.getChildren().add(connBtn);
		flowPane.getChildren().add(idField);
		flowPane.getChildren().add(textField);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Echo Client Program");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
//----------------------내코드2

