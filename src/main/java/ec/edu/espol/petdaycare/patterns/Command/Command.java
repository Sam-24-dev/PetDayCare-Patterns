/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.util.UUID;

/**
 *
 * @author USER
 */
public interface Command {
    CommandResult execute();
    CommandResult undo();
    boolean canUndo();
    UUID getId();
    int getPriority();
}
