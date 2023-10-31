import java.awt.print.Book;
import java.util.ArrayList;

public class Q3_1 {
private ArrayList<Q3> arrayList;
	
	public Q3_1() {
		arrayList=new ArrayList<Q3>();
	}
	public void addStudent(Q3 student) {
		for (int i=0;i<arrayList.size();i++) {
			Q3 nstudent=arrayList.get(i);
			int snum=nstudent.getNum();
			if(snum>=nstudent.getNum()) {
				arrayList.add(i,student);
				return;
			}
			else if (snum<nstudent.getNum()) {	
				continue;
				}
			else {arrayList.add(student);return;}
			}
		arrayList.add(student);
	}
	
	public boolean removeStudent(int num) {
		for (int i=0;i<arrayList.size();i++) {
			Q3 student=arrayList.get(i);
			int snum=student.getNum();
			if(snum==num) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println(num+"�� �й��� ���� �л��� �������� �ʽ��ϴ�.");
		return false;
	}
	public void insertStudent(int index, Q3 newstudent) {
		for (int i=0;i<arrayList.size();i++) {
			if(i==index) {
				arrayList.add(i,newstudent);
			}
		}
	}
	public void searchStudent(int index) {
		for (int i=0;i<arrayList.size();i++) {
			Q3 student=arrayList.get(i);
			if(student.getNum()==index) {
				System.out.println(student);
				return;
			}
			else continue;
		}System.out.println("ã�� �ִ� �й��� �л��� �����ϴ�.");
	}
	public String averageStudent() {
		double sum = 0.0;
		for (int i=0;i<arrayList.size();i++) {
			Q3 student=arrayList.get(i);
			double sgrade=student.getGrade();
			sum+=sgrade;
		}
		sum/=arrayList.size();
		return "��ü �л��� �� "+arrayList.size()+"���̰�, �л����� ��ü ��� ������ "+sum+"�Դϴ�.";
	}
		
	public void ShowAllStudent() {
		for (Q3 student:arrayList) {
			System.out.println(student);
		}
		System.out.println();

	}
	

	

}
