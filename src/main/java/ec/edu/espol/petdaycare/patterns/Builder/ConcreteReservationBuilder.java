package ec.edu.espol.petdaycare.patterns.Builder;

public class ConcreteReservationBuilder implements ReservationBuilder {
    private Reservation reserva = new Reservation();
    private PetBuilder petBuilder = new PetBuilder();
    private ServicePackageBuilder packageBuilder = new ServicePackageBuilder();

    @Override
    public void buildPet(String nombre, String especie) {
        petBuilder.buildPet(nombre, especie);
        reserva.setPet(petBuilder.getNombre(), petBuilder.getEspecie());
    }

    @Override
    public void buildPackage(String tipo, double precio) {
        packageBuilder.buildPackage(tipo, precio);
        reserva.setPackage(packageBuilder.getTipo(), packageBuilder.getPrecio());
    }

    @Override
    public Reservation getResult() {
        return reserva;
    }
}
