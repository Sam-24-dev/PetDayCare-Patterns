package ec.edu.espol.petdaycare.patterns.Facade;

public class NotificationService {
    public void notifyBookingConfirmation(String petName, int bookingId) {
        System.out.println("Notificación: Reserva confirmada para " + petName + " con ID " + bookingId);
    }

    public void notifyCancellation(int bookingId) {
        System.out.println("Notificación: Reserva cancelada con ID " + bookingId);
    }
}

