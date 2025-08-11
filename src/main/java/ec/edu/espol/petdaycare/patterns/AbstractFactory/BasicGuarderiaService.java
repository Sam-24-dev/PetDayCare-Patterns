package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicGuarderiaService implements GuarderiaService {
    public void provideService(){
        System.out.println("Guarderia basica");
    }
}
