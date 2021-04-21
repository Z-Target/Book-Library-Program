import java.util.HashMap;
import java.util.Scanner;

class Library {
    public static HashMap<String, Book> library;
    public Library(HashMap<String, Book> library) {
        this.library = library;
    }

    public Library() {
        this.library = new HashMap<String, Book>();
    }

    public static void addBook()
    {
    	String bookName;
    	int numPagesRead, maxPages;
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter book name: ");
    	bookName = scanner.nextLine();
    	System.out.print("Enter total number of pages: ");
    	maxPages = scanner.nextInt();
    	scanner.nextLine();
    	System.out.print("Enter number of pages read: ");
    	numPagesRead = scanner.nextInt();
    	library.put(bookName, new Book(bookName, numPagesRead, maxPages));
    	
    }
   /* public boolean addBook(String bookName, int numPagesRead, int maxPages) {
        if (!this.library.containsKey(bookName)) {
            this.library.put(bookName, new Book(bookName, numPagesRead, maxPages));
            return true;
        }
        return false;
    }*/

    public static boolean removeBook(String b) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter name of book you wish to remove: ");
    	b = scanner.nextLine();
    	
        if (library.containsKey(b)) {
            library.remove(b);
            return true;
        }
        return false;
    }

    public static boolean setPageNumber(String bookName, int pageNumber) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Which book to change: ");
    	bookName = scanner.nextLine();
        if (library.containsKey(bookName)) {
        	bookName = scanner.nextLine();
        	System.out.print("Enter new page number: ");
            return library.get(bookName).setPages(pageNumber);
        }else{System.out.println("Invalid selection");}
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Book b : library.values()) {
            result.append(b.toString()).append("\n");
        }
        return result.toString();
    }
}
