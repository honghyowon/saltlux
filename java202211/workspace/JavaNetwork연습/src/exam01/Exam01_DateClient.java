//package exam01;
//
//import java.awt.Button;
//import java.awt.TextArea;
//import java.awt.event.ActionEvent;
//import java.beans.EventHandler;
//
//public class Exam01_DateClient extends Application {
//	
//	// filed
//	TextArea textArea;
//	Button connBtn;
//
//	@Override
//	private void start(Stage primaryStage) throws Exception {
//		// 화면구성을 해보아요
//		// 일단 레이아웃부터 하나 만들어요
//		BorderPane root = new BorderPane();
//		root.setPrefSize(700,500);
//		
//		// component 생성
//		textarea = new TextArea();
//		root.setCenter(textarea);
//		
//		connBtn = new Button("Date 서버 접속");
//		connBtn.setPrefSize(150,40);
//		connBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//		}
//		
//		@Override
//		public void handel(ActionEvent arg0) {
//			// 접속 버튼을 클릭하면 하는 일을 여기에 작성
//			// 서버와 접속하는 코드를 만들어 주면 됨
//			System.out.println("서버에 접속해요!");
//		}
//		
//		
//	});
//		
//		
//		FlowPane flowpane = new FlowPane();	// 아래쪽 영역에 붙는 layout
//		// 여백 좀 잡아서 그나마 좀 보기 좋게 만들어 보자
//		flowpane.setPadding(new Insets(10, 10, 10, 10));
//		flowpane.setColumnHalignment(HPos.CENTER);
//		flowpane.setPrefSize(700, 40);
//		flowpane.setHgap(10);
//		
//		// 버튼을 flowpane에 붙여요
//		flowpane.getChildren().add(connBtn);
//		
//		// 이렇게 만든 flowpane(판때기)를 borderlayout의 아래쪽에 붙여야 함	
//		root.setBottom
//		
//		
//	public static void main(String[] args) {
//		launch();
//		
//	}
//}//
package exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
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

public class Exam01_DateClient extends Application {

	//field
	TextArea textarea;
	Button connBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성을 해 보아요!
		// 일단 레이아웃부터 만들어보아요
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		//component 생성
		textarea = new TextArea();
		root.setCenter(textarea);
		
		//버튼 생성
		connBtn = new Button("Date 서버 접속");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				//접속버튼을 클릭하면 하는일을 여기에 작성
				//서버와 접속하는 코드를 만들어주면 돼요
//				System.out.println("서버에 접속해요");
				textarea.clear();	//textarea안의 내용을 싹 다 지움
				// 서버에 접속해요 => Socket객체 생성 시도
				// 서버에 접속하려면 IP와 port를 알아야함
				// 자신을 찾을 때 사용하는 IP : 127.0.0.1, localhost
				
				try {
					Socket s = new Socket("127.0.0.1", 3000);
					System.out.println("서버에 접속 성공!");
					BufferedReader br =
							new BufferedReader(new InputStreamReader(s.getInputStream()));	//Server 할 일 종료하고 다시 돌아와서 생성

					String msg = br.readLine();		// blocking중. 통로에 아직 들어온 데이터가 없기 때문=> 데이터 유출 염려가 없음
													// 읽는 사람 기준으로 동작
					
					System.out.println(msg);
					
					// 더이상 아무것도 안 함
					br.close();
					s.close();
					
					System.out.println("서버와 연결 종료!");
					
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		FlowPane flowpane = new FlowPane(); //아래쪽 영역에 붙는 layout
		//여백 잡아서 보기 좋게 만들자!
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setColumnHalignment(HPos.CENTER); 
		flowpane.setPrefSize(700, 40);			
		flowpane.setHgap(10);
		
		//버튼을 flowpane에 판떼기 붙이자
		flowpane.getChildren().add(connBtn);
		
		//이렇게 만든 flowpane은 borderlayout의 아래쪽에 붙여야 해요
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root); 
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
		
	}
	
}