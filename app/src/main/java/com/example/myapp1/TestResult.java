package com.example.myapp1;

public class TestResult {
    String name;
     int id;
     String date ;
     int user_id;
     int  compony_id;
    public TestResult(String name, int id, String date, int user_id, int  compony_id) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.user_id = user_id;
        this.compony_id = compony_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int  getCompony_id() {
        return compony_id;
    }
    public void setCompony_id(int compony_id) {
        this.compony_id = compony_id;
    }
}
