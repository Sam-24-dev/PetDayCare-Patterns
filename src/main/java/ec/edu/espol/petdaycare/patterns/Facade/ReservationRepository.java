package ec.edu.espol.petdaycare.patterns.Facade;

import java.util.HashMap;
import java.util.Map;

import ec.edu.espol.petdaycare.patterns.Composite.ServiceComponent;

public class ReservationRepository {
    private Map<Integer, String> reservations = new HashMap<>();
    private int counter = 1;

    public int saveReservation(String petName, ServiceComponent service, String date) {
        reservations.put(counter, petName + " - " + service.getName() + " - " + date);
        return counter++;
    }

    public boolean exists(int bookingId) {
        return reservations.containsKey(bookingId);
    }

    public void delete(int bookingId) {
        reservations.remove(bookingId);
    }
}
