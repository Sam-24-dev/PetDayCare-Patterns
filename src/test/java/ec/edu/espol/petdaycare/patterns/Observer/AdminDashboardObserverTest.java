/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminDashboardObserverTest {

    @Test
    public void testUpdateConMensajeValido() {
        AdminDashboardObserver observer = new AdminDashboardObserver();
        assertDoesNotThrow(() -> observer.update("Actualizar dashboard"));
    }

    @Test
    public void testUpdateConMensajeNuloLanzaExcepcion() {
        AdminDashboardObserver observer = new AdminDashboardObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(null));
    }

    @Test
    public void testUpdateConMensajeVacioLanzaExcepcion() {
        AdminDashboardObserver observer = new AdminDashboardObserver();
        assertThrows(IllegalArgumentException.class, () -> observer.update(""));
    }
}