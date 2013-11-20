
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;


public class Controller{
	ProductDB db = new ProductDB();
    HashMap <String, Product> contents = new HashMap <String, Product>();
    Cart cart = new Cart();
    
    Controller(){       
        contents = db.loadInventory();
    }

    String getItemInfo(String key){
       return contents.get(key).toString(); 
    }
    
    String getItemInventory(){
        Vector <String> keys = new Vector (contents.keySet());
        Collections.sort(keys);
        String msg = "";
        for (Enumeration <String> e = keys.elements(); e.hasMoreElements();){
            String key = e.nextElement();
            Product item = contents.get(key); 
            String ID;
            msg += item.name + ", " + item.ID + ", " + item.dbQty + "\n";
        }
        return msg;
    }
    String getCartInventory(){
        Vector <String> keys = new Vector (cart.contents.keySet());
        Collections.sort(keys);
        String msg = "";
        for (Enumeration <String> e = keys.elements(); e.hasMoreElements();){
            String key = e.nextElement();
            Product item = cart.contents.get(key); 
            if (item.cartQty != 0)
            msg += item.name + ", " + item.cartQty + "\n";
        }
        return msg;
    }
   
    
    
    public boolean addToCart(String productID){
        if(db.isInStock(productID)){
            cart.addProduct(productID);
            db.removeProduct(productID);
            return true;
        } else {
            return false;
        }
      }
    public boolean removeFromCart(String productID){
         if(cart.isInCart(productID)){
            cart.removeProduct(productID);
            db.addProduct(productID);
               return true;
            } else {
                return false;
            }
    }    
}      