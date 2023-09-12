class Circle{
	protected int radius;
	public Circle(int r) {
		radius=r;
	}
}
class Pizza extends Circle{
	String name;
	public Pizza(String n, int r) {
		super(r);
		name=n;
	}
	void print() {
		System.out.println("name: "+name+"\n"+"radius: "+radius);
	}
}
public class PizzaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Pizza obj=new Pizza("Pepperoni",20);
		obj.print();

	}

}
