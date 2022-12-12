package javafxexam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//import java.awt.Button;
//
//import javafx.application.Application;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//public class JavaFXExample extends Application {
//	
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		// 화면 구성하는 작업을 여기서 함
//		Button btn = new Button();
//		btn.setText("안녕 !!");
//
//		
//		// button에 이벤트 처리를 해야 함
//		// Java는 delegation model을 이용함 => Web JavaScript도 이 방식을 이용
//		// Layout을 설정해요 (컴포넌트가 붙는 방식을 결정하는 객체)
//		//  StackPane => Layout 중 추가되는 순서대로 덧붙여서 시각화하는 Layout
//		StackPane root = new StackPane();
//		
//		root.getChildren().add(btn);
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		launch();	//method 호출 - static . 내부적으로 static이 GUI라는 thread를 호출..
//		//GUI Thread가 실행되고 화면에 창이 뜸, main 종료
//		
//	}
//	
//}//

	public class JavaFXExample extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			// 화면 구성하는 작업을 여기서 함
			Button btn = new Button();
			btn.setText("안녕 !!");
			
			// button에 이벤트 처리를 해야 함
			// Scene객체를 생성
			// Java는 delegation model을 이용함 => Web JavaScript도 이 방식을 이용
			// Layout을 설정해요 (컴포넌트가 붙는 방식을 결정하는 객체)
			//  StackPane => Layout 중 추가되는 순서대로 덧붙여서 시각화하는 Layout

			StackPane root = new StackPane();
			root.getChildren().add(btn);
			
			Scene scene = new Scene(root, 300, 150);
			
			primaryStage.setTitle("연습입니다.");
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		}
	
	
	
	
	public static void main(String[] args) {
		launch();	//method 호출 - static . 내부적으로 static이 GUI라는 thread를 호출..
		//GUI Thread가 실행되고 화면에 창이 뜸, main 종료
		
	}
}

