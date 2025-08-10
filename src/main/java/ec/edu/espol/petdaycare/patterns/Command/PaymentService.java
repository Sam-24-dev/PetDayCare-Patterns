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
public class PaymentService {
    public boolean compensateClient(UUID clientId, BigDecimal amount) {
        if (clientId == null || amount == null) {
            return false;
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        System.out.println("Processing compensation for client: " + clientId + " amount: " + amount);
        return true;
    }

}
