
public class Book extends Product
{
    String author, genre, numberPages;
    
    Book()
    {}
    
    Book (String ID, String name, String desc, String author, String genre, String numberPages)
    {
        super(ID, name, desc);
        this.author = author;
    }
    
    public String toString()
    {
    	return super.toString() +
                "<br>Author: " + author +
                "<br>Genre: " + genre +
                "<br>Number of Pages: " + numberPages;
    }
}
