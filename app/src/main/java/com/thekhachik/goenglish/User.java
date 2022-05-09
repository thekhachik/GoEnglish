package com.thekhachik.goenglish;

public class User {
    private String name, email, password, lvl;
    private int ava;

    public User(){}

    public User(String name, String email, String password, String lvl, int ava) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.lvl = lvl;
        this.ava = ava;
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

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public int getAva() {
        return ava;
    }

    public void setAva(int ava) {
        this.ava = ava;
    }
}
