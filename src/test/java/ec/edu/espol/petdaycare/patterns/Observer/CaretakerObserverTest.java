/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaretakerObserverTest {

    @Test
    public void testUpdateConMensajeValido() {
        CaretakerObserver observer = new CaretakerObserver();
        assertDoesNotThrow(() -> observer.update("Registrar evento"));
    }

    @Test
    public void testUpdateConMensajeNuloLanzaExcepcion() {
        CaretakerObserver observer = new CaretakerObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(null));
    }

    @Test
    public void testUpdateConMensajeVacioLanzaExcepcion() {
        CaretakerObserver observer = new CaretakerObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(""));
    }
}
