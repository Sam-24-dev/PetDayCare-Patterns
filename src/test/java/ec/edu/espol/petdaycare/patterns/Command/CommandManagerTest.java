/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author USER
 */
public class CommandManagerTest {
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
    @DisplayName("C2: Submit comando y verificar cola")
    void testSubmitCommand() {
        // Arrange
        UUID reservationId = UUID.randomUUID();
        CancelReservationCommand cmd = new CancelReservationCommand(reservationId, "test", testUser, reservationServiceMock);
        
        // Act
        manager.submit(cmd);
        
        // Assert - Tipo 3: assertFalse (cola no está vacía)
        assertFalse(manager.isQueueEmpty());
        // Assert - Tipo 2: assertEquals
        assertEquals(1, manager.getQueueSize());
    }
    
    @Test
    @DisplayName("C3: Ejecutar próximo comando de la cola")
    void testExecuteNext() {
        // Arrange
        UUID reservationId = UUID.randomUUID();
        when(reservationServiceMock.cancelReservation(any(), any())).thenReturn(true);
        
        CancelReservationCommand cmd = new CancelReservationCommand(reservationId, "test", testUser, reservationServiceMock);
        manager.submit(cmd);
        
        // Act
        CommandResult result = manager.executeNext();
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 2: assertEquals (verificar que la cola se vacíe)
        assertEquals(0, manager.getQueueSize());
        // Assert - Tipo 2: assertEquals (verificar que se agregue al historial)
        assertEquals(1, manager.getHistory().size());
    }
    
    @Test
    @DisplayName("C4: Ejecutar CompensateClientCommand exitosamente")
    void testExecuteCompensateClientSuccess() {
        // Arrange
        UUID clientId = UUID.randomUUID();
        BigDecimal amount = new BigDecimal("250.00");
        when(paymentServiceMock.compensateClient(clientId, amount)).thenReturn(true);
        
        CompensateClientCommand cmd = new CompensateClientCommand(clientId, amount, testUser, paymentServiceMock);
        
        // Act
        CommandResult result = cmd.execute();
        
        // Assert - Tipo 1: assertTrue
        assertTrue(result.isSuccess());
        // Assert - Tipo 6: verify
        verify(paymentServiceMock).compensateClient(clientId, amount);
    }
    
    // ==================== CASOS EXCEPCIONES ====================
    
    
    
    @Test
    @DisplayName("C6: Ejecutar siguiente comando con cola vacía")
    void testExecuteNextEmptyQueue() {
        // Arrange: CommandManager con cola vacía
        
        // Act
        CommandResult result = manager.executeNext();
        
        // Assert - Tipo 3: assertFalse
        assertFalse(result.isSuccess());
        // Assert - Tipo 1: assertTrue
        assertTrue(result.getMessage().contains("No commands in queue"));
    }
    
    
    
    
   
}
