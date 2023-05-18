package com.example.myapp1;

public class Doctor {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String City;
    private String specialty;

    public Doctor(int id, String name, String phoneNumber, String address , String City ,String specialty) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.City = City;
        this.specialty = specialty;
    }
    public Doctor(String name, String phoneNumber, String address ,String City ,String specialty) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.City = City;
        this.specialty =specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
