package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class PremiumWalkService implements WalkService {
    public void provideService(){
        System.out.println("Paseo premium de 1 hora con entrenador");
    }
}
