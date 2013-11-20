
public class Video extends Product {

	String principleActors, format, year, runningTime, rating;
		   
	Video()
	{}
		   
	Video (String ID, String name, String desc, String author, String principleActors, String rating, String year, String runningTime, String format){
		super(ID, name, desc);
		this.principleActors = principleActors;
	}
		   
	public String toString(){
		return super.toString() + "\n" +
		   "Actors: " + principleActors + "\n" +
		   "Rating: " + rating + "\n" +
		   "Format: " + format + "\n" + 
		   "Running Time: " + runningTime;
	}
		           
}