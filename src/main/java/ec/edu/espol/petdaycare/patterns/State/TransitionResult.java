/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

/**
 *
 * @author USER
 */
public class TransitionResult {
     private final boolean success;
    private final String newState;
    private final String message;
    
    public TransitionResult(boolean success, String newState, String message) {
        this.success = success;
        this.newState = newState;
        this.message = message;
    }
    
    public boolean isSuccess() { return success; }
    public String getNewState() { return newState; }
    public String getMessage() { return message; }
}
