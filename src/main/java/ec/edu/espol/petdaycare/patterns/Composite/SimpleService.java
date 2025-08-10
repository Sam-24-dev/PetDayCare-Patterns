package ec.edu.espol.petdaycare.patterns.Composite;

public class SimpleService implements ServiceComponent {
    private String name;
    private double price;
    private int duration; // en minutos
    private boolean available;

    public SimpleService(String name, double price, int duration, boolean available) {
        if (price < 0) throw new IllegalArgumentException("El precio no puede ser negativo");
        if (duration < 0) throw new IllegalArgumentException("La duración no puede ser negativa");
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.available = available;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public boolean checkAvailability() {
        return available;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getName() {
        return name;
    }
}

