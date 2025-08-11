package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class PremiumVetService implements VetService {
    public void provideService(){
        System.out.println("Chequeo veterinario y vacunas");
    }
}
