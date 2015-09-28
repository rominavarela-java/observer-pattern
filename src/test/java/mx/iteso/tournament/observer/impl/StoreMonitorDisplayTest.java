package mx.iteso.tournament.observer.impl;

import mx.iteso.tournament.Team;
import mx.iteso.tournament.observer.impl.StoreMonitorDisplay;
import mx.iteso.tournament.subject.Subject;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class StoreMonitorDisplayTest {
    private StoreMonitorDisplay storeMonitorDisplay;
    private Subject scoresData;

    @Before
    public void setup() {
        scoresData = mock(Subject.class);
        storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
    }

    @Test
    public void display() {
    	Team t1= new Team("t1");
    	t1.addScorer("ray", "p1");
    	Team t2= new Team("t2");
    	t2.addScorer("anti-ray", "p2");
    	
    	storeMonitorDisplay.setHomeTeam(t1);
    	storeMonitorDisplay.setAwayTeam(t2);
    	
    	//no changes
    	storeMonitorDisplay.display();
    	
    	//1 change
    	t1.getScorers().get(0).newScore();
    	storeMonitorDisplay.display();
    	
    	//more changes
    	t2.getScorers().get(0).newScore();
    	storeMonitorDisplay.display();
    }
    
    @Test
    public void update() {
    	Team t1= new Team("t1");
    	t1.addScorer("ray", "p1");
    	Team t2= new Team("t2");
    	t1.addScorer("anti-ray", "p2");
    	
    	storeMonitorDisplay.update(t1, t2);
    }
}
