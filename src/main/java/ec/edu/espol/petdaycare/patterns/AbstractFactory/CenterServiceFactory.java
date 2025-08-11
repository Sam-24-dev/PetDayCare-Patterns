package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public interface CenterServiceFactory {
    GuarderiaService createGuarderiaService();
    WalkService createWalkService();
    VetService createVetService();
    AddonService createAddonService();
}
