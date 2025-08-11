package ec.edu.espol.petdaycare.patterns.Template;

public class VetReservationProcessor extends ReservationProcessor {

    @Override
    protected void validateReservation() {
        System.out.println("Validando datos medicos del paciente");
    }

    @Override
    protected void calculateCost() {
        System.out.println("Calculando costos con servicio veterinario");
    }

    @Override
    protected void makeReservation() {
        System.out.println("Reservando cita veterinaria");
    }

    @Override
    protected void notifyUser() {
        System.out.println("Enviando confirmacion de cita veterinaria");
    }
    
}
