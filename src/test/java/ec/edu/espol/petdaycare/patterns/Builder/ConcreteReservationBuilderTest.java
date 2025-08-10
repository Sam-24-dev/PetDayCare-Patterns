/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConcreteReservationBuilderTest {

    private ConcreteReservationBuilder builder;

    @BeforeEach
    public void setUp() {
        builder = new ConcreteReservationBuilder();
    }

    @Test
    public void testBuildPetValido() {
        builder.buildPet("Bobby", "Perro");
        Reservation reserva = builder.getResult();
        assertTrue(reserva.toString().contains("Bobby"));
    }

    @Test
    public void testBuildPetNombreInvalido() {
        assertThrows(IllegalArgumentException.class, () -> builder.buildPet("", "Perro"));
    }

    @Test
    public void testBuildPetTipoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> builder.buildPet("Bobby", ""));
    }

    @Test
    public void testBuildPackageValido() {
        builder.buildPackage("Premium", 150.0);
        Reservation reserva = builder.getResult();
        assertTrue(reserva.toString().contains("Premium"));
    }

    @Test
    public void testBuildPackageNombreInvalido() {
        assertThrows(IllegalArgumentException.class, () -> builder.buildPackage("", 150.0));
    }

    @Test
    public void testBuildPackagePrecioInvalido() {
        assertThrows(IllegalArgumentException.class, () -> builder.buildPackage("Premium", 0));
    }
}