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
    private String petType;
    private String packageName;
    private double packagePrice;

    // Métodos combinados
    public void setPet(String name, String type) {
        setPetName(name);
        setPetType(type);
    }

    public void setPackage(String name, double price) {
        setPackageName(name);
        setPackagePrice(price);
    }

    // Getters y Setters individuales
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        if (petName == null || petName.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la mascota no puede estar vacío");
        }
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        if (petType == null || petType.isEmpty()) {
            throw new IllegalArgumentException("El tipo de mascota no puede estar vacío");
        }
        this.petType = petType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            throw new IllegalArgumentException("El nombre del paquete no puede estar vacío");
        }
        this.packageName = packageName;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        if (packagePrice <= 0) {
            throw new IllegalArgumentException("El precio del paquete debe ser mayor a 0");
        }
        this.packagePrice = packagePrice;
    }

    @Override
    public String toString() {
        return "Reserva: " + petName + " (" + petType + "), Paquete: " + packageName + " - $" + packagePrice;
    }
}
