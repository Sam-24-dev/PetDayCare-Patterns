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
public class ReassignCaretakerCommand  extends AbstractCommand {
    private final UUID reservationId;
    private final UUID newCaretakerId;
    private final ReservationService reservationService;
    
    public ReassignCaretakerCommand(UUID reservationId, UUID newCaretakerId, User initiatedBy, ReservationService service) {
        super(initiatedBy, 1); // High priority
        this.reservationId = reservationId;
        this.newCaretakerId = newCaretakerId;
        this.reservationService = service;
    }
    
    @Override
    public CommandResult execute() {
        try {
            boolean result = reservationService.reassignCaretaker(reservationId, newCaretakerId);
            setExecuted(true);
            
            if (result) {
                return new CommandResult(true, "Caretaker reassigned successfully", getId());
            } else {
                return new CommandResult(false, "Failed to reassign caretaker", getId());
            }
        } catch (Exception e) {
            return new CommandResult(false, "Error reassigning caretaker: " + e.getMessage(), getId());
        }
    }
    
    @Override
    public CommandResult undo() {
        // Implementación específica de undo para reassignment
        return new CommandResult(false, "Undo not supported for caretaker reassignment", getId());
    }
}
