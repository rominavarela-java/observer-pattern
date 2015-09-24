package mx.iteso.tournament.subject.impl;

import mx.iteso.tournament.Scorer;
import mx.iteso.tournament.Team;
import mx.iteso.tournament.observer.Observer;
import mx.iteso.tournament.subject.Subject;

import java.util.ArrayList;

public class ScoresData implements Subject {
    private ArrayList<Observer> observers;
    private Team homeTeam;
    private Team awayTeam;


    public ScoresData(){
        observers = new ArrayList<Observer>();
    }
    
    public ScoresData(Team homeTeam, Team awayTeam){
        observers = new ArrayList<Observer>();
        this.homeTeam= homeTeam;
        this.awayTeam= awayTeam;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observers.indexOf(observer));
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.homeTeam, this.awayTeam);
        }
    }

    public void newScore(String scorerName){
    	Scorer s= null;
    	
    	if((s=this.homeTeam.getScorer(scorerName))!=null)
    		s.newScore();
    	else if((s=this.awayTeam.getScorer(scorerName))!=null)
    		s.newScore();
    	else
    		return;
    	
        notifyObservers();
    }
    
    //getters and setters
    public Team getHomeTeam(){
    	return this.homeTeam;
    }
    public Team getAwayTeam(){
    	return this.awayTeam;
    }
    
    public void setHomeTeam(Team t){
    	this.homeTeam= t;
    }
    public void setAwayTeam(Team t){
    	this.awayTeam= t;
    }
}
