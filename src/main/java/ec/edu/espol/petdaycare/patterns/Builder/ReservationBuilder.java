package ec.edu.espol.petdaycare.patterns.Builder;

public interface ReservationBuilder {
    void buildPet(String nombre, String especie);
    void buildPackage(String tipo, double precio);
    Reservation getResult();
}
