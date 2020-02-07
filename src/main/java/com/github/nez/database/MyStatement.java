package com.github.nez.database;

import java.sql.Connection;
import java.sql.Statement;

public class MyStatement {
    public Statement createStatement (Connection connection){
        try{
            Statement statement = connection.createStatement();
            return statement;
        }
        catch(Exception e){
            throw new Error(e);
        }
    }
}
