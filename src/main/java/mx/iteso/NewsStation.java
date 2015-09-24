package mx.iteso;

import mx.iteso.tournament.Team;
import mx.iteso.tournament.observer.impl.MobileDisplay;
import mx.iteso.tournament.observer.impl.StoreMonitorDisplay;
import mx.iteso.tournament.subject.impl.ScoresData;

public class NewsStation {
    public static void main( String[] args ){
    	
    	//teams
    	Team t1= new Team("Tacit Knowledge");
    	t1.addScorer("ray", "goleador");
    	
    	Team t2= new Team("Intel");
    	t2.addScorer("anti-ray", "goleador");
    	
    	//scores data        
        ScoresData scoresData1= new ScoresData(t1,t2);
        
        //displays
        new StoreMonitorDisplay(scoresData1);
        new MobileDisplay(scoresData1);
        
        //run
        scoresData1.newScore("ray");
        scoresData1.newScore("ray");
        scoresData1.newScore("ray");
        scoresData1.newScore("ray");
        scoresData1.newScore("anti-ray");
    }
}
