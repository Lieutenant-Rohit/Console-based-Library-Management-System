import java.util.ArrayList;
import java.util.List;

public class PremiumMember extends User{
    private int maxBookAllowed = 10;
    private List<Book>borrowedBookss = new ArrayList<>();
    PremiumMember(String name, String id)
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

        if(borrowedBookss.size()>=maxBookAllowed)
        {
            System.out.println("Borrow limit Reached!....Please return a book first");
        }
        else {
            borrowedBookss.add(book);
            book.borrowBook();
        }
    }

    @Override
    public void returnBook(Book book) {
        if(borrowedBookss.contains(book))
        {
            borrowedBookss.remove(book);
            book.returnBook();
        }

        else {
            System.out.println("This member didn't borrow this book");
        }
    }

}
