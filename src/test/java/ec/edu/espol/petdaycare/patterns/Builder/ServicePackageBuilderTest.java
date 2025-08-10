/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicePackageBuilderTest {

    @Test
    public void testBuildPackageValido() {
        ServicePackageBuilder packageBuilder = new ServicePackageBuilder();
        packageBuilder.buildPackage("VIP", 200.0);
        Reservation reserva = packageBuilder.getResult();
        assertTrue(reserva.toString().contains("VIP"));
    }

    @Test
    public void testBuildPackagePrecioInvalido() {
        ServicePackageBuilder packageBuilder = new ServicePackageBuilder();
        assertThrows(IllegalArgumentException.class, () -> packageBuilder.buildPackage("VIP", -10.0));
    }
}
