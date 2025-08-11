/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.AbstractFactory;

/**
 *
 * @author johan
 */
public class VeterinaryCenterFactory implements CenterServiceFactory {

    @Override
    public GuarderiaService createGuarderiaService() {
        return new VeterinaryGuarderiaService();
    }

    @Override
    public WalkService createWalkService() {
        return new VeterinaryWalkService();
    }

    @Override
    public VetService createVetService() {
        return new VeterinaryVetService();
    }

    @Override
    public AddonService createAddonService() {
        return new VeterinaryAddonService();
    }
}
