package com.example.myapp1;

public class User {
    String name ;
    String email ;
    String password1;
    String password2;
    int number;

    public User(String name, String email, String password1, String password2, int number) {
        this.name = name;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
