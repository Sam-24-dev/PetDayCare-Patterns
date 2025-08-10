/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class ConfirmedState implements ReservationState {

    @Override
     public TransitionResult confirm(ReservationContext ctx) {
        return new TransitionResult(false, "CONFIRMED", "Already confirmed");
    }

    @Override
    public TransitionResult cancel(ReservationContext ctx, String reason) {
        ctx.setState(new CancelledState());
        ctx.addStateTransition("CONFIRMED", "CANCELLED", reason);
        return new TransitionResult(true, "CANCELLED", "Reservation cancelled");
    }

    @Override
    public TransitionResult modify(ReservationContext ctx, ChangeRequest changes) {
        return new TransitionResult(true, "CONFIRMED", "Reservation modified");
    }

    @Override
    public TransitionResult startService(ReservationContext ctx) {
        ctx.setState(new InProgressState());
        ctx.addStateTransition("CONFIRMED", "IN_PROGRESS", "Service started");
        return new TransitionResult(true, "IN_PROGRESS", "Service started");
    }

    @Override
     public TransitionResult completeService(ReservationContext ctx, ServiceReport report) {
        return new TransitionResult(false, "CONFIRMED", "Cannot complete service before starting");
    }

    @Override
    public String getName() {
        return "CONFIRMED";
    }
    
}
