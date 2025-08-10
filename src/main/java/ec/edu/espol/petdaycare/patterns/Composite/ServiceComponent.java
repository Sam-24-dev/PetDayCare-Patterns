package ec.edu.espol.petdaycare.patterns.Composite;

public interface ServiceComponent {
    double calculatePrice();
    boolean checkAvailability();
    int getDuration();
    String getName();
}

