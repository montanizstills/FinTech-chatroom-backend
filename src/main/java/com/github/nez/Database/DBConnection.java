package com.github.nez.Database;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    String username;
    String password;

    public Connection getConnection(String dbVendor, String dbName, String usernameInput, String passwordInput){
        this.username=usernameInput;
        this.password=passwordInput;
        try {
            Connection connection = DriverManager.getConnection("jdbc:" + dbVendor + "://chattixdb.cwo51ixo5unr.us-east-2.rds.amazonaws.com" + dbName, getUsername(), getPassword());
            return connection;
        }
        catch(Exception e){
            throw new Error(e);
        }

    }
    public void setUsername(String usernameInput){
        this.username = usernameInput;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
}
