/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author USER
 */
public class ReservationEvent {
     private final String type;
    private final UUID reservationId;
    private final Map<String, Object> details;
    
    public ReservationEvent(String type, UUID reservationId) {
        this.type = type;
        this.reservationId = reservationId;
        this.details = new HashMap<>();
    }
    
    public String getType() { return type; }
    public UUID getReservationId() { return reservationId; }
    public Map<String, Object> getDetails() { return details; }
}
