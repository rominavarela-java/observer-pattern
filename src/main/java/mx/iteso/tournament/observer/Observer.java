package mx.iteso.tournament.observer;

import mx.iteso.tournament.Team;

public interface Observer {
    public void update(Team homeTeam, Team awayTeam);
}
