/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

import java.time.LocalDateTime;

/**
 *
 * @author USER
 */
public class StateTransition {
    private final String fromState;
    private final String toState;
    private final LocalDateTime timestamp;
    private final String reason;
    
    public StateTransition(String fromState, String toState, String reason) {
        this.fromState = fromState;
        this.toState = toState;
        this.timestamp = LocalDateTime.now();
        this.reason = reason;
    }
    
    public String getFromState() { return fromState; }
    public String getToState() { return toState; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getReason() { return reason; }
}
