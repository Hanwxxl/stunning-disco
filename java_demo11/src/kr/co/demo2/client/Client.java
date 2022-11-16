package kr.co.demo2.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 클라이언트에서 연결 요청할 서버의 IP와 Port를 지정
		String serverIp = "192.168.20.58";
		int serverPort = 50000;
		
		try {
			// 서버에 연결
			Socket sock = new Socket(serverIp, serverPort);
			
			// 연결된 소켓으로 통신을 위한 입/출력 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			while(true) {
				System.out.print("서버에 보낼 메시지 입력 : ");
				String msg = sc.nextLine();
				
				bw.write(msg);
				bw.newLine();
				
				// 네트워크 통신에서 flush 를 하지 않으면 서버에 데이터가 전달 되지 않음.
				bw.flush();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
