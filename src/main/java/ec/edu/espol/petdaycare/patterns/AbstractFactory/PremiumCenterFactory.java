/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.AbstractFactory;

/**
 *
 * @author johan
 */
public class PremiumCenterFactory implements CenterServiceFactory {

    @Override
    public GuarderiaService createGuarderiaService() {
        return new PremiumGuarderiaService();
    }

    @Override
    public WalkService createWalkService() {
        return new PremiumWalkService();
    }

    @Override
    public VetService createVetService() {
        return new PremiumVetService();
    }

    @Override
    public AddonService createAddonService() {
        return new PremiumAddonService();
    }
}