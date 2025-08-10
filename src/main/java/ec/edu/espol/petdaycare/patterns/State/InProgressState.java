/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class InProgressState implements ReservationState{
     @Override
    public TransitionResult confirm(ReservationContext ctx) {
        return new TransitionResult(false, "IN_PROGRESS", "Already in progress");
    }
    
    @Override
    public TransitionResult cancel(ReservationContext ctx, String reason) {
        ctx.setState(new CancelledState());
        ctx.addStateTransition("IN_PROGRESS", "CANCELLED", reason);
        return new TransitionResult(true, "CANCELLED", "Service cancelled");
    }
    
    @Override
    public TransitionResult modify(ReservationContext ctx, ChangeRequest changes) {
        return new TransitionResult(false, "IN_PROGRESS", "Cannot modify reservation in progress");
    }
    
    @Override
    public TransitionResult startService(ReservationContext ctx) {
        return new TransitionResult(false, "IN_PROGRESS", "Service already started");
    }
    
    @Override
    public TransitionResult completeService(ReservationContext ctx, ServiceReport report) {
        ctx.setState(new CompletedState());
        ctx.addStateTransition("IN_PROGRESS", "COMPLETED", "Service completed with rating: " + report.getRating());
        ctx.notifyObservers("SERVICE_COMPLETED");
        return new TransitionResult(true, "COMPLETED", "Service completed");
    }
    
    @Override
    public String getName() {
        return "IN_PROGRESS";
    }
}
