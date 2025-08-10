/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class PendingState implements ReservationState {

    @Override
    public TransitionResult confirm(ReservationContext ctx) {
        // Lógica de validación: payment, dates, caregiver
        ctx.setState(new ConfirmedState());
        ctx.addStateTransition("PENDING", "CONFIRMED", "Payment confirmed");
        return new TransitionResult(true, "CONFIRMED", "Confirmed successfully");
    }
    @Override
    public TransitionResult cancel(ReservationContext ctx, String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            return new TransitionResult(false, "PENDING", "Cancel reason required");
        }
        ctx.setState(new CancelledState());
        ctx.addStateTransition("PENDING", "CANCELLED", reason);
        return new TransitionResult(true, "CANCELLED", "Reservation cancelled");
    }

    @Override
    public TransitionResult modify(ReservationContext ctx, ChangeRequest changes) {
        // Pending permite modificaciones
        return new TransitionResult(true, "PENDING", "Reservation modified");
    }

    @Override
   public TransitionResult startService(ReservationContext ctx) {
        return new TransitionResult(false, "PENDING", "Cannot start service from pending state");
    }

    @Override
     public TransitionResult completeService(ReservationContext ctx, ServiceReport report) {
        return new TransitionResult(false, "PENDING", "Cannot complete service from pending state");
    }

    @Override
     public String getName() {
        return "PENDING";
    }
    
}
