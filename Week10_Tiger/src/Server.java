import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket=null;
		Socket clientSocket=null;
		BufferedReader in=null;
		PrintWriter out=null;
		Scanner sc=new Scanner(System.in);
		try {
			serverSocket=new ServerSocket(5000);
			System.out.println("������ ��ٸ��� ����");
			clientSocket=serverSocket.accept();
			out=new PrintWriter(clientSocket.getOutputStream());
			in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ���");
			while(true) {
				String msg=in.readLine();
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ���");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ�� ���� ���ڿ�: "+msg);
				System.out.print("Ŭ���̾�Ʈ�� ���� ���ڿ��� �Է��ϰ� ���͸� ġ����: ");
				String omsg=sc.nextLine();
				out.write(omsg+'\n');
				out.flush();
			}
			out.close();
			clientSocket.close();
			serverSocket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
