package ec.edu.espol.petdaycare.patterns.Builder;

public class PetBuilder {
    private String nombre;
    private String especie;
    private Reservation reservation;

    public void buildPet(String nombre, String especie) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre de mascota requerido");
        if (especie == null || especie.isEmpty()) throw new IllegalArgumentException("Especie requerida");
        this.nombre = nombre;
        this.especie = especie;
    }
     public Reservation getResult() {
        return reservation;
    }

    public String getNombre() { 
        return nombre; }
    public String getEspecie() { 
        return especie; }
}