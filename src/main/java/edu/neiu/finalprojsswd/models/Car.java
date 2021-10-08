package edu.neiu.finalprojsswd.models;

public class Car {

    private String make;
    private String mod;
    private int year;

    public Car() {
        this.make = "";
        this.mod = "";
    }

    public Car(String make, String mod) {
        this.make = make;
        this.mod = mod;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
