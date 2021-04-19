import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the library");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("Options: \n1. add book <book name> <current page number (optional)> <max pages>\n" +
                    "2. remove book <book name>\n3. set page number <book name> <page number>\n4. view library\n5. quit");
            System.out.println("Enter your option here: ");
            String line = scanner.nextLine();
            if (line.equals("quit")) {
                return;
            } else if (line.length() > 9 && line.substring(0, 9).equals("add book ")) {
                String[] params = line.split("add book ")[1].split(" ");
                if (params.length == 2 || params.length == 3) {
                    String bookName = params[0];
                    if (params.length == 2) {
                        try {
                            int maxPages = Integer.parseInt(params[1]);
                            if (!library.addBook(bookName, 0, maxPages)) {
                                System.out.println("Book already exists");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                    } else {
                        try {
                            int numPagesRead = Integer.parseInt(params[1]);
                            int maxPages = Integer.parseInt(params[2]);
                            library.addBook(bookName, numPagesRead, maxPages);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if (line.length() > 12 && line.substring(0, 12).equals("remove book ")) {
                String[] params = line.split("remove book ")[1].split(" ");
                if (params.length == 1) {
                    if (!library.removeBook(params[0])) {
                        System.out.println("Book does not exist");
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if (line.length() > 16 && line.substring(0, 16).equals("set page number ")) {
                String[] params = line.split("set page number ")[1].split(" ");
                if (params.length == 2) {
                    String bookName = params[0];
                    try {
                        int pageNumber = Integer.parseInt(params[1]);
                        if (!library.setPageNumber(bookName, pageNumber)) {
                            System.out.println("Set page number failed");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if (line.length() == 12 && line.equals("view library")) {
                System.out.println(library.toString());
            } else {
                System.out.println("Invalid input");
            }

        }

    }
}
