/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PetBuilderTest {

    @Test
    public void testBuildPetValido() {
        PetBuilder petBuilder = new PetBuilder();
        petBuilder.buildPet("Luna", "Gato");
        Reservation reserva = petBuilder.getResult();
        assertTrue(reserva.toString().contains("Luna"));
    }

    @Test
    public void testBuildPetNombreInvalido() {
        PetBuilder petBuilder = new PetBuilder();
        assertThrows(IllegalArgumentException.class, () -> petBuilder.buildPet("", "Gato"));
    }
}