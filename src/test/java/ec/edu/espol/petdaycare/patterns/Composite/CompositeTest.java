package ec.edu.espol.petdaycare.patterns.Composite;


import ec.edu.espol.petdaycare.patterns.Composite.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompositeTest {

    private SimpleService s1;
    private SimpleService s2;
    private SimpleService s3;
    private DailyPackage daily;
    private ServicePackage subPackage;

    @BeforeEach
    void setup() {
        s1 = new SimpleService("Baño", 15.0, 30, true);
        s2 = new SimpleService("Paseo", 10.0, 20, true);
        s3 = new SimpleService("Entrenamiento", 20.0, 40, true);

        daily = new DailyPackage("Diario Básico");
        daily.add(s1);
        daily.add(s2);

        subPackage = new WeeklyPackage("SubPaquete Semanal");
        subPackage.add(s3);
    }

    // ---------- PRUEBAS NORMALES (mínimo 4 + extras) ----------

    @Test
    void testSimpleServiceCalculatePrice() {
        assertEquals(15.0, s1.calculatePrice(), 0.001, "Precio del servicio simple debe ser 15.0");
    }

    @Test
    void testSimpleServiceCheckAvailabilityTrue() {
        assertTrue(s1.checkAvailability(), "Servicio debe estar disponible");
    }

    @Test
    void testServicePackageCalculatePriceTwoServices() {
        // daily contiene s1 (15.0) y s2 (10.0)
        assertEquals(25.0, daily.calculatePrice(), 0.001, "Precio del paquete debe ser suma de servicios");
    }

    @Test
    void testServicePackageCheckAvailabilityAllAvailable() {
        assertTrue(daily.checkAvailability(), "Paquete debe estar disponible si todos sus componentes lo están");
    }

    // adicionales pedidos previamente
    @Test
    void testGetDurationSum() {
        // crear paquete con duraciones 20, 40, 10 -> aquí combinamos
        ServicePackage durationPackage = new EventPackage("Duraciones");
        durationPackage.add(new SimpleService("A", 5.0, 20, true));
        durationPackage.add(new SimpleService("B", 7.0, 40, true));
        durationPackage.add(new SimpleService("C", 3.0, 10, true));

        assertEquals(70, durationPackage.getDuration(), "Duración total debe sumar 70");
    }

    @Test
    void testCompositeWithSubpackageCalculatePriceRecursively() {
        // daily (s1+s2) + subPackage (s3) => 15 + 10 + 20 = 45
        ServicePackage top = new EventPackage("Top");
        top.add(daily);       // daily = 25
        top.add(subPackage);  // subPackage = 20
        assertEquals(45.0, top.calculatePrice(), 0.001, "Precio recursivo debe sumar todos los precios");
    }

    @Test
    void testGetNameSimpleService() {
        assertEquals("Paseo", s2.getName());
    }

    // ---------- PRUEBAS EXCEPCIÓN (mínimo 4) ----------

    @Test
    void testSimpleServiceNegativePriceThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new SimpleService("MalPrecio", -5.0, 15, true));
        assertTrue(ex.getMessage().toLowerCase().contains("precio"), "Debe indicar que el precio no puede ser negativo");
    }

    @Test
    void testSimpleServiceNegativeDurationThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                new SimpleService("MalTiempo", 5.0, -10, true));
        assertTrue(ex.getMessage().toLowerCase().contains("duración") || ex.getMessage().toLowerCase().contains("duracion"),
                "Debe indicar que la duración no puede ser negativa");
    }

    @Test
    void testServicePackageAddNullThrows() {
        ServicePackage p = new DailyPackage("P");
        assertThrows(NullPointerException.class, () -> p.add(null));
    }

    @Test
    void testServicePackageRemoveNonexistentThrows() {
        ServicePackage p = new DailyPackage("P");
        SimpleService notPresent = new SimpleService("NoEsta", 1.0, 5, true);
        assertThrows(IllegalArgumentException.class, () -> p.remove(notPresent));
    }

    // extra: paquete vacío should return price 0
    @Test
    void testEmptyPackagePriceZero() {
        ServicePackage empty = new WeeklyPackage("Vacio");
        assertEquals(0.0, empty.calculatePrice(), 0.001);
        assertTrue(empty.checkAvailability(), "Paquete vacío se considera disponible por defecto (no contiene nada que invalide)");
    }
}
