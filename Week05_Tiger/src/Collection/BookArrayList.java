package Collection;

import java.util.ArrayList;

public class BookArrayList {
	private ArrayList<Book> arrayList;
	
	public BookArrayList() {
		arrayList=new ArrayList<Book>();
	}
	public void addBook(Book book) {
		for (int i=0;i<arrayList.size();i++) {
			Book nbook=arrayList.get(i);
			int tempId=nbook.getBookId();
			if(tempId>=book.getBookId()) {
				arrayList.add(i,book);
				return;
			}
			else if (tempId<book.getBookId()) {	
				continue;
				}
			else {arrayList.add(book);return;}
			}
		arrayList.add(book);
	}
	
	public boolean removeBook(int BookId) {
		for (int i=0;i<arrayList.size();i++) {
			Book book=arrayList.get(i);
			int tempId=book.getBookId();
			if(tempId==BookId) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println(BookId+"가 존재하지 않습니다.");
		return false;
	}
	public void insertBook(int index, Book newBook) {
		for (int i=0;i<arrayList.size();i++) {
			if(i==index) {
				arrayList.add(i,newBook);
			}
		}
	}
	public void searchBook(int index) {
		for (int i=0;i<arrayList.size();i++) {
			Book book=arrayList.get(i);
			if(book.getBookId()==index) {
				System.out.println(book);
			}
			else System.out.println("찾고 있는 아이디의 도서가 없습니다.");
		}
	}
		
	public void ShowAllBook() {
		for (Book book:arrayList) {
			System.out.println(book);
		}
		System.out.println();

	}

}
