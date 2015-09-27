package mx.iteso.tournament.observer.impl;

import mx.iteso.tournament.Team;
import mx.iteso.tournament.subject.Subject;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MobileDisplayTest {
    private MobileDisplay mobileDisplay;
    private Subject scoresData;

    @Before
    public void setup() {
        scoresData = mock(Subject.class);
        mobileDisplay = new MobileDisplay(scoresData);
    }

    @Test
    public void display() {
    	Team t1= new Team("t1");
    	t1.addScorer("ray", "p1");
    	Team t2= new Team("t2");
    	t1.addScorer("anti-ray", "p2");
    	
    	mobileDisplay.setHomeTeam(t1);
    	mobileDisplay.setAwayTeam(t2);
    	
    	mobileDisplay.display();
    }
    
    @Test
    public void update() {
    	Team t1= new Team("t1");
    	t1.addScorer("ray", "p1");
    	Team t2= new Team("t2");
    	t1.addScorer("anti-ray", "p2");
    	
    	mobileDisplay.update(t1, t2);
    }
}
