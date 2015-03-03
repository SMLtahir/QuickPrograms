package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Design a bookshelf
 * @author Tahir
 *
 */
public class Bookshelf {

	public static void main(String[] args) {

		Bookshelf shelf = new Bookshelf(10);
		shelf.addBook(new Book("Godfather", 178321));
		shelf.addBook(new Book("ABC", 178451));
		shelf.addBook(new Book("Java Programming", 678451));
		shelf.addBook(new Book("Lord of the Rings", 938451));
		shelf.addBook(new Book("Harry Potter", 784781));
		
		System.out.println("The bookshelf has "+ shelf.getSize()+ " books:\n"+ shelf);
		System.out.println("Finding book: "+ shelf.find(938451).name);
		shelf.removeBook("Harry Potter");
		System.out.println("The bookshelf has "+ shelf.getSize()+ " books:\n"+ shelf);
		
	}
	
	public HashMap<Long, Book> books;
	private int capacity;
	
	//Constructor
	public Bookshelf(int capacity) {
		this.capacity = capacity; 
		books = new HashMap<Long, Book>();
	}
	
	public int getSize() {
		return books.size();
	}
	
	public void addBook(Book b) {
		if(books.size() < capacity) {
			books.put(b.bookId, b);
		} else {
			System.out.println("The book shelf is full!");
		}
	}
	
	public void removeBook(String name) {
		for(long id: books.keySet()) {
			if(books.get(id).name == name) {
				System.out.println("Book removed: "+ books.get(id).name);
				books.remove(id);
				return;
			}
		}
		System.out.println("Book not found!");
	}
	
	public void removeBook(long id) {
		
		if(books.containsKey(id)) { 
			System.out.println("Book removed: "+ books.get(id).name);
			books.remove(id);
			return;
		}
		System.out.println("Book not found!");
	}
	
	public Book find(long id) {
		
		if(books.containsKey(id)) {
			return books.get(id);
		}
		System.out.println("Book not found!");
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(long id: books.keySet()) {
			sb.append(books.get(id).name+ "\n");
		}
		return sb.toString();
	}

}

class Book {
	public long bookId;
	public String name;
	
	//Constructor
	public Book(String name, long id) {
		this.name = name;
		this.bookId = id;
	}
}
