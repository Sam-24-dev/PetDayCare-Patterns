/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    @Test
    public void testToStringNoNulo() {
        Reservation reservation = new Reservation();
        assertNotNull(reservation.toString());
    }

    @Test
    public void testToStringContieneDatos() {
        Reservation reservation = new Reservation();
        reservation.setPetName("Rocky");
        reservation.setPetType("Perro");
        reservation.setPackageName("Premium");
        reservation.setPackagePrice(120.0);

        String output = reservation.toString();
        assertTrue(output.contains("Rocky"));
        assertTrue(output.contains("Premium"));
    }
}