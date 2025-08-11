package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class PremiumVetService implements VetService {
    @Override
    public String atenderMascota(){
        return "Atencion veterinaria premium";
    }
}
