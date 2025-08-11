package ec.edu.espol.petdaycare.patterns.AbstractFactory;

public class VeterinaryGuarderiaService implements GuarderiaService {
    @Override
    public String cuidarMascota(){
        return "Guarderia con supervision veterinaria";
    }
}
