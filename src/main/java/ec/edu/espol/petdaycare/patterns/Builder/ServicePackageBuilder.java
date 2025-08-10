package ec.edu.espol.petdaycare.patterns.Builder;

public class ServicePackageBuilder {
    private String tipo;
    private double precio;
    private Reservation reservation;

    public void buildPackage(String tipo, double precio) {
        if (tipo == null || tipo.isEmpty()) throw new IllegalArgumentException("Tipo requerido");
        if (precio <= 0) throw new IllegalArgumentException("Precio inválido");
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public Reservation getResult() {
        return reservation;
    }

    public String getTipo() { 
        return tipo; }
    public double getPrecio() { 
        return precio; }
    
}
