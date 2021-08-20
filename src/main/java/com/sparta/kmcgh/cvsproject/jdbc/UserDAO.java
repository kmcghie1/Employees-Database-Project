package com.sparta.kmcgh.cvsproject.jdbc;

import java.sql.*;

public class UserDAO {

    private Connection connection;
    private Statement statement;

    public UserDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllUsers() {
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //(`id`, `prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `date_of_birth`, `date_of_joining`, `salary`)
    public void createRecord(int employeeId, String namePrefix, String firstName, char middleInitial, String lastName, char gender, String email, String dateOfBirth, String dateOfJoining, int salary) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, String.valueOf(middleInitial));
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, String.valueOf(gender));
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, dateOfBirth);
            preparedStatement.setString(9, dateOfJoining);
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(int id, String userName, String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.UPDATE);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
