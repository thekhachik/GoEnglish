package com.thekhachik.goenglish;

public class User {
    private String name, email, password;
    private int points;

    public User(){}

    public User(String name, String email, String password, int points) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.points = points;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
