package exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

public class Exam01_Dateserver {
	
	public static void main(String[] args) {
	
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("서버소켓이 생성되었어요 - 포트번호 3000");	// 객체가 존재하지 않는다
			
		// 이 서버소켓을 통해 클라이언트의 접속을 기다려야 함
			Socket s = server.accept();	// 일단 대기. 언제까지? 클라이언트가 접속할 때 까지 일단 대기..
			System.out.println("클라이언트의 접속이 들어왔어요");
			
			// 클라이언트와 연결된 output stream(데이터를 내보내기 위한 스트림)을
			// 사용하기 편한 PrintWriter로 만들어요
			PrintWriter out = new PrintWriter(s.getOutputStream());			//뽑아냄
			
			// 현재 시간을 보내줄 거에요
			DateFormat dateFormat = DateFormat.getInstance();
			String currentDate = dateFormat.format(new Date());
			
			out.println(currentDate);	// 데이터를 보내
			out.flush();				// 데이터 마차
			
			// 서버는 할 일을 다 했음
			// 내가 사용한 resource를 .... 연결통로(stream)을 닫아야함
			// stream을 닫는다
			out.close();
			//	socket을 닫는다
			s.close();
			// serverSocket을 닫아요
			server.close();
			
			
			System.out.println("서버프로그램 종료!!");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

	}
	
}//