package recursiveknight;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static void main(String[] args)
    {
        RecursiveKnight test = new RecursiveKnight();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int row = scan.nextInt();
        System.out.println("Enter number of columns");
        int col = scan.nextInt();
        System.out.println("Enter starting column location");
        int scol = scan.nextInt();
        System.out.println("Enter starting row location");
        int srow = scan.nextInt();
        test.makeBoard(row,col,scol,srow);
        test.move();
        test.printBoard();
        
    }
}
