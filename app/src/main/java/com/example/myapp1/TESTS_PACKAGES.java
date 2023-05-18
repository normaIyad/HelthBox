package com.example.myapp1;

public class TESTS_PACKAGES {
    int id ;
    String name ;
    String des;
    public TESTS_PACKAGES(String name, String des) {
        this.name = name;
        this.des = des;
    }
    public TESTS_PACKAGES(int id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
