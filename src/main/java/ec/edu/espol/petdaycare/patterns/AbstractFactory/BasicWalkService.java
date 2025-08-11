package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicWalkService implements WalkService{
    @Override
    public String pasearMascota(){
        return "Paseo basico para la mascota";
    }
}
