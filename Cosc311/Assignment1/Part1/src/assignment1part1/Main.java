package assignment1part1;
import java.util.Scanner;
/**
 * @author Josh
 */
public class Main
{
    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
        //  Handle any exceptions.
        }
    }
    public static void main(String[] args)
    {
        Scanner S = new Scanner(System.in); //Scanner for non-Strings
        Scanner scan = new Scanner(System.in); //2nd scanner for Strings
        BooksCustomers database = new BooksCustomers();
        System.out.println("Welcome to the Online Bookstore");
        char n = 'z'; 
        while (n != 'g')
        {
            clearConsole();
            System.out.println("Please choose an option");
            System.out.println("A) to add a book");
            System.out.println("B) to order a book");
            System.out.println("C) to sell a book");
            System.out.println("D) to cancel an order");
            System.out.println("E) to display information on a book");
            System.out.println("F) to display status of all books");
            System.out.println("G) to exit");
            n = S.next(".").charAt(0); //get char
            if(n == 'a')
            {
                System.out.println("Enter the book title");
                String title = scan.nextLine();
                System.out.println("Enter the book price");
                int price = S.nextInt();
                database.addBook(title, price);
            }
            if(n == 'b')
            {
                System.out.println("Enter the book title");
                String title = scan.nextLine();
                System.out.println("Enter customer last name");
                String lname = scan.nextLine();
                System.out.println("Enter number of coipes");
                int copies = S.nextInt();
                database.orderBook(title,lname,copies);
            }
            if(n == 'c')
            {
                System.out.println("Enter the book title");
                String title = scan.nextLine();
                database.sellBook(title);
            }
            if(n == 'd')
            {
                System.out.println("Enter the book title");
                String title = scan.nextLine();
                System.out.println("Enter customer last name");
                String lname = scan.nextLine();
                database.cancelBook(title, lname);
            }
            if(n == 'e')
            {
                System.out.println("Enter the book title");
                String title = scan.nextLine();
                database.bookInfo(title);
            }
            if(n == 'f')
            {
                database.allInfo();
            }
            
        }
    }
}
