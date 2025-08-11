package ec.edu.espol.petdaycare.patterns.Template;

abstract class ReservationProcessor {
    
    public final void process(){
        validateReservation();
        calculateCost();
        makeReservation();
        notifyUser();
    }

    protected abstract void validateReservation();
    protected abstract void calculateCost();
    protected abstract void makeReservation();
    protected abstract void notifyUser();
}
