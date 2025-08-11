package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicWalkService implements WalkService{
    public void provideService(){
        System.out.println("Paseo basico de 30 mins");
    }
}
