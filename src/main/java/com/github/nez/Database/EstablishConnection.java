package com.github.nez.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EstablishConnection {
    public EstablishConnection() {
    }

    public void run() {

        RegisterDriver registerDriver = new RegisterDriver(); //difference between this and Class.forName("blahblah") ??
        registerDriver.register();
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection("mariadb", "", "perScholas", "student123");
        MyStatement myStatement = new MyStatement();
        Statement statement = myStatement.createStatement(connection);
        Query query = new Query();
        ResultSet resultSet = query.setQuery(SQLQueries.SELECTACCOUNT.toString()).executeQuery(statement);
        query.displayResults(resultSet);
    }
}
