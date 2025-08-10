/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String estado;

    public void attach(Observer o) {
        if (o == null) throw new IllegalArgumentException("Observer no puede ser null");
        if (observers.contains(o)) throw new IllegalStateException("Observer ya registrado");
        observers.add(o);
    }

    public void detach(Observer o) {
        if (o == null) throw new IllegalArgumentException("Observer no puede ser null");
        if (!observers.remove(o)) throw new NoSuchElementException("Observer no encontrado");
    }

    public void notifyObservers(String mensaje) {
        for (Observer o : observers) {
            try {
                o.update(mensaje);
            } catch (Exception e) {
                System.err.println("Error notificando observer: " + e.getMessage());
            }
        }
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notifyObservers(nuevoEstado);
    }

    public String getEstado() {
        return estado;
    }

    // Para pruebas: método para obtener lista de observers
    public List<Observer> getObservers() {
        return observers;
    }
}
