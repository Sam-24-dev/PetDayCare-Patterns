package ec.edu.espol.petdaycare.patterns.Template;

class StandartReservationProcess extends ReservationProcessor {
    
    @Override
    protected void validateReservation(){
        System.out.println("Validando reserva estandar...");
    }

    @Override
    protected void calculateCost(){
        System.out.println("Calculando costo de reserva estandar...");
    }

    @Override
    protected void makeReservation(){
        System.out.println("Haciendo reservacion estandar...");
    }

    @Override
    protected void notifyUser() {
        System.out.println("Notificando al usuario...");
    }

}
