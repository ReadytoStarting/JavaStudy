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
			System.out.println("번호: ");
			num=s.next();
			System.out.println("이름: ");
			name=s.next();
			System.out.println("전화번호: ");
			tel=s.next();
			System.out.println("이메일: ");
			email=s.next();
			System.out.println("입력을 끝났으면 1, 계속하려면 0: ");
			num2=s.nextInt();
			in.print(num+","+name+","+tel+","+email+"");
			in.flush();
			if(num2==1)
				break;
		}
//		FileReader inst=new FileReader("user.txt");
//		FileWriter out=new FileWriter("usercopy.txt");
//		System.out.println("찾을 번호: ");
//		num3=s.nextInt();
//		while ((num4=inst.read())!=-1) {
//			out.write(num4);
//			if (num4==num3);
//		}
	}

}
