package ec.edu.espol.petdaycare.patterns.Observer;

public class Observable extends Subject {
    private String estado;

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notifyObservers(nuevoEstado);
    }

    public String getEstado() {
        return estado;
    }
}
