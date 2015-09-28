package mx.iteso.tournament.subject.impl;

import junit.framework.Assert;
import mx.iteso.tournament.Scorer;
import mx.iteso.tournament.Team;
import mx.iteso.tournament.observer.Observer;
import mx.iteso.tournament.subject.impl.ScoresData;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ScoresDataTest {
    ScoresData scoresData;
    Observer observer;
    Team homeTeam, awayTeam;

    @Before
    public void setup() {
    	homeTeam= new Team("home");
    	homeTeam.addScorer("ray", "p1");
    	awayTeam= new Team("away");
    	awayTeam.addScorer("anti-ray", "p2");
    	
    	scoresData = new ScoresData();
        scoresData.setHomeTeam(homeTeam);
        scoresData.setAwayTeam(awayTeam);
    	
        observer = mock(Observer.class);
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void registerAndRemoveObserver() {
    	scoresData.registerObserver(observer);
    	scoresData.removeObserver(observer);
    	scoresData.removeObserver(observer);
    }
    
    @Test
    public void constructorWithParams() {
    	ScoresData scoresData= new ScoresData(homeTeam,awayTeam);
    	Assert.assertEquals(homeTeam.getName(), scoresData.getHomeTeam().getName());
    	Assert.assertEquals(awayTeam.getName(), scoresData.getAwayTeam().getName());
    }
    
    @Test
    public void notifyObservers() {
    	scoresData.registerObserver(observer);
    	scoresData.registerObserver(observer);
        
        homeTeam.getScorers().get(0).newScore();
        scoresData.notifyObservers();
    }
    
    @Test
    public void newScoreByHomeTeam() {
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        
        Scorer homeScorer= homeTeam.getScorers().get(0);
        Scorer awayScorer= awayTeam.getScorers().get(0);
        
        scoresData.newScore(homeScorer.getName());
        Assert.assertTrue( homeScorer.getTimestamp() > awayScorer.getTimestamp());
    }
    
    @Test
    public void newScoreByAwayTeam() {
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        
        Scorer homeScorer= homeTeam.getScorers().get(0);
        Scorer awayScorer= awayTeam.getScorers().get(0);
        
        scoresData.newScore(awayScorer.getName());
        Assert.assertTrue( awayScorer.getTimestamp() > homeScorer.getTimestamp());
    }
    
    @Test(expected= java.lang.NullPointerException.class )
    public void newScoreWithoutTeams() {
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        
        scoresData.setHomeTeam(null);
        scoresData.setAwayTeam(null);
        
        scoresData.newScore("ray");
    }
    
}
