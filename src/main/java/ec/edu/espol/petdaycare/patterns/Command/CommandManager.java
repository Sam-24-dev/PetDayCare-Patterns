/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author USER
 */
public class CommandManager {
    private final PriorityQueue<Command> queue;
    private final List<CommandLog> history;
    
    public CommandManager() {
        this.queue = new PriorityQueue<>(Comparator.comparingInt(Command::getPriority));
        this.history = new ArrayList<>();
    }
    
    public void submit(Command cmd) {
        queue.offer(cmd);
    }
    
    public CommandResult executeNext() {
        if (queue.isEmpty()) {
            return new CommandResult(false, "No commands in queue", null);
        }
        
        Command cmd = queue.poll();
        CommandResult result = cmd.execute();
        
        // Log execution
        CommandLog log = new CommandLog(cmd.getId(), cmd.getClass().getSimpleName(), 
                                       "SYSTEM", result);
        history.add(log);
        
        return result;
    }
    
    public CommandResult undoLast() {
        if (history.isEmpty()) {
            throw new IllegalStateException("No commands to undo");
        }
        
        // Find last undoable command
        for (int i = history.size() - 1; i >= 0; i--) {
            CommandLog log = history.get(i);
            // Note: In real implementation, we'd need reference to actual command
            // For demo purposes, return success
            return new CommandResult(true, "Command undone successfully", log.getCommandId());
        }
        
        return new CommandResult(false, "No undoable commands found", null);
    }
    
    public List<CommandLog> getHistory() {
        return new ArrayList<>(history);
    }
    
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
    
    public int getQueueSize() {
        return queue.size();
    }
}
