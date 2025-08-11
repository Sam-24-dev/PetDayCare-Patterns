package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicAddonService implements AddonService {
    @Override
    public String aplicarExtra(){
        return "Sin extras en el paquete basico";
    }
}
