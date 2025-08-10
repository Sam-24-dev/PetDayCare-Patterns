/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class OnHoldState implements ReservationState {
 @Override
    public TransitionResult confirm(ReservationContext ctx) {
        ctx.setState(new ConfirmedState());
        ctx.addStateTransition("ON_HOLD", "CONFIRMED", "Hold resolved");
        return new TransitionResult(true, "CONFIRMED", "Reservation confirmed from hold");
    }
    
    @Override
    public TransitionResult cancel(ReservationContext ctx, String reason) {
        ctx.setState(new CancelledState());
        ctx.addStateTransition("ON_HOLD", "CANCELLED", reason);
        return new TransitionResult(true, "CANCELLED", "Reservation cancelled");
    }
    
    @Override
    public TransitionResult modify(ReservationContext ctx, ChangeRequest changes) {
        return new TransitionResult(true, "ON_HOLD", "Reservation modified while on hold");
    }
    
    @Override
    public TransitionResult startService(ReservationContext ctx) {
        return new TransitionResult(false, "ON_HOLD", "Cannot start service while on hold");
    }
    
    @Override
    public TransitionResult completeService(ReservationContext ctx, ServiceReport report) {
        return new TransitionResult(false, "ON_HOLD", "Cannot complete service while on hold");
    }
    
    @Override
    public String getName() {
        return "ON_HOLD";
    }   
}
