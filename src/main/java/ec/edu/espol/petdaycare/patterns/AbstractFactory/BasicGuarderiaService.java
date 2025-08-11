package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class BasicGuarderiaService implements GuarderiaService {
    @Override
    public String cuidarMascota(){
        return "Guarderia basica cuidando a la mascota";
    }
}
