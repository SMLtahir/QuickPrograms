package objectOrientedPrograms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * Design the data structures for an online book reader system
 * 
 * 
 * I have designed this entirely by myself without any reference.
 * Please refer to other material to verify the presence of all required info.
 * This is also implemented in Cracking The Coding Interview for example.
 * @author Tahir
 *
 */
public class OnlineBookReader {
	Set<User> users;
	
	public OnlineBookReader() {
		users = new HashSet<User>();
	}
	
	public boolean addUser(User u) {
		return users.add(u);
	}
	
	public boolean removeUser(User u) {
		return users.remove(u);
	}
	
	
	public boolean addBook(User u, Book b) {
		return u.books.add(b);
	}
	
	public boolean removeBook(User u, Book b) {
		if(u.recentBooks.contains(b)) { u.recentBooks.remove(b);}
		return u.books.remove(b);
	}
	
	public void readBook(User u, Book b) { 
		// Function to read book is called here
		u.recentBooks.push(b);
		while(u.recentBooks.size() > u.maxHistory) {
			u.recentBooks.remove(u.recentBooks.size() - 1);
		}
	}
	
	public Book findBook(User u, long bookId) {
		Iterator<Book> iter = u.books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.bookId == bookId) {
				return b;
			}
		}
		return null;
	}
	
	public Book findBook(User u, String bookName) {
		Iterator<Book> iter = u.books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.name.equals(bookName)) {
				return b;
			}
		}
		return null;
	}
	
	public void clearUserHistory(User u) {
		u.recentBooks.removeAllElements();
	}
}

// This class can be made abstract and subclasses like FreeUser and PremiumUser can be created
class User {
	Set<Book> books;
	String username;
	// More user details can be put here
	Stack<Book> recentBooks;
	int maxHistory = 20;

	public User(String username) {
		this.username = username;
		books = new HashSet<Book>();
		recentBooks = new Stack<Book>();
	}

}

/*
class Book {
	public long bookId;
	public String name;
	
	//Constructor
	public Book(String name, long id) {
		this.name = name;
		this.bookId = id;
	}
}
*/