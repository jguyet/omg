package com.omg.models;

import com.omg.database.collection.BaseCollection;
import com.google.code.morphia.annotations.Property;

public class Account extends BaseCollection {

    @Property("username")
    private String username;
    @Property("password")
    private String password;

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Account() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
