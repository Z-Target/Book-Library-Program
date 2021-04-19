import java.util.Arrays;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the library");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("Options: \n1. add book <\"book name\"> <current page number (optional)> <max pages>\n" +
                    "2. remove book <\"book name\">\n3. set page number <\"book name\"> <page number>\n4. view library\n5. quit");
            String line = scanner.nextLine();
            if (line.equals("quit")) {
                return;
            } else if (line.length() > 9 && line.startsWith("add book ")) {
                String[] params = line.split("add book ")[1].split("\"*\"");
                if (params.length != 3) {
                    System.out.println("Invalid input");
                    continue;
                }
                String bookName = params[1];
                String[] additionalParams = params[2].trim().split(" ");
                if (additionalParams.length == 1) {
                    try {
                        int maxPages = Integer.parseInt(additionalParams[0]);
                        if (!library.addBook(bookName, 0, maxPages)) {
                            System.out.println("Book already exists");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                } else if (additionalParams.length == 2) {
                    try {
                        int numReadPages = Integer.parseInt(additionalParams[0]);
                        int maxPages = Integer.parseInt(additionalParams[1]);
                        if (!library.addBook(bookName, numReadPages, maxPages)) {
                            System.out.println("Book already exists");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else if (line.length() > 12 && line.startsWith("remove book ")) {
                String[] params = line.split("remove book ")[1].split("\"*\"");
                if (params.length != 2) {
                    System.out.println("Invalid input");
                    continue;
                }
                String bookName = params[1];
                if (!library.removeBook(bookName)) {
                    System.out.println("Book does not exist");
                }
            } else if (line.length() > 16 && line.startsWith("set page number ")) {
                String[] params = line.split("set page number ")[1].split("\"*\"");
                if (params.length != 3) {
                    System.out.println("Invalid input");
                    continue;
                }
                String bookName = params[1];
                String[] additionalParams = params[2].trim().split(" ");
                System.out.println(Arrays.toString(additionalParams));
                if (additionalParams.length != 1) {
                    System.out.println("Invalid input");
                } else {
                    try {
                        int pageNumber = Integer.parseInt(additionalParams[0]);
                        if (!library.setPageNumber(bookName, pageNumber)) {
                            System.out.println("Set page number failed");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                }
            } else if (line.length() == 12 && line.equals("view library")) {
                System.out.println(library.toString());
            } else {
                System.out.println("Invalid input 222");
            }

        }

    }
}
