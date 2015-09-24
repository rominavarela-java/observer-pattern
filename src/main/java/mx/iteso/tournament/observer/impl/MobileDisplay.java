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
        System.out.println("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░");
        System.out.println("░░ news @ MOBILE DISPLAY");
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
        
        System.out.println("                                                                                                ░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }

    public void update(Team homeTeam, Team awayTeam) {    	
    	this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        display();
    }

}