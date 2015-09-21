/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;
import java.util.Scanner;
/**
 *
 * @author Josh
 */
public class CSinglyLinkedListTester 
{
    public static void main(String[] args)
    {
        CSinglyLinkedList list = new CSinglyLinkedList();
        System.out.print("Enter a group size. n = ");
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        list.CreateGroup(list,n);
        list.display();
        System.out.print("Enter the starting person. s = ");
        int s = S.nextInt();
        System.out.print("Enter how many people are skipped. k = ");
        int k = S.nextInt();
        list.Game(list,s,k);
        list.display();
        System.out.println("is your loser");
    }
}
