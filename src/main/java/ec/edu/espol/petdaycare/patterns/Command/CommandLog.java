/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author USER
 */
public class CommandLog {
    private final UUID commandId;
    private final String type;
    private final String executedBy;
    private final LocalDateTime timestamp;
    private final CommandResult result;
    
    public CommandLog(UUID commandId, String type, String executedBy, CommandResult result) {
        this.commandId = commandId;
        this.type = type;
        this.executedBy = executedBy;
        this.timestamp = LocalDateTime.now();
        this.result = result;
    }
    
    public UUID getCommandId() { return commandId; }
    public String getType() { return type; }
    public String getExecutedBy() { return executedBy; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public CommandResult getResult() { return result; }
}
