package com.github.nez.database;

import org.mariadb.jdbc.Driver;

import java.sql.DriverManager;


public class RegisterDriver {
    public RegisterDriver (){}
    public void register(){
        try{
            DriverManager.registerDriver(Driver.class.newInstance());
        }
        catch (Exception e){
            throw new Error(e);
        }
    }
}
