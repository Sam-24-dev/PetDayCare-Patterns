/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectTest {

    private Subject subject;
    private Observer mockObserver;

    @BeforeEach
    public void setUp() {
        subject = new Subject();
        // Creamos un observer simple para pruebas
        mockObserver = new Observer() {
            @Override
            public void update(String mensaje) {
                // No hace nada, solo para prueba
            }
        };
    }

    @Test
    public void testAttachObserver() {
        subject.attach(mockObserver);
        assertEquals(1, subject.getObservers().size(), "Debe tener un observer registrado");
    }

    @Test
    public void testAttachNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subject.attach(null));
    }

    @Test
    public void testAttachDuplicateThrowsException() {
        subject.attach(mockObserver);
        assertThrows(IllegalStateException.class, () -> subject.attach(mockObserver));
    }

    @Test
    public void testDetachObserver() {
        subject.attach(mockObserver);
        subject.detach(mockObserver);
        assertEquals(0, subject.getObservers().size(), "Debe eliminar el observer");
    }

    @Test
    public void testDetachNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> subject.detach(null));
    }

    @Test
    public void testDetachNotFoundThrowsException() {
        assertThrows(NoSuchElementException.class, () -> subject.detach(mockObserver));
    }

    @Test
    public void testNotifyObserversCallsUpdate() {
        // Creamos un observer que cambia una variable para verificar llamada
        final boolean[] notified = {false};
        Observer testObserver = new Observer() {
            @Override
            public void update(String mensaje) {
                notified[0] = true;
                assertEquals("Mensaje de prueba", mensaje);
            }
        };
        subject.attach(testObserver);
        subject.notifyObservers("Mensaje de prueba");
        assertTrue(notified[0], "El observer debería ser notificado");
    }

    @Test
    public void testSetEstadoNotifica() {
        final String[] estadoNotificado = {null};
        Observer testObserver = new Observer() {
            @Override
            public void update(String mensaje) {
                estadoNotificado[0] = mensaje;
            }
        };
        subject.attach(testObserver);
        subject.setEstado("Estado nuevo");
        assertEquals("Estado nuevo", subject.getEstado());
        assertEquals("Estado nuevo", estadoNotificado[0]);
    }
}
