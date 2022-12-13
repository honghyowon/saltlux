package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Exam03_MultiEchoClient {

	ServerSocket server;
	
	try {												
		server = new ServerSocket(5000);
		printMsg("클라이언트 접속 대기중 !!!");
		
		(new Thread(() ->  {							
			try {
				while(true) {
			
				socket = server.accept();
				printMsg("새로운 클라이언트 접속 성공!");
				(new Thread(new EchoRunnable(socket))).start();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		})).start();	
				
									

	
}


