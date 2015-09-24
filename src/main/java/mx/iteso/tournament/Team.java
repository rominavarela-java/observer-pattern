package mx.iteso.tournament;

import java.util.ArrayList;

public class Team {
	
	private String name;
	private ArrayList<Scorer> scorers;
	
	public Team(String name){
		this.name= name;
		this.scorers= new ArrayList<Scorer>();
	}
	
	public void addScorer(String name, String position){
		this.scorers.add(new Scorer(name, this.scorers.size(), position));
	}
	
	public Scorer getScorer(String name){
		for(Scorer s: this.scorers)
			if(s.getName().contentEquals(name))
				return s;
		return null;
	}
	
	public int getScore(){
		int score=0;
		for(Scorer s: scorers)
			score+= s.getScores();
		return score;
	}
	
	@Override
	public String toString(){
		return " team:"
				+ " { name: " + this.name
				+ ", score: " + this.getScore()
				+ " } ";
	}
	
	//getters and setters
	public String getName(){
		return this.name;
	}
	public ArrayList<Scorer> getScorers(){
		return this.scorers;
	}
	
	public void setName(String n){
		this.name= n;
	}
	public void setScorers(ArrayList<Scorer> s){
		this.scorers= s;
	}
}
