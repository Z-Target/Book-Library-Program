import java.util.Arrays;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int menu;
        
        do
       	
        {
        	System.out.println("Welcome to the library");
            System.out.println("What would you like to do?");
            System.out.println("Options: \n1. add book\n" + "2. remove book\n3. set page number\n4. view library\n5. quit");
            System.out.print("Enter your option here: ");
        menu = scanner.nextInt();
        switch (menu)
        {
        	case 1:	Library.addBook();
        			break;
        	case 2: Library.removeBook(null);
        			break;
        	case 3: Library.setPageNumber(null, menu);
        			break;
        	case 4: System.out.println(library.toString());
        			break; 	
        	case 5: System.out.println("Thank you");
        			break;
        	default: System.out.println("Invalid option");
        			break;
        }
        }while(menu < 5);


    }
}
