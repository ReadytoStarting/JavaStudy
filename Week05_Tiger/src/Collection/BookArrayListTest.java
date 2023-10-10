package Collection;

import java.util.Scanner;

public class BookArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookArrayList bookArrayList=new BookArrayList();
		
		Book book1=new Book(0001, "파우스트");
		Book book2=new Book(0002, "황무지");
		Book book3=new Book(0003, "변신");
		Book book4=new Book(0004, "픽션들");
		Book book5=new Book(0005, "톨스토이");
		
		bookArrayList.addBook(book1);
		bookArrayList.addBook(book2);
		bookArrayList.addBook(book3);
		bookArrayList.addBook(book4);
		bookArrayList.addBook(book5);
		
		bookArrayList.ShowAllBook();
		
		Scanner sc=new Scanner(System.in);
		
		while (true){
			
			System.out.println("1: 검색 , 2: 추가 , 3: 삽입 , 4: 삭제 , 5: 종료 --> ");
			int search=sc.nextInt();
			if (search==1) {
				System.out.println(" 검색할 아이디 입력--> ");
				int id=sc.nextInt();
				bookArrayList.searchBook(id);
			}
			else if (search==2) {
		
				System.out.println("책 ID 입력 : ");
				int bookId1=sc.nextInt();
		
				sc.nextLine();
				System.out.println("책 제목 입력 : ");
				String title=sc.nextLine();
		
				Book newBook=new Book(bookId1,title);
				bookArrayList.addBook(newBook);
				bookArrayList.ShowAllBook();
			}
			else if (search==3) {
				
				System.out.println("도서를 추가할 위치를 입력: ");
				int index=sc.nextInt();
				
				System.out.println("책 ID 입력 : ");
				int bookId2=sc.nextInt();
		
				sc.nextLine();
				System.out.println("책 제목 입력 : ");
				String title=sc.nextLine();
		
				Book newBook=new Book(bookId2,title);
				bookArrayList.insertBook(index,newBook);
		
				bookArrayList.ShowAllBook();
				
			}
			else if (search==4) {
				System.out.println("삭제할 도서의 아이디 입력--> ");
				int bookId3=sc.nextInt();
				bookArrayList.removeBook(bookId3);
				bookArrayList.ShowAllBook();
			}
			else {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
		sc.close();
		

	}

}
