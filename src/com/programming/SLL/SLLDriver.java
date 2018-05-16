package com.programming.SLL;

import java.util.Scanner;

public class SLLDriver {

	public static void main(String args[])
	{
		
        Scanner scan = new Scanner(System.in);

        /* Creating object of class linkedList */

        SLL list = new SLL(); 

        System.out.println("Singly Linked List Test\n");          

        char ch;

        /*  Perform list operations  */

        do

        {

            System.out.println("\nSingly Linked List Operations\n");

            System.out.println("1. insert at end");

            System.out.println("2. insert at position");

            System.out.println("3. delete at position");

            System.out.println("4. check empty");

            System.out.println("5. reverse linkedlist");            

            int choice = scan.nextInt();            

            switch (choice)

            {

                                     

            case 1 : 

                System.out.println("Enter integer element to insert");

                list.InsertAtEnd(1);list.InsertAtEnd(1);list.InsertAtEnd(1);list.InsertAtEnd(1);list.InsertAtEnd(1);
                list.InsertAtEnd(2);list.InsertAtEnd(2);list.InsertAtEnd(2);list.InsertAtEnd(2);list.InsertAtEnd(2);
                list.InsertAtEnd(3);list.InsertAtEnd(3);list.InsertAtEnd(3);
                list.InsertAtEnd(4);list.InsertAtEnd(4);list.InsertAtEnd(4);list.InsertAtEnd(4);

                break;                         

            case 2 : 

                System.out.println("Enter integer element to insert ");

                int num = scan.nextInt() ;

                System.out.println("Enter position");

                int pos = scan.nextInt() ;
                
                list.InsertAtPosition(num, pos);

                break;                                          

            case 3 : 

                System.out.println("Enter position");

                int p = scan.nextInt() ;

                list.deleteAtPosition(p);

                break;

            case 4 : 

                System.out.println("Empty status = "+ list.isEmpty());

                break;                   
                        

            case 5 :
            	System.out.println("Reverse linkedlist");
            	list.reverseList();
            	break;
            	
            case 6 :
            	System.out.println( "Remove Duplicate from list ");
            	list.removeDuplicate();
            	break;
            	
             default : 

                System.out.println("Wrong Entry \n ");

                break;   

            }

            /*  Display List  */ 

            list.display();

            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);                        

        } while (ch == 'Y'|| ch == 'y');               

    }
}

