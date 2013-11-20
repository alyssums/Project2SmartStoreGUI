
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StoreUI{
    StoreUI(){
    	
    	JFrame welcomeFrame = new JFrame("SmartStore.com");
		JOptionPane.showMessageDialog(welcomeFrame, 
				"Welcome to SmartStore.com!", 
				"SmartStore.com", 
				JOptionPane.INFORMATION_MESSAGE);
		
    	
        Controller ctrl = new Controller();
        
        System.out.println("1 - List");
        System.out.println("2 - Details");
        System.out.println("3 - Cart");
        System.out.println("4 - Add");
        System.out.println("5 - Return");
        System.out.println("6 - Help");
        System.out.println("7 - Quit");
        boolean done = false;
        while (!done){
            System.out.println("Enter selection > ");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();{
            	System.out.println("");
            }
            if (input.equals("List") | input.equals("list")){
                System.out.println(ctrl.getItemInventory());
            } else if (input.equals("Cart") | input.equals("cart")){
            	System.out.println(ctrl.getCartInventory()); 
            } else if (input.equals ("Add") | input.equals("add")){
            	System.out.print("Enter transaction date (mm/dd/yyyy) > ");
            	Scanner scanDate = new Scanner (System.in);
            	scan.useDelimiter("/");
            	String date = scanDate.nextLine();
            	Transaction.isValidDate(date);{
            		if (Transaction.isValidDate(date) == true)
            			System.out.println("Valid Date");
            	}
            	System.out.print("Key code > ");
            	Scanner scanProductID = new Scanner (System.in);
            	String productID = scanProductID.nextLine().toUpperCase();
            	if (ctrl.addToCart(productID) == true)
                    System.out.println("Added to cart!");
            	else
                    System.out.println("Item not added; invalid item");
            } else if (input.equals ("Remove") | input.equals("remove")){
            	System.out.print("Enter transaction date (mm/dd/yyyy) > ");
            	Scanner scanDate = new Scanner (System.in);
            	scan.useDelimiter("/");
            	String date = scanDate.nextLine();
            	Transaction.isValidDate(date);{
            		if (Transaction.isValidDate(date) == true)
            			System.out.println("Valid Date");
            		}
            	System.out.print("Key code > ");
            	Scanner scanProductID = new Scanner (System.in);
            	String productID = scanProductID.nextLine().toUpperCase();
            	{
            		if (ctrl.removeFromCart(productID) == true)
            			System.out.println("Removed from cart!");
            		else
            			System.out.println("Item not removed; invalid item");
            	}
            } else if (input.equals ("Help") | input.equals ("help")){
            	  System.out.println("Menu");
                  System.out.println("1 - List");
                  System.out.println("2 - Details");
                  System.out.println("3 - Cart");
                  System.out.println("4 - Add");
                  System.out.println("5 - Return");
                  System.out.println("6 - Help");
                  System.out.println("7 - Quit");
            } else if (input.equals ("Details") | input.equals ("details")){
               System.out.print("Key code > ");
               Scanner scanKey = new Scanner(System.in);
               String key = scanKey.nextLine().toUpperCase();
               System.out.println(ctrl.getItemInfo(key)); 
            } else if (input.equals("Quit") | input.equals("quit")){
                   System.out.print("Are you sure (y/n)?>");
                   Scanner scan1 = new Scanner(System.in);
                   String input1 = scan1.nextLine().toLowerCase();
                   	if (input1.equals("y"))
                       done = true;
                   	else 
                   		continue;
                   		scan1.close();
            } else {
            	System.out.println("I don't understand command '" + input + "'.");
            
            }
        
        }
    }

	private JComponent createUI() {
		// TODO Auto-generated method stub
		return null;
	}
}

