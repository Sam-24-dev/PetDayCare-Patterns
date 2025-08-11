package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class VeterinaryAddonService implements AddonService {
    public String aplicarExtra(){
        return "Extras veterinarios: vacunas y chequeos";
    }
}
