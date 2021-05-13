import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	private String address;
	private final ArrayList<Book> books = new ArrayList<>();
	
	public Library(String s) {
		this.address=s;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	public void printAddress() {
		System.out.println(this.address);
	}
	
	public void borrowBook(String s) {
		boolean flag=false;
		for(Book book:books)
		{
			if(book.getTitle().equals(s))
			{
				if(!book.isBorrowed())
				{
					book.rented();
					System.out.println("You successfully borrowed "+s);
				}
				else
				{
					System.out.println("Sorry, this book is already borrowed.");
				}
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Sorry, this book is not in our catalog.");
		}
	}
	
	public void printAvailableBooks() {
		if(books.isEmpty())
		{
			System.out.println("No book in catalog");
		}
		else
		{
			for(Book book:books)
			{
				if(!book.isBorrowed())
				{
					System.out.println(book.getTitle());
				}
			}
		}
	}
	
	public void returnBook(String s) {
		for(Book book:books)
		{
			if(book.getTitle().equals(s))
			{
				book.returned();
				System.out.println("You successfully returned "+s);
			}
		}
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 