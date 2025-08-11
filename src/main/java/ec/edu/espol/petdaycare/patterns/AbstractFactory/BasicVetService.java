package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicVetService implements VetService {
    public void provideService(){
        System.out.println("Chequeo basico");
    }
}
