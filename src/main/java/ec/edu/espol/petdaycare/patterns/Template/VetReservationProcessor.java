package ec.edu.espol.petdaycare.patterns.Template;

import java.util.function.BooleanSupplier;

public class VetReservationProcessor extends ReservationProcessor {
    private boolean vetStepExecuted ;
    
    @Override
    protected void validateReservation() {
        System.out.println("Reservando atención veterinaria...");
        vetStepExecuted = true;
        System.out.println("vetStepExecuted seteado a: " + vetStepExecuted);
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

    public boolean isVetStepExecuted() {
        return vetStepExecuted; 
    }
    
}
