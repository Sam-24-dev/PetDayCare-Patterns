/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PushObserverTest {

    @Test
    public void testUpdateConMensajeValido() {
        PushObserver observer = new PushObserver();
        assertDoesNotThrow(() -> observer.update("Push enviado"));
    }

    @Test
    public void testUpdateConMensajeNuloLanzaExcepcion() {
        PushObserver observer = new PushObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(null));
    }

    @Test
    public void testUpdateConMensajeVacioLanzaExcepcion() {
        PushObserver observer = new PushObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(""));
    }
}
