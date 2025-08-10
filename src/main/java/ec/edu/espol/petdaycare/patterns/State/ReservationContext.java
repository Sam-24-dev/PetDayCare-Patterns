/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author USER
 */
public class ReservationContext {
     private final UUID reservationId;
    private final Reservation reservation;
    private ReservationState currentState;
    private final List<StateTransition> stateHistory;
    private final List<ReservationObserver> observers;
    
    public ReservationContext(UUID reservationId, Reservation reservation) {
        this.reservationId = reservationId;
        this.reservation = reservation;
        this.currentState = new PendingState();
        this.stateHistory = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    
    
    public void setState(ReservationState state) {
        this.currentState = state;
    }
    
    public TransitionResult confirm() {
        return currentState.confirm(this);
    }
    
    public TransitionResult cancel(String reason) {
    if (reason == null) {
        throw new IllegalArgumentException("reason no puede ser null");
    }
    return currentState.cancel(this, reason);
}    
    public TransitionResult modify(ChangeRequest changes) {
        return currentState.modify(this, changes);
    }
    
    public TransitionResult startService() {
        return currentState.startService(this);
    }
    
    public TransitionResult completeService(ServiceReport report) {
        return currentState.completeService(this, report);
    }
    
    public void registerObserver(ReservationObserver observer) {
        observers.add(observer);
    }
    
    public void addStateTransition(String fromState, String toState, String reason) {
        stateHistory.add(new StateTransition(fromState, toState, reason));
    }
    
    public void notifyObservers(String eventType) {
        ReservationEvent event = new ReservationEvent(eventType, reservationId);
        for (ReservationObserver observer : observers) {
            observer.update(event);
        }
    }
    
    public String getCurrentStateName() {
        return currentState.getName();
    }
    
    public List<StateTransition> getStateHistory() {
        return new ArrayList<>(stateHistory);
    }
    
    public Reservation getReservation() {
        return reservation;
    }
    
    public UUID getReservationId() {
        return reservationId;
    }

    
}
