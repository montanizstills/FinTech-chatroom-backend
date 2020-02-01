package com.github.nez.Database;


import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBMonolith {

    public void loadMariaDBDriver(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver Loaded");
        }
        catch(Exception e){
            throw new Error (e);
        }
    }
    public java.sql.Connection dbConnection(String dbVendor, String dbName){
        try{
            Connection connection = DriverManager.getConnection("jdbc:"+dbVendor+"://localhost/"+dbName,"root","");
            System.out.println("Database Connected");
            return connection;
        }
        catch(Exception e){
            throw new Error(e);
        }
    }
    public Statement createStatement(Connection connection){
        try {
        Statement statement =  connection.createStatement();
            return statement;
            }
            catch(Exception e){
                throw new Error(e);
            }
        }

        public java.sql.ResultSet executeQuery(java.sql.Statement statement ){
        try{
            ResultSet resultSet = statement.executeQuery("Select firstName, lastName, id From Student;");
            return resultSet;
        }
        catch(Exception e){
            throw new Error(e);
        }
    }

    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        DBMonolith dbMonolith = new DBMonolith();
        dbMonolith.loadMariaDBDriver();
        Connection dbConnection=dbMonolith.dbConnection("mariadb","collegemanagement");
        Statement dbStatement = dbMonolith.createStatement(dbConnection);
        ResultSet resultSet = dbMonolith.executeQuery(dbStatement);
        while(resultSet.next()){
            System.out.println(
                    resultSet.getString(1)+"\t"+
                            resultSet.getString(2)+"\t"+
                            resultSet.getString(3)
            );
        }
    }
}
