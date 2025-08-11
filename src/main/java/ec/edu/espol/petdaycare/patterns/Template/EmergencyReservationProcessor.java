package ec.edu.espol.petdaycare.patterns.Template;

public class EmergencyReservationProcessor extends ReservationProcessor {

    @Override
    protected void validateReservation() {
        System.out.println("Validacion prioritaria para emergencia...");
    }

    @Override
    protected void calculateCost() {
        System.out.println("Calculando tarifa de emergencia...");
    }

    @Override
    protected void makeReservation() {
        System.out.println("Reservando servicio de emergencia...");
    }

    @Override
    protected void notifyUser() {
        System.out.println("Notificando al usuario y al personal de emergencia");
    }
    
}
