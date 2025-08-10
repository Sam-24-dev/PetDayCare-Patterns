/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author USER
 */
public class CancelReservationCommandTest {
    private CommandManager manager;
    private User testUser;
    
    @Mock
    private ReservationService reservationServiceMock;
    
    @Mock
    private PaymentService paymentServiceMock;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        manager = new CommandManager();
        testUser = new User(UUID.randomUUID(), "Test User", "ADMIN");
    }
    
    // ==================== CASOS NORMALES ====================
    
    @Test
    @DisplayName("C1: Ejecutar CancelReservationCommand exitosamente")
    void testExecuteCancelReservationSuccess() {
        // Arrange
        UUID reservationId = UUID.randomUUID();
        when(reservationServiceMock.cancelReservation(reservationId, "test")).thenReturn(true);
        
        CancelReservationCommand cmd = new CancelReservationCommand(reservationId, "test", testUser, reservationServiceMock);
        
        // Act
        CommandResult result = cmd.execute();
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 6: verify (Mockito)
        verify(reservationServiceMock).cancelReservation(reservationId, "test");
        // Assert - Tipo 4: assertNotNull
        assertNotNull(result.getCommandId());
    }
    // ==================== CASOS EXCEPCIONES ====================
    
    @Test
    @DisplayName("CEXP-1: Ejecutar CancelReservationCommand con ID inexistente")
    void testExecuteCancelReservationNotFound() {
        // Arrange
        UUID invalidId = UUID.randomUUID();
        when(reservationServiceMock.cancelReservation(invalidId, "test")).thenReturn(false);
        
        CancelReservationCommand cmd = new CancelReservationCommand(invalidId, "test", testUser, reservationServiceMock);
        
        // Act
        CommandResult result = cmd.execute();
        
        // Assert - Tipo 3: assertFalse
        assertFalse(result.isSuccess());
        // Assert - Tipo 2: assertEquals
        assertEquals("RESERVATION_NOT_FOUND", result.getMessage());
    }
}
