public class Book implements Borrowable {
    String title;
    String author;
    String ISBN;
    boolean isAvailable = true;

    Book(String title,String author,String ISBN)
    {
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
    }

    @Override
    public void borrowBook() {
        if(isAvailable)
        {
            isAvailable = false;
            System.out.println("Book Borrowed Successfully");
        }
        else {
            System.out.println("Book is out of Stock");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
