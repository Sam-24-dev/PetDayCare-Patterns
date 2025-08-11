package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class PremiumGuarderiaService implements GuarderiaService {
    public String cuidarMascota(){
        return"Guarderia premium con juegos y entrenamiento";
    }
}