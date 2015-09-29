/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions3;

/**
 *
 * @author Josh
 */
public class main {

    public static void main(String[] args) 
    {
    ArrayList list1 = new ArrayList();
    ArrayList list3 = new ArrayList();
    list1.addFirst(100);
    list1.addFirst(72);
    list1.addFirst(100);
    list1.addFirst(200);
    list1.addFirst(100);
    list1.add(1, 50);
    list1.display();
    System.out.println();
//  list1.Q1(list1);
    
    ArrayList list2 = new ArrayList();
    list2.addFirst("Bob");
    list2.addFirst("Kappa");
    list2.addFirst("PogChamp");
    list2.addFirst("BibleThump");
    list2.display();
    
//    list2.Q2(list2);
    list2.display();
    
//    int i = (int) list1.get(0);
//    System.out.println(i);
    }
    
}
