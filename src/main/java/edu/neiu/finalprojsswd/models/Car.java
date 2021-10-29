package edu.neiu.finalprojsswd.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String make;
    private String mode;
    private int year;
    private LocalDateTime created;
    private LocalDateTime modified;


    public Car() {
        this.make = "";
        this.mode = "";
        this.year = 0;
    }

    public Car(String make, String mod, int year) {
        this.make = make;
        this.mode = mod;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @PrePersist
    public void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate (){
        this.setModified(LocalDateTime.now());
    }


    public String toString(){
        return "Your Car:";
    }

}
