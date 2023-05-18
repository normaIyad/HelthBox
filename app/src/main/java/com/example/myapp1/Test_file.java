package com.example.myapp1;

public class Test_file {
    String filename;
    long id;
    String date ;
    long user_id;
    long  compony_id;

    public Test_file(String filename, long id, String date, long user_id, long compony_id) {
        this.filename = filename;
        this.id = id;
        this.date = date;
        this.user_id = user_id;
        this.compony_id = compony_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getCompony_id() {
        return compony_id;
    }

    public void setCompony_id(long compony_id) {
        this.compony_id = compony_id;
    }
}
