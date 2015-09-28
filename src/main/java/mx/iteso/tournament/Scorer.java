package mx.iteso.tournament;

public class Scorer {
	private String name;
	private int number;
	private String position;
	private int scores;
	private long timestamp;
	
	/**
	 * @param name
	 * @param number
	 * @param position
	 * @param team
	 */
	public Scorer(String name, int number, String position){
		this.name= name;
		this.number= number;
		this.position= position;
		this.scores= 0;
		this.timestamp = 0;
	}
	
	public void newScore(){
		this.scores++;
		this.timestamp = System.currentTimeMillis();
	}
	
	@Override
	public String toString(){
		return " scorer:"
				+ " { name: " + this.name
				+ ", number: " + this.number
				+ ", position: " + this.position
				+ ", scores: " + this.scores
				+ " } ";
	}
	
	//getters and setters
	public String getName(){
		return this.name;
	}
	public int getNumber(){
		return this.number;
	}
	public String getPosition(){
		return this.position;
	}
	public int getScores(){
		return this.scores;
	}
	public long getTimestamp(){
		return this.timestamp;
	}
	
	public void setName(String n){
		this.name= n;
	}
	public void setNumber(int n){
		this.number= n;
	}
	public void setPosition(String p){
		this.position= p;
	}
	public void setScores(int s){
		this.scores= s;
	}
	public void setTimestamp(long t){
		this.timestamp= t;
	}
}
