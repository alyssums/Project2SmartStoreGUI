
abstract class Product
{
    String ID, name, desc;
    int dbQty;
    int cartQty;

    Product()
    {}
    
    Product (String ID)
    {
        this.ID = ID;
    }
    
    Product (String ID, String name)
    {
        this(ID);
        this.name = name;
    }
    
    Product(String ID, String name, String desc)
    {
        this(ID, name);
        this.desc = desc;
    }
    
    public String toString()
    {
      String msg = "";
      msg += "ID: " + this.ID + "\n";
      msg += "Name: " + this.name + "\n";
      msg += "Description: " + this.desc + "\n";
      msg += "Quantity: " + this.dbQty;
      return msg;
    }

    
    public void incrementCartQuantity(){
		cartQty++;
		
	}

	public void decrementCartQuantity(){
		if (cartQty != 0)
		cartQty--;
		else
			System.out.println("No items available to remove");
	}
	
    public void incrementInventoryQuantity(){
		dbQty++;
		
	}

	public void decrementInventoryQuantity(){
		if (dbQty != 0)
		dbQty-- ;
		else
			System.out.println("No items available in stock");
	}
}
