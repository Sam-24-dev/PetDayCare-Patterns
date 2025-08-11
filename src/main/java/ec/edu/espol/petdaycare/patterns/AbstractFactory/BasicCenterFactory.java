/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.AbstractFactory;

/**
 *
 * @author johan
 */
public class BasicCenterFactory implements CenterServiceFactory {

    @Override
    public GuarderiaService createGuarderiaService() {
        return new BasicGuarderiaService();
    }

    @Override
    public WalkService createWalkService() {
        return new BasicWalkService();
    }

    @Override
    public VetService createVetService() {
        return new BasicVetService();
    }

    @Override
    public AddonService createAddonService() {
        return new BasicAddonService();
    }
}
