/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class CancelledState  implements ReservationState{
     @Override
    public TransitionResult confirm(ReservationContext ctx) {
        return new TransitionResult(false, "CANCELLED", "Cannot confirm cancelled reservation");
    }
    
    @Override
    public TransitionResult cancel(ReservationContext ctx, String reason) {
        return new TransitionResult(false, "CANCELLED", "Already cancelled");
    }
    
    @Override
    public TransitionResult modify(ReservationContext ctx, ChangeRequest changes) {
        return new TransitionResult(false, "CANCELLED", "Cannot modify cancelled reservation");
    }
    
    @Override
    public TransitionResult startService(ReservationContext ctx) {
        return new TransitionResult(false, "CANCELLED", "Cannot start cancelled service");
    }
    
    @Override
    public TransitionResult completeService(ReservationContext ctx, ServiceReport report) {
        return new TransitionResult(false, "CANCELLED", "Cannot complete cancelled service");
    }
    
    @Override
    public String getName() {
        return "CANCELLED";
    }
}
