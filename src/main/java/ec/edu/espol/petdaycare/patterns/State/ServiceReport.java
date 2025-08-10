/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.petdaycare.patterns.State;

import java.time.LocalDateTime;

/**
 *
 * @author USER
 */
public class ServiceReport {
    private final int rating;
    private final String comments;
    private final LocalDateTime completedAt;
    private final String caregiverName;
    
    public ServiceReport(int rating, String comments, LocalDateTime completedAt, String caregiverName) {
        this.rating = rating;
        this.comments = comments;
        this.completedAt = completedAt;
        this.caregiverName = caregiverName;
    }
    
    public int getRating() { return rating; }
    public String getComments() { return comments; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public String getCaregiverName() { return caregiverName; }
}
