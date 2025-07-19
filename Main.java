import java.sql.SQLOutput;
import  java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public  class Main
{
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        //Create Library
        Library library = new Library();
        List<Book>bookList = new ArrayList<>();

        //Add Books to Library
        bookList.add(new Book("Twisted Hate","Ana Huang","ISBN001"));
        bookList.add(new Book("Twisted Love","Ana Huang","ISBN002"));
        bookList.add(new Book("Twisted Games","Ana Huang","ISBN003"));
        bookList.add(new Book("Twisted Lies","Ana Huang","ISBN004"));
        bookList.add(new Book("It Ends With Us","Collen Hover","ISBN0011"));
        bookList.add(new Book("It Starts with Us","Collen Hover","ISBN0012"));
        bookList.add(new Book("Heart N Bones","Collen Hover","ISBN0013"));
        bookList.add(new Book("UGLY Love","Collen Hover","ISBN0014"));

        for(Book book: bookList)
        {
            library.addBook(book);
        }

        System.out.println("---------WELCOME---------");
        System.out.println("1---->New User");
        System.out.println("2---->Existing User");
        int ch = sc.nextInt();
        sc.nextLine();

        User currentUser = null;

        //Registering User
        if(ch == 1)
        {
            System.out.println("\n---Register as New Member");
            System.out.println("Enter your name");
            String username = sc.nextLine();


            System.out.println("Enter your member id");
            String userid = sc.nextLine();

            System.out.println("Choice Member Type \n1---> Regular Member\n2--->Premium Member");
            int memberType = sc.nextInt();


            if (memberType == 1)
            {
                currentUser = new RegularMember(username, userid);
                library.registerUser(currentUser);
                System.out.println("You are Now Registered");
            }
            else if (memberType == 2)
            {
                currentUser = new PremiumMember(username, userid);
                library.registerUser(currentUser);
                System.out.println("You are Now Registered");
            }
            else
            {
                System.out.println("Wrong Input");
            }

        }

        else if (ch == 2)
        {
            System.out.println("Enter Your Member ID");
            String id = sc.nextLine();

            currentUser = library.findUserById(id);

            if(currentUser!=null)
            {
                System.out.println("Welcome Back!!!... "+currentUser.name);
            }
            else
            {
                System.out.println("User Not Found");
            }
        }
        else
        {
            System.out.println("Invalid Choice");
        }


        System.out.println("----WELCOME TO LIBRARY----");
        System.out.println("1--->Search Book By Name");
        System.out.println("2--->Search Book By ISBN");
        System.out.println("3--->EXIT");
        System.out.println("Enter Choice");

        int choice = sc.nextInt();
        sc.nextLine();

        Book mybook = null;
        switch (choice)
        {
            case 1:
            {
                System.out.println("Enter Book Name");
                String input = sc.nextLine();
                mybook = library.searchByTitle(input);
                break;
            }
            case 2:
            {
                System.out.println("Enter ISBN Number");
                String input = sc.nextLine();
                mybook = library.searchByISBN(input);
                break;
            }
            case 3:
            {
                System.out.println("Thank YOU!!!........");
                break;
            }
        }

        if( mybook != null)
        {
            System.out.println("Book Found "+mybook.getTitle());
            library.borrowBook(currentUser,mybook);
        }
        else {
            System.out.println("Book Not Found");
        }


        System.out.println("----Available Books----");
        library.listAvailableBook();

    }
}