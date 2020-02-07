package com.github.nez.database;

import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
    String query;

    public ResultSet executeQuery(Statement statement) {
        try{
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        }
        catch(Exception e){
            throw new Error(e);
        }
    }

    public Query setQuery(String query){
        this.query=query;
        return this;
    }

    public void displayResults(ResultSet resultSet){
        try{
            while(resultSet.next()){}
        }
        catch (Exception e){
            throw new Error(e);
        }
    }
}
