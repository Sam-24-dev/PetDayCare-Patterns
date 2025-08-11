package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicAddonService implements AddonService {
    public void provideService(){
        System.out.println("Agregar Snack");
    }
}
