package com.example.myapp1;

public class test_pac {
    int id ;
    String name ;
    String drs ;

    public test_pac(int id, String name, String drs) {
        this.id = id;
        this.name = name;
        this.drs = drs;
    }
    public test_pac(String name, String drs) {
        this.name = name;
        this.drs = drs;
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

    public String getDrs() {
        return drs;
    }

    public void setDrs(String drs) {
        this.drs = drs;
    }
}
