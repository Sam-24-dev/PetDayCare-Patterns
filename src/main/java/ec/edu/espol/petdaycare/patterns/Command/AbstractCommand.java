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
public abstract class AbstractCommand implements Command{
     protected final UUID id;
    protected final User initiatedBy;
    protected final LocalDateTime timestamp;
    protected final int priority;
    protected boolean executed;
    protected Object backupData;

    
     public AbstractCommand(User initiatedBy, int priority) {
        this.id = UUID.randomUUID();
        this.initiatedBy = initiatedBy;
        this.timestamp = LocalDateTime.now();
        this.priority = priority;
        this.executed = false;
    }
    
    
    
    @Override
    public abstract CommandResult execute();
    
    @Override
    public abstract CommandResult undo();
    
    @Override
    public boolean canUndo() {
        return executed && backupData != null;
    }
    
    @Override
    public UUID getId() {
        return id;
    }
    
    @Override
    public int getPriority() {
        return priority;
    }
    
    protected void setExecuted(boolean executed) {
        this.executed = executed;
    }
    
    protected void saveBackup(Object data) {
        this.backupData = data;
    }
}
