package ec.edu.espol.petdaycare.patterns.Observer;

public class CaretakerObserver implements Observer {
    @Override
    public void update(String mensaje) {
        if (mensaje == null || mensaje.isEmpty()) throw new IllegalArgumentException("Mensaje inválido");
        System.out.println("[Caretaker] Registrando evento: " + mensaje);
    }
}