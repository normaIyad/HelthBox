package com.example.myapp1;

import java.util.Date;

public class meeting {
    String username ;
    int id_number ;
    String address ;
    String compony_name ;
    String doctor_name ;
    String date ;
    int  phone_number ;
    String appointment_type;
    String test_name ;
    String test_paceg ;

    public meeting(String username, int id_number, String address, String compony_name, String doctor_name, String date, int phone_number, String appointment_type, String test_name, String test_paceg) {
        this.username = username;
        this.id_number = id_number;
        this.address = address;
        this.compony_name = compony_name;
        this.doctor_name = doctor_name;
        this.date = date;
        this.phone_number = phone_number;
        this.appointment_type = appointment_type;
        this.test_name = test_name;
        this.test_paceg = test_paceg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompony_name() {
        return compony_name;
    }

    public void setCompony_name(String compony_name) {
        this.compony_name = compony_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getAppointment_type() {
        return appointment_type;
    }

    public void setAppointment_type(String appointment_type) {
        this.appointment_type = appointment_type;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTest_paceg() {
        return test_paceg;
    }

    public void setTest_paceg(String test_paceg) {
        this.test_paceg = test_paceg;
    }
}
