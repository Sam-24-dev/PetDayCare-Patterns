/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailObserverTest {

    @Test
    public void testUpdateConMensajeValido() {
        EmailObserver observer = new EmailObserver();
        assertDoesNotThrow(() -> observer.update("Correo enviado"));
    }

    @Test
    public void testUpdateConMensajeNuloLanzaExcepcion() {
        EmailObserver observer = new EmailObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(null));
    }

    @Test
    public void testUpdateConMensajeVacioLanzaExcepcion() {
        EmailObserver observer = new EmailObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(""));
    }
}