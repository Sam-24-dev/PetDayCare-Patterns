/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.Command;

import java.util.UUID;

/**
 *
 * @author USER
 */
public class User {
    private final UUID id;
    private final String name;
    private final String role;
    
    public User(UUID id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
}
