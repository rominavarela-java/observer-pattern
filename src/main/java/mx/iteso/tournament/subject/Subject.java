package mx.iteso.tournament.subject;

import mx.iteso.tournament.observer.Observer;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
