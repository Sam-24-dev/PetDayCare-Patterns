package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class VeterinaryVetService implements VetService {
    public void provideService(){
        System.out.println("Atencion veterinaria especializada");
    }
}
