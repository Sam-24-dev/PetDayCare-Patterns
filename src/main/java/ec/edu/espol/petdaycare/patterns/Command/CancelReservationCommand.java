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
public class CancelReservationCommand extends AbstractCommand  {
   private final UUID reservationId;
    private final String reason;
    private final ReservationService reservationService;
    
    public CancelReservationCommand(UUID reservationId, String reason, User initiatedBy, ReservationService service) {
        super(initiatedBy, 2); // Priority normal
        this.reservationId = reservationId;
        this.reason = reason;
        this.reservationService = service;
    }
    
    @Override
    public CommandResult execute() {
        try {
            // Guardar backup antes de cancelar
            saveBackup("CONFIRMED"); // Simulamos estado anterior
            
            boolean result = reservationService.cancelReservation(reservationId, reason);
            setExecuted(true);
            
            if (result) {
                return new CommandResult(true, "Reservation cancelled successfully", getId());
            } else {
                return new CommandResult(false, "RESERVATION_NOT_FOUND", getId());
            }
        } catch (Exception e) {
            return new CommandResult(false, "Error cancelling reservation: " + e.getMessage(), getId());
        }
    }
    
    @Override
    public CommandResult undo() {
        if (!canUndo()) {
            return new CommandResult(false, "Cannot undo this command", getId());
        }
        
        // Restaurar estado desde backup
        boolean result = reservationService.restoreReservation(reservationId, (String) backupData);
        if (result) {
            return new CommandResult(true, "Cancellation undone successfully", getId());
        } else {
            return new CommandResult(false, "Failed to undo cancellation", getId());
        }
    }
}
