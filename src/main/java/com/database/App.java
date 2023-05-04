package com.database;

/**
 * Hello world!
 *
 */
import java.sql.*;

public class App {

    private static Connection connection;
    public static void main( String[] args ) throws SQLException {
        //create connection for a server installed in localhost, with a user "root" with no password
       try{
           openDatabaseConnection();
           createData("3","l");
           readData();
           
       }finally{ 
           closeDatabaseConnection();
       }
    }


    private static void createData(String id, String name) throws SQLException{
        int rowsInserted;
        try(PreparedStatement statement = connection.prepareStatement(""+
                "INSERT INTO breeder(id , n)"+
                "VALUES(?,?)")
                ){

            statement.setString(1,id);
            statement.setString(2,name);
            rowsInserted = statement.executeUpdate();
        }
        System.out.println("Rows inserted : "+rowsInserted);
    }

    private static void readData() throws SQLException{
        System.out.println("Read Data ....");
        try(PreparedStatement statement = connection.prepareStatement(""+
                "SELECT id ,name FROM breeder")
                ){

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println(id + " : " + name);
            }
        }
    }
    private static void openDatabaseConnection() throws SQLException{
        System.out.println("Connecting to the database....");
        connection = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/farmdb",
            "root",
            ""
        );
        //if(true)throw new RuntimeException("Simulated error!");
        System.out.println("Connection valid : " + connection.isValid(5)) ;
    }

    private static void closeDatabaseConnection() throws SQLException{
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connectiono valid : "+connection.isValid(5));
    }
}
