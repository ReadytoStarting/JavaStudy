
public class Q3 {

	private int num;
	private String name;
	private double grade;
	
	public Q3(String name,int num,double grade) {
		this.name=name;
		this.num=num;
		this.grade=grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num=num;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade=grade;
	}
	
	public String toString() {
		return name+" , "+num+" , "+grade+" , ";
	}

}
