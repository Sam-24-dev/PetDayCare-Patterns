/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.ArgumentMatchers.argThat;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author USER
 */
public class ReservationContextTest {
    private ReservationContext context;
    private Reservation reservation;
    
    @Mock
    private ReservationObserver observerMock;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        UUID reservationId = UUID.randomUUID();
        reservation = new Reservation(reservationId, UUID.randomUUID(), UUID.randomUUID(),
                                    LocalDate.now().plusDays(1), LocalDate.now().plusDays(3),
                                    new BigDecimal("150.00"));
        context = new ReservationContext(reservationId, reservation);
        context.registerObserver(observerMock);
    }
    
    // ==================== CASOS NORMALES ====================
    
    @Test
    @DisplayName("S1: Confirmar reserva desde estado PENDING")
    void testConfirmFromPending() {
        // Arrange: Context ya está en PENDING por defecto
        int prevHistorySize = context.getStateHistory().size();
        
        // Act
        TransitionResult result = context.confirm();
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 2: assertEquals 
        assertEquals("CONFIRMED", context.getCurrentStateName());
        // Assert - Tipo 3: assertEquals para verificar incremento de historial
        assertEquals(prevHistorySize + 1, context.getStateHistory().size());
    }
    
    @Test
    @DisplayName("S2: Iniciar servicio desde estado CONFIRMED")
    void testStartServiceFromConfirmed() {
        // Arrange
        context.confirm(); // Mover a CONFIRMED
        
        // Act
        TransitionResult result = context.startService();
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 4: assertNotNull
        assertNotNull(result.getMessage());
        // Assert - Tipo 2: assertEquals
        assertEquals("IN_PROGRESS", context.getCurrentStateName());
    }
    
    @Test
    @DisplayName("S3: Completar servicio desde estado IN_PROGRESS")
    void testCompleteServiceFromInProgress() {
        // Arrange
        context.confirm();
        context.startService(); // Mover a IN_PROGRESS
        ServiceReport report = new ServiceReport(5, "Excellent service", LocalDateTime.now(), "John Doe");
        
        // Act
        TransitionResult result = context.completeService(report);
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 2: assertEquals
        assertEquals("COMPLETED", context.getCurrentStateName());
        // Assert - Tipo 6: verify (Mockito) - verificar notificación a observers
        verify(observerMock).update(argThat(evt -> evt.getType().equals("SERVICE_COMPLETED")));
    }
    
    @Test
    @DisplayName("S4: Cancelar reserva desde estado CONFIRMED")
    void testCancelFromConfirmed() {
        // Arrange
        context.confirm(); // Mover a CONFIRMED
        
        // Act
        TransitionResult result = context.cancel("emergency");
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 2: assertEquals
        assertEquals("CANCELLED", context.getCurrentStateName());
        // Assert - Tipo 4: assertNotNull - verificar que se creó StateTransition
        StateTransition lastTransition = context.getStateHistory().get(context.getStateHistory().size() - 1);
        assertNotNull(lastTransition.getTimestamp());
    }
    
    // ==================== CASOS EXCEPCIONES ====================
    
    @Test
    @DisplayName("S5: Intentar confirmar reserva ya COMPLETED")
    void testConfirmFromCompleted() {
        // Arrange: Mover a COMPLETED
        context.confirm();
        context.startService();
        ServiceReport report = new ServiceReport(5, "Done", LocalDateTime.now(), "Jane");
        context.completeService(report);
        
        // Act & Assert - Tipo 3: assertFalse
        TransitionResult result = context.confirm();
        assertFalse(result.isSuccess());
        // Verificar mensaje de error
        assertTrue(result.getMessage().toLowerCase().contains("cannot confirm completed"));
    }
    
    @Test
    @DisplayName("S6: Intentar iniciar servicio desde estado PENDING")
    void testStartServiceFromPending() {
        // Arrange: Context ya está en PENDING
        
        // Act
        TransitionResult result = context.startService();
        
        // Assert - Tipo 3: assertFalse
        assertFalse(result.isSuccess());
        // Assert - Tipo 1: assertTrue para verificar mensaje de error
        assertTrue(result.getMessage().toLowerCase().contains("cannot start"));
    }
    
    @Test
    @DisplayName("S7: Intentar cancelar con parámetro null desde COMPLETED")
    void testCancelWithNullReasonFromCompleted() {
        // Arrange: Mover a COMPLETED
        context.confirm();
        context.startService();
        ServiceReport report = new ServiceReport(4, "Good", LocalDateTime.now(), "Bob");
        context.completeService(report);
        
        // Act & Assert - Tipo 5: assertThrows
        assertThrows(IllegalArgumentException.class, () -> {
            context.cancel(null);
        });
    }
    
    @Test
    @DisplayName("S8: Intentar modificar reserva CANCELLED")
    void testModifyCancelledReservation() {
        // Arrange: Mover a CANCELLED
        context.confirm();
        context.cancel("test cancel");
        ChangeRequest changes = new ChangeRequest(LocalDate.now().plusDays(5), 
                                                LocalDate.now().plusDays(7), 
                                                new BigDecimal("200.00"), "Date change");
        
        // Act
        TransitionResult result = context.modify(changes);
        
        // Assert - Tipo 3: assertFalse
        assertFalse(result.isSuccess());
        // Assert - Tipo 2: assertEquals
        assertEquals("Cannot modify cancelled reservation", result.getMessage());
    }
    
}
