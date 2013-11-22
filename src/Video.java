
public class Video extends Product {

	String principleActors, format, year, runningTime, rating;
		   
	Video()
	{}
		   
	Video (String ID, String name, String desc, String author, String principleActors, String rating, String year, String runningTime, String format){
		super(ID, name, desc);
		this.principleActors = principleActors;
	}
		   
	public String toString(){
		return super.toString() +
		   "<br>Actors: " + principleActors + "\n" +
		   "<br>Rating: " + rating + "\n" +
		   "<br>Format: " + format + "\n" + 
		   "<br>Running Time: " + runningTime;
	}
		           
}