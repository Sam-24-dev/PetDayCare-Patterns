/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Builder;

/**
 *
 * @author USER
 */
public class Reservation {
    private String petName;
    private String petSpecies;
    private String packageType;
    private double packagePrice;

    public void setPet(String name, String species) {
        this.petName = name;
        this.petSpecies = species;
    }

    public void setPackage(String type, double price) {
        this.packageType = type;
        this.packagePrice = price;
    }

    @Override
    public String toString() {
        return "Reserva para " + petName + " (" + petSpecies + ") con paquete " +
                packageType + " - $" + packagePrice;
    }
}
