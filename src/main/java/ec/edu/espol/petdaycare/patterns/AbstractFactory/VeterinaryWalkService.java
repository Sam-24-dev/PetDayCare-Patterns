package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class VeterinaryWalkService implements WalkService {
    public void provideService(){
        System.out.println("Paseo supervisado por personal medico");
    }
}
