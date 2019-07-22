package com.example.demo;

public class Usb {
    int mem;
    String model;

    public Usb() {
    }

    public Usb(int mem, String model) {
        this.mem = mem;
        this.model = model;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Usb{" +
                "mem=" + mem +
                ", model='" + model + '\'' +
                '}';
    }
}
