import  java.util.List;
import java.util.ArrayList;

public class Library {

    private List<Book> books = new ArrayList<>();
    private  List<User>users = new ArrayList<>();
//add book
    public void addBook(Book book)
    {
        books.add(book);
    }
//add user
    public void registerUser(User user)
    {
        users.add(user);
    }
    //borrow book
    public void borrowBook(User user,Book book)
    {
        if(books.contains(book))
        {
            user.borrowBook(book);
        }
        else
        {
            System.out.println("Book Not Found In Library");
        }
    }
    //return book
    public void returnBook(User user, Book book)
    {
        user.returnBook(book);
    }
    //check available books
    public void listAvailableBook()
    {
        for(Book book:books)
        {
            System.out.println(book.getTitle());
        }
    }
    //book search by name
    public Book searchByTitle(String title)
    {
        for(Book book : books)
        {
            if(book.getTitle().equalsIgnoreCase(title))
            {
                return book;
            }
        }
        return null;
    }
    //book search by ISBN number
    public Book searchByISBN(String ISBN)
    {
        for(Book book:books)
        {
            if(book.getISBN().equalsIgnoreCase(ISBN))
            {
                return book;
            }
        }
        return null;
    }

    //Search Existing User
    public User findUserById(String memberId)
    {
        for (User user:users)
        {
            if(user.memberId.equalsIgnoreCase(memberId))
            {
                return user;
            }
        }
        return null;
    }

}
