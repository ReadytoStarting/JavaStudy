import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInform {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int num2,num3,num4;
		String search;
		String num,name,tel,email;
		Scanner scan=null;
		PrintWriter in=new PrintWriter(new FileWriter("user.txt"));
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("��ȣ: ");
			num=s.next();
			System.out.println("�̸�: ");
			name=s.next();
			System.out.println("��ȭ��ȣ: ");
			tel=s.next();
			System.out.println("�̸���: ");
			email=s.next();
			System.out.println("�Է��� �������� 1, ����Ϸ��� 0: ");
			num2=s.nextInt();
			in.print(num+","+name+","+tel+","+email+"");
			in.flush();
			if(num2==1)
				break;
		}
//		FileReader inst=new FileReader("user.txt");
//		FileWriter out=new FileWriter("usercopy.txt");
//		System.out.println("ã�� ��ȣ: ");
//		num3=s.nextInt();
//		while ((num4=inst.read())!=-1) {
//			out.write(num4);
//			if (num4==num3);
//		}
	}

}
