/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class ChangeRequest {
    private LocalDate newStartDate;
    private LocalDate newEndDate;
    private BigDecimal newPrice;
    private String reason;
    
    public ChangeRequest(LocalDate newStartDate, LocalDate newEndDate, BigDecimal newPrice, String reason) {
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
        this.newPrice = newPrice;
        this.reason = reason;
    }
    
    // Getters
    public LocalDate getNewStartDate() { return newStartDate; }
    public LocalDate getNewEndDate() { return newEndDate; }
    public BigDecimal getNewPrice() { return newPrice; }
    public String getReason() { return reason; }
}
