
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
    	return super.toString() + "\n" +
                "Author: " + author + "\n" +
                "Genre: " + genre + "\n" +
                "Number of Pages: " + numberPages + "\n";
    }
}
