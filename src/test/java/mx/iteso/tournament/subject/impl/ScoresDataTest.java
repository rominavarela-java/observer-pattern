package mx.iteso.tournament.subject.impl;

import mx.iteso.tournament.Team;
import mx.iteso.tournament.observer.Observer;
import mx.iteso.tournament.subject.impl.ScoresData;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ScoresDataTest {
    ScoresData scoresData;
    Observer observer;

    @Before
    public void setup() {
        scoresData = new ScoresData();
        observer = mock(Observer.class);
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void registerAndRemoveObserver() {
        scoresData.registerObserver(observer);
        scoresData.removeObserver(observer);
        scoresData.removeObserver(observer);
    }
    
    @Test
    public void notifyObservers() {
    	Team t1= new Team("t1");
    	t1.addScorer("ray", "p1");
    	Team t2= new Team("t2");
    	t1.addScorer("anti-ray", "p2");
    	
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        
        scoresData.setHomeTeam(t1);
        scoresData.setAwayTeam(t2);
        
        t1.getScorers().get(0).newScore();
        scoresData.notifyObservers();
    }
    
    @Test
    public void notifyObserversWithoutData() {    	
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        
        scoresData.notifyObservers();
    }
    
    @Test
    public void newScore() {
    	Team t1= new Team("t1");
    	t1.addScorer("ray", "p1");
    	Team t2= new Team("t2");
    	t1.addScorer("anti-ray", "p2");
    	
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        
        scoresData.setHomeTeam(t1);
        scoresData.setAwayTeam(t2);
        
        scoresData.newScore("ray");
    }
    
    @Test(expected= java.lang.NullPointerException.class )
    public void newScoreWithoutTeams() {
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        scoresData.newScore("ray");
    }
    
}
