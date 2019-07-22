package com.example.demo;

public class Car {
    String brand;
    String model;
    int ano;
    Soundcard soundcard;

    public Car() {
    }

    public Car(String brand, String model, int ano, Soundcard soundcard) {
        this.brand = brand;
        this.model = model;
        this.ano = ano;
        this.soundcard = soundcard;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Soundcard getSoundcard() {
        return soundcard;
    }

    public void setSoundcard(Soundcard soundcard) {
        this.soundcard = soundcard;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ano=" + ano +
                ", soundcard=" + soundcard +
                '}';
    }
}
