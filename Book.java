public class Book {
    public boolean complete;
    public int numPagesRead;
    public int maxPages;
    public String bookName;

    public Book(String bookName, int numPagesRead, int maxPages) {
        if (numPagesRead < 0) {
            numPagesRead = 0;
        } else if (numPagesRead > maxPages) {
            numPagesRead = maxPages;
        }
        this.complete = (numPagesRead == maxPages);
        this.bookName = bookName;
        this.numPagesRead = numPagesRead;
        this.maxPages = maxPages;
    }

    public Book(String bookName, int maxPages) {
        this.complete = false;
        this.bookName = bookName;
        this.maxPages = maxPages;
        this.numPagesRead = 0;
    }

    public boolean setPages(int pageNumber) {
        // Invalid page number
        if (pageNumber < 0 || pageNumber > maxPages) {
            return false;
        }
        if (pageNumber == maxPages) {
            this.complete = true;
        } else {
            this.complete = false;
        }
        this.numPagesRead = pageNumber;
        return true;
    }

    public void setComplete() {
        this.complete = true;
    }

    @Override
    public String toString() {
        return "Title: \"" + this.bookName + "\" Completion: " + this.complete + " Pages Read: " +
                this.numPagesRead + "/" + this.maxPages;
    }
}
