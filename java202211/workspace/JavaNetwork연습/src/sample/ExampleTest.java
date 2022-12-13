package sample;

public class ExampleTest {
	public static void main(String[] args){
    	// 우리프로그램을 실행시키려면
        // javac ExampleTest.java => compile
        // 결과로 bytecode인 ExamleTest.class 파일이 생성됨
        // java ExamleTest 엔터 눌러서 실행
        // java ExamleTest 10 20
        System.out.println(args[0] + "," + args);
        
    }
}
