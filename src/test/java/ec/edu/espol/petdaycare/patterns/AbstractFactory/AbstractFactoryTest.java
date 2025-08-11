/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.AbstractFactory;

/**
 *
 * @author johan
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class AbstractFactoryTest {

    @Test
    public void testBasicCenterFactory() {
        CenterServiceFactory factory = new BasicCenterFactory();

        assertTrue(factory.createGuarderiaService() instanceof BasicGuarderiaService);
        assertTrue(factory.createWalkService() instanceof BasicWalkService);
        assertTrue(factory.createVetService() instanceof BasicVetService);
        assertTrue(factory.createAddonService() instanceof BasicAddonService);

        assertEquals("Guarderia basica cuidando a la mascota", 
            factory.createGuarderiaService().cuidarMascota());
        assertEquals("Paseo basico para la mascota", 
            factory.createWalkService().pasearMascota());
        assertEquals("Servicio veterinario basico", 
            factory.createVetService().atenderMascota());
        assertEquals("Sin extras en el paquete basico", 
            factory.createAddonService().aplicarExtra());
    }

    @Test
    public void testPremiumCenterFactory() {
        CenterServiceFactory factory = new PremiumCenterFactory();

        assertTrue(factory.createGuarderiaService() instanceof PremiumGuarderiaService);
        assertTrue(factory.createWalkService() instanceof PremiumWalkService);
        assertTrue(factory.createVetService() instanceof PremiumVetService);
        assertTrue(factory.createAddonService() instanceof PremiumAddonService);

        assertEquals("Guarderia premium con juegos y entrenamiento", 
            factory.createGuarderiaService().cuidarMascota());
        assertEquals("Paseo premium con entrenador profesional", 
            factory.createWalkService().pasearMascota());
        assertEquals("Atencion veterinaria premium", 
            factory.createVetService().atenderMascota());
        assertEquals("Extras premium: spa y masajes", 
            factory.createAddonService().aplicarExtra());
    }

    @Test
    public void testVeterinaryCenterFactory() {
        CenterServiceFactory factory = new VeterinaryCenterFactory();

        assertTrue(factory.createGuarderiaService() instanceof VeterinaryGuarderiaService);
        assertTrue(factory.createWalkService() instanceof VeterinaryWalkService);
        assertTrue(factory.createVetService() instanceof VeterinaryVetService);
        assertTrue(factory.createAddonService() instanceof VeterinaryAddonService);

        assertEquals("Guarderia con supervision veterinaria", 
            factory.createGuarderiaService().cuidarMascota());
        assertEquals("Paseo con supervision veterinaria", 
            factory.createWalkService().pasearMascota());
        assertEquals("Atencion veterinaria especializada", 
            factory.createVetService().atenderMascota());
        assertEquals("Extras veterinarios: vacunas y chequeos", 
            factory.createAddonService().aplicarExtra());
    }

    @Test
    public void testBasicCenterFactory_NullService() {
        CenterServiceFactory factory = new BasicCenterFactory() {
            @Override
            public GuarderiaService createGuarderiaService() {
                return null; // Simula servicio nulo
            }
        };

        assertThrows(NullPointerException.class, () -> {
            factory.createGuarderiaService().cuidarMascota();
        });
    }

    @Test
    public void testPremiumCenterFactory_InvalidData() {
        CenterServiceFactory factory = new PremiumCenterFactory() {
            @Override
            public VetService createVetService() {
                return new PremiumVetService() {
                    @Override
                    public String atenderMascota() {
                        throw new IllegalArgumentException("Datos inválidos para veterinario");
                    }
                };
            }
        };

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            factory.createVetService().atenderMascota();
        });

        assertEquals("Datos inválidos para veterinario", ex.getMessage());
    }
}