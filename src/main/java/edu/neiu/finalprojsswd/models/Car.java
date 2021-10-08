package edu.neiu.finalprojsswd.models;

public class Car {

    private String make;
    private String mode;
    private int year;

    public Car() {
        this.make = "";
        this.mode = "";
    }

    public Car(String make, String mod) {
        this.make = make;
        this.mode = mod;
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
    @Override
    public String toString(){
        return "Your Car:";
    }

}
