import java.awt.print.Book;
import java.util.Scanner;

public class Q3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q3_1 studentList=new Q3_1();
		
		Q3 student1=new Q3("kim",231111,3.5);
		Q3 student2=new Q3("lee",231112,3.5);
		Q3 student3=new Q3("chung",231113,3.8);
		
		studentList.addStudent(student1);
		studentList.addStudent(student2);
		studentList.addStudent(student3);
		
		studentList.ShowAllStudent();
		
		Scanner sc=new Scanner(System.in);
		
		while (true){
			
			System.out.println("1: �˻� , 2: �߰� , 3: ���� , 4: ���� , 5: ��� , 6: ���� --> ");
			int search=sc.nextInt();
			if (search==1) {
				System.out.println(" �˻��� �й� �Է�--> ");
				int num=sc.nextInt();
				studentList.searchStudent(num);
			}
			else if (search==2) {
		
				System.out.println("�л� �й� �Է� : ");
				int snum=sc.nextInt();
		
				sc.nextLine();
				System.out.println("�л� �̸� �Է� : ");
				String sname=sc.nextLine();
				
				System.out.println("�л� ���� �Է� : ");
				double sgrade=sc.nextDouble();
		
				Q3 nstudent=new Q3(sname,snum,sgrade);
				studentList.addStudent(nstudent);
				studentList.ShowAllStudent();
			}
			else if (search==3) {
				
				System.out.println("�л��� �߰��� ��ġ�� �Է�: ");
				int index=sc.nextInt();
				
				System.out.println("�л� �й� �Է� : ");
				int snum=sc.nextInt();
		
				sc.nextLine();
				System.out.println("�л� �̸� �Է� : ");
				String sname=sc.nextLine();
				
				System.out.println("�л� ���� �Է� : ");
				double sgrade=sc.nextDouble();
				
				Q3 nstudent=new Q3(sname,snum,sgrade);
				studentList.insertStudent(index, nstudent);
				studentList.ShowAllStudent();
				
			}
			else if (search==4) {
				System.out.println("������ �л��� �й� �Է�--> ");
				int snum3=sc.nextInt();
				studentList.removeStudent(snum3);
				studentList.ShowAllStudent();
			}
			else if (search==5) {
				System.out.println(studentList.averageStudent());
				
			}
			else {
				System.out.println("�ý����� �����մϴ�.");
				break;
			}
		}
		sc.close();
		
	}

}
