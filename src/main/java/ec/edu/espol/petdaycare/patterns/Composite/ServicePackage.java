package ec.edu.espol.petdaycare.patterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class ServicePackage implements ServiceComponent {
    private String name;
    private List<ServiceComponent> components = new ArrayList<>();

    public ServicePackage(String name) {
        this.name = name;
    }

    public void add(ServiceComponent component) {
        components.add(component);
    }

    public void remove(ServiceComponent component) {
        components.remove(component);
    }

    @Override
    public double calculatePrice() {
        return components.stream().mapToDouble(ServiceComponent::calculatePrice).sum();
    }

    @Override
    public boolean checkAvailability() {
        return components.stream().allMatch(ServiceComponent::checkAvailability);
    }

    @Override
    public int getDuration() {
        return components.stream().mapToInt(ServiceComponent::getDuration).sum();
    }

    @Override
    public String getName() {
        return name;
    }
}
