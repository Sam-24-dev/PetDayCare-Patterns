package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class VeterinaryAddonService implements AddonService {
    public void provideService(){
        System.out.println("Monitoreo de salud durante el dia");
    }
}
