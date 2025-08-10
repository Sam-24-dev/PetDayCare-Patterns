/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.math.BigDecimal;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author USER
 */
public class AbstractCommandTest {
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
        // ==================== CASOS EXCEPCIONES ====================
       @Test
    @DisplayName("CEXP-4: Comando que no soporta undo")
    void testCanUndoWithoutBackup() {
        // Arrange
        UUID clientId = UUID.randomUUID();
        BigDecimal invalidAmount = new BigDecimal("-100.00");
        CompensateClientCommand cmd = new CompensateClientCommand(clientId, invalidAmount, testUser, paymentServiceMock);
        
        // Act
        boolean canUndo = cmd.canUndo();
        
        // Assert - Tipo 3: assertFalse
        assertFalse(canUndo);
    }
}
