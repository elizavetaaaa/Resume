package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class SqlCon{
    static Connection crunchifyConn = null;
    static PreparedStatement crunchifyPrepareStat = null;
    private static void main(String args[]){
        /*try {
            System.out.println("-------- Simple Crunchify Tutorial on how to make JDBC connection to MySQL DB locally on macOS ------------");
            makeJDBCConnection();

            System.out.println("\n---------- Adding company 'Crunchify LLC' to DB ----------");
            addDataToDB("Ahmed", "Bek", "ahmed@gmail.com");


            System.out.println("\n---------- Let's get Data from DB ----------");
            getDataFromDB();

            crunchifyPrepareStat.close();
            crunchifyConn.close(); // connection close

        } catch (SQLException e) {

            e.printStackTrace();
        }*/
    }

    public static void makeJDBCConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");}
        catch (ClassNotFoundException e) {
            System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            crunchifyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume","test","test");
            if (crunchifyConn != null) {
                System.out.println("Connection Successful! Enjoy. Now it's time to push data");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("MySQL Connection Failed!");
            e.printStackTrace();

        }

    }


    public static void addDataToDB(String name, String surname, String email) {

        try {
            String insertQueryStatement = "INSERT  INTO  person  VALUES  (?,?,?)";

            crunchifyPrepareStat = crunchifyConn.prepareStatement(insertQueryStatement);
            crunchifyPrepareStat.setString(1, name);
            crunchifyPrepareStat.setString(2, surname);
            crunchifyPrepareStat.setString(3, email);


            // execute insert SQL statement
            crunchifyPrepareStat.executeUpdate();
            System.out.println(name + " added successfully");
        } catch (

                SQLException e) {
            e.printStackTrace();
        }
    }


    public static void getDataFromDB() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM person";

            crunchifyPrepareStat = crunchifyConn.prepareStatement(getQueryStatement);

            // Execute the Query, and get a java ResultSet
            ResultSet rs = crunchifyPrepareStat.executeQuery();

            // Let's iterate through the java ResultSet
            while (rs.next()) {
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String email = rs.getString("Email");
                // Simply Print the results
                System.out.format("%s, %s, %s ", name, surname, email);
            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }

    }

    // Simple log utility
    private static void log(String string) {
        System.out.println(string);

    }
}




