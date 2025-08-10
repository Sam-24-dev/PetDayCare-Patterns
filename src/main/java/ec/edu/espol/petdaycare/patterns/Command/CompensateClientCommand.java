/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author USER
 */
public class CompensateClientCommand extends AbstractCommand{
    private final UUID clientId;
    private final BigDecimal amount;
    private final PaymentService paymentService;
    
    public CompensateClientCommand(UUID clientId, BigDecimal amount, User initiatedBy, PaymentService service) {
        super(initiatedBy, 2); // Normal priority
        this.clientId = clientId;
        this.amount = amount;
        this.paymentService = service;
    }
    
    @Override
    public CommandResult execute() {
        try {
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                return new CommandResult(false, "Invalid compensation amount", getId());
            }
            
            boolean result = paymentService.compensateClient(clientId, amount);
            setExecuted(true);
            
            if (result) {
                return new CommandResult(true, "Client compensated successfully", getId());
            } else {
                return new CommandResult(false, "Failed to process compensation", getId());
            }
        } catch (Exception e) {
            return new CommandResult(false, "Error processing compensation: " + e.getMessage(), getId());
        }
    }
    
    @Override
    public CommandResult undo() {
        return new CommandResult(false, "Compensation cannot be undone", getId());
    }
}
