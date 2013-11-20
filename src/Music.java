
public class Music extends Product
{
   String artist, genre, format;
   
   Music()
   {}
   
   Music (String ID, String name, String desc, String author, String artist)
   {
       super(ID, name, desc);
       this.artist = artist;
   }
   
   public String toString()
   {
       return super.toString() + "\n" +
              "Artist: " + artist + "\n" +
              "Genre: " + genre + "\n" +
              "Format: " + format + "\n"; 
              
   }
           
}
