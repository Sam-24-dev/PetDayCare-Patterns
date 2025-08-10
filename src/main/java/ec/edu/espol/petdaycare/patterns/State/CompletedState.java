/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class CompletedState implements ReservationState {
    @Override
    public TransitionResult confirm(ReservationContext ctx) {
        return new TransitionResult(false, "COMPLETED", "Cannot confirm completed reservation");
    }
    
    @Override
    public TransitionResult cancel(ReservationContext ctx, String reason) {
        return new TransitionResult(false, "COMPLETED", "Cannot cancel completed reservation");
    }
    
    @Override
    public TransitionResult modify(ReservationContext ctx, ChangeRequest changes) {
        return new TransitionResult(false, "COMPLETED", "Cannot modify completed reservation");
    }
    
    @Override
    public TransitionResult startService(ReservationContext ctx) {
        return new TransitionResult(false, "COMPLETED", "Service already completed");
    }
    
    @Override
    public TransitionResult completeService(ReservationContext ctx, ServiceReport report) {
        return new TransitionResult(false, "COMPLETED", "Service already completed");
    }
    
    @Override
    public String getName() {
        return "COMPLETED";
    }
}
