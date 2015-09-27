package mx.iteso.tournament;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {

	private Team team;
	
	@Before
	public void setup() {
		this.team= new Team("t1");
	}
	
	@Test
	public void addScorer() {
		int size1, size2;
		size1= team.getScorers().size();
		
		int n= (int) (Math.random() * 10);
		for(int i=0; i<n; i++)
			team.addScorer("name"+i, "p");

		size2= team.getScorers().size();
		Assert.assertTrue(size2 == size1+n);
	}
	
	@Test
	public void getScorer() {
		int n= (int) (Math.random() * 10);
		int index= (int) (Math.random() * n);
		
		for(int i=0; i<n; i++)
			team.addScorer("name"+i, "p");
		
		Scorer scorer= team.getScorer("name"+index);
		Assert.assertEquals(index, scorer.getNumber());
	}
	
	@Test
	public void getScore() {
		int score1, score2;
		score1= team.getScore();
		
		int n= (int) (Math.random() * 10);
		for(int i=0; i<n; i++)
			team.addScorer("name"+i, "p");
		
		for(Scorer s: team.getScorers())
			s.newScore();
		
		score2= team.getScore();
		Assert.assertTrue(score2 == score1+n);
	}
}
