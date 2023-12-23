import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Socket clientSocket=null;
		BufferedReader in=null;
		PrintWriter out=null;
		final Scanner sc=new Scanner(System.in);
		try {
			clientSocket=new Socket("localhost",5000);
			out=new PrintWriter(clientSocket.getOutputStream());
			in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String msg;
			while (true) {
				System.out.print("������ ���� ���ڿ��� �Է��ϰ� ����Ű�� ġ����: ");
				msg=sc.nextLine();
				if (msg.equalsIgnoreCase("quit")) {
					out.println(msg);
					out.flush();
					break;
				}
				out.println(msg);
				out.flush();
				msg=in.readLine();
				System.out.println("�����κ��� �� �޼���: "+msg);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			out.close();
			clientSocket.close();
			
		}

	}

}