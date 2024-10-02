package lab03;

// What imports do you need to include? Put them here.

import java.util.GregorianCalendar;

public class LibraryBook extends Book /* ADD SOMETHING HERE */ { 

	// A LibraryBook contains a holder (a String) and due date represented by
	// a GregorianCalendar
	
	String holder;
	GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title) {
		// FILL IN
		
		super(isbn, author, title);
		this.holder = null;
		this.dueDate = null;
		
	}

	public String getHolder() {
		// FILL IN
		
		return this.holder;
		
	}
	
	public GregorianCalendar getDueDate() {
		// FILL IN
		
		return this.dueDate;
		
	}
	
	public void checkin() {
		// FILL IN
		
		this.holder = null;
		this.dueDate = null;
		
	}
	
	public void checkout(String holder, GregorianCalendar dueDate){
		// FILL IN
		
		this.holder = holder;
		this.dueDate = dueDate;
		
	}	

	// Do not override the equals method in Book

}