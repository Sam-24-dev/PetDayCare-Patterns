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

        // Ejecutar los pasos
        vetProcessor.validateReservation();
        vetProcessor.calculateCost();
        vetProcessor.makeReservation();
        vetProcessor.notifyUser();

        // Verificar que vetStepExecuted se puso en true tras reserve()
        assertTrue(vetProcessor.isVetStepExecuted(), "El paso veterinario debería estar ejecutado");
    }

    @Test
    public void testEmergencyReservationProcessor() {
        int prioridad = 5;
        EmergencyReservationProcessor emergencyProcessor = new EmergencyReservationProcessor(prioridad);

        // Ejecutar los pasos
        emergencyProcessor.validateReservation();
        emergencyProcessor.calculateCost();
        emergencyProcessor.makeReservation();
        emergencyProcessor.notifyUser();

        // Verificar que getPriority devuelve la prioridad correcta
        assertEquals(prioridad, emergencyProcessor.getPriority(), "La prioridad debe coincidir");
    }
}