/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public interface ReservationState {
    TransitionResult confirm(ReservationContext ctx);
    TransitionResult cancel(ReservationContext ctx, String reason);
    TransitionResult modify(ReservationContext ctx, ChangeRequest changes);
    TransitionResult startService(ReservationContext ctx);
    TransitionResult completeService(ReservationContext ctx, ServiceReport report);
    String getName();
}
