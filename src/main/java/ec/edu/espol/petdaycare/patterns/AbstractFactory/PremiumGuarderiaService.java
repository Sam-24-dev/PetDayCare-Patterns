package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class PremiumGuarderiaService implements GuarderiaService {
    public void provideService(){
        System.out.println("Guarderia premium con juegos y entrenamiento");
    }
}
