import java.util.ArrayList;
import java.util.List;

public class RegularMember extends  User{
    private int maxBookAllowed = 3;
    private List<Book> borrowedBooks = new ArrayList<>();
    RegularMember(String name, String id)
    {
        super(name,id);
    }
    @Override
    public void borrowBook(Book book) {

        if(!book.isAvailable)
        {
            System.out.println("This Book is currently Unavailable");
            return;
        }

        if(borrowedBooks.size()>=maxBookAllowed)
        {
            System.out.println("Borrow limit Reached!....Please return a book first");
        }
        else {
            borrowedBooks.add(book);
            book.borrowBook();
        }
    }

    @Override
    public void returnBook(Book book) {

        if(borrowedBooks.contains(book))
        {
            borrowedBooks.remove(book);
            book.returnBook();
        }

        else {
            System.out.println("This member didn't borrow this book");
        }

    }
}
