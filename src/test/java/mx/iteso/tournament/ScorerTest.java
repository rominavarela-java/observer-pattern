package mx.iteso.tournament;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ScorerTest {
	
	private Scorer scorer;
	
	@Before
	public void setup() {
		this.scorer= new Scorer("name", 0, "p1");
	}
	
	@Test
	public void newScore() {
		long time1, time2;
		int score1, score2;
		int n= (int) (Math.random() * 10);
		
		time1= this.scorer.getTimestamp();
		score1= this.scorer.getScores();
		
		for(int i=0; i<n; i++)
			this.scorer.newScore();
		
		time2= this.scorer.getTimestamp();
		score2= this.scorer.getScores();
		
		Assert.assertTrue(time1 < time2);
		Assert.assertTrue(score2 == (score1+n));
	}
	
	@Test
	public void testToString() {
		String name= "n1";
		int number = (int) (Math.random() * 10);
		String position = "p1";
		int scores = (int) (Math.random() * 10);
		
		scorer.setName(name);
		scorer.setNumber(number);
		scorer.setPosition(position);
		scorer.setScores(scores);
		
		String s= scorer.toString();
		Assert.assertTrue(s.contains("name: " + name));
		Assert.assertTrue(s.contains("number: " + number));
		Assert.assertTrue(s.contains("position: " + position));
		Assert.assertTrue(s.contains("scores: " + scores));
	}
}
