/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Template;

/**
 *
 * @author johan
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemplateTest {

    @Test
    public void testVetReservationProcessor() {
        VetReservationProcessor vetProcessor = new VetReservationProcessor();

        vetProcessor.validateReservation();
        vetProcessor.calculateCost();
        vetProcessor.makeReservation();
        vetProcessor.notifyUser();

        assertTrue(vetProcessor.isVetStepExecuted(), "El paso veterinario debería estar ejecutado");
    }

    @Test
    public void testEmergencyReservationProcessor() {
        int prioridad = 5;
        EmergencyReservationProcessor emergencyProcessor = new EmergencyReservationProcessor(prioridad);

        emergencyProcessor.validateReservation();
        emergencyProcessor.calculateCost();
        emergencyProcessor.makeReservation();
        emergencyProcessor.notifyUser();

        assertEquals(prioridad, emergencyProcessor.getPriority(), "La prioridad debe coincidir");
    }

    @Test
    public void testVetReservationProcessor_Exception() {
        VetReservationProcessor vetProcessor = new VetReservationProcessor() {
            @Override
            protected void makeReservation() {
                throw new RuntimeException("Error simulado en makeReservation");
            }
        };

        vetProcessor.validateReservation();
        vetProcessor.calculateCost();

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            vetProcessor.makeReservation();
        });

        assertEquals("Error simulado en makeReservation", ex.getMessage());
    }

    @Test
    public void testEmergencyReservationProcessor_Exception() {
        EmergencyReservationProcessor emergencyProcessor = new EmergencyReservationProcessor(1) {
            @Override
            protected void makeReservation() {
                throw new RuntimeException("Error simulado en makeReservation emergencia");
            }
        };

        emergencyProcessor.validateReservation();
        emergencyProcessor.calculateCost();

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            emergencyProcessor.makeReservation();
        });

        assertEquals("Error simulado en makeReservation emergencia", ex.getMessage());
    }
}