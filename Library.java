import java.util.HashMap;

class Library {
    public HashMap<String, Book> library;
    public Library(HashMap<String, Book> library) {
        this.library = library;
    }

    public Library() {
        this.library = new HashMap<String, Book>();
    }

    public boolean addBook(String bookName, int numPagesRead, int maxPages) {
        if (!this.library.containsKey(bookName)) {
            this.library.put(bookName, new Book(bookName, numPagesRead, maxPages));
            return true;
        }
        return false;
    }

    public boolean removeBook(String b) {
        if (this.library.containsKey(b)) {
            this.library.remove(b);
            return true;
        }
        return false;
    }

    public boolean setPageNumber(String bookName, int pageNumber) {
        if (this.library.containsKey(bookName)) {
            return this.library.get(bookName).setPages(pageNumber);
        }
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