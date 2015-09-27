package mx.iteso.tournament.observer.impl;

import mx.iteso.tournament.Displayable;
import mx.iteso.tournament.Scorer;
import mx.iteso.tournament.Team;
import mx.iteso.tournament.observer.Observer;
import mx.iteso.tournament.subject.Subject;

public class MobileDisplay implements Observer, Displayable {
    private Subject scoresData;
    
    private Team homeTeam;
    private Team awayTeam;

    public MobileDisplay(Subject scoresData){
        this.scoresData = scoresData;
        this.scoresData.registerObserver(this);
    }

    public void display() {
    	//display general info
        System.out.println("\n░░ news @ MOBILE DISPLAY");
        System.out.println(homeTeam + " - " + awayTeam);
        
        //find changes
        long lastTime = 0;
        Scorer lastScorer= null;
        for(Scorer s: homeTeam.getScorers())
        	if(s.getTimestamp()>lastTime)
        	{
        		lastTime = s.getTimestamp();
                lastScorer= s;
        	}
        for(Scorer s: awayTeam.getScorers())
        	if(s.getTimestamp()>lastTime)
        	{
        		lastTime = s.getTimestamp();
                lastScorer= s;
        	}
        
        //display changes
        if(lastScorer!=null)
            System.out.println(lastScorer);
        
    }

    public void update(Team homeTeam, Team awayTeam) { 	
    	this.setHomeTeam(homeTeam);
        this.setAwayTeam(awayTeam);
        display();
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