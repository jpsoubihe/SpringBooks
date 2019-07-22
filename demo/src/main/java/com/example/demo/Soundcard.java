package com.example.demo;

public class Soundcard {

    private String model;
    private int year;
    private Usb usb;


    public Soundcard() {
    }

    public Soundcard(String model, int year, Usb usb) {
        this.model = model;
        this.year = year;
        this.usb = usb;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Usb getUsb() {
        return usb;
    }

    public void setUsb(Usb usb) {
        this.usb = usb;
    }

    @Override
    public String toString() {
        return "Soundcard{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", usb=" + usb +
                '}';
    }
}
