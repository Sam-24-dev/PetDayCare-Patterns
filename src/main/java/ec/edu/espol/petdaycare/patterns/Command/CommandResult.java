/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.util.UUID;

/**
 *
 * @author USER
 */
public class CommandResult {
  private final boolean success;
    private final String message;
    private final UUID commandId;
    public CommandResult(boolean success, String message, UUID commandId) {
        this.success = success; this.message = message; this.commandId = commandId;
    }
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public UUID getCommandId() { return commandId; }   
}
