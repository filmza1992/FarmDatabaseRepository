package com.database;

import java.sql.*;
import java.util.ArrayList;

import com.database.util.ReadCSVFile;

public class runScript {
    private Connection connection;
    ArrayList<String[]> allSector;
    ArrayList<String[]> allCenter;
    ArrayList<String[]> allFarmer;
    ArrayList<String[]> allCow;
    ArrayList<String[]> allBreed;
    ArrayList<String[]> allBreeder;
    ArrayList<String[]> allBreederBreed;
    ArrayList<String[]> allCowBreed;
    
    public static void main(String[]args) throws SQLException{
        new runScript();

    }
    public runScript() throws SQLException{
        allSector = new ReadCSVFile("2ty").getData();
        allCenter = new ReadCSVFile("1tx").getData();
        allFarmer = new ReadCSVFile("3farmer").getData();
        allCow = new ReadCSVFile("4cow").getData();
        allCowBreed = new ReadCSVFile("5breed").getData();
        allBreeder = new ReadCSVFile("6tz").getData();
        allBreederBreed = new ReadCSVFile("7tpfdata").getData();
        allBreed = new ReadCSVFile("8tobcode").getData();
        openDatabaseConnection();
        insertAll();
        closeDatabaseConnection();
    }
    private void insertAll() throws SQLException
        {
        // System.out.println("Insert Data to Sector...");
        // try(PreparedStatement statement = connection.prepareStatement(
        //     "INSERT INTO sector(id,name)"
        //         +"VALUES(?,?)"
        // )){
        //     for(String[] sector : allSector){
        //         System.out.println(sector[0] +" "+ sector[1]);
        //         statement.setString(1,sector[0]);
        //         statement.setString(2,sector[1]);
        //         statement.executeUpdate();
                
        //     }
            
        // }
        // System.out.println("END Insert Data Sector");
        // System.out.println("Start\nInsert Data Center");
        // try(PreparedStatement statement = connection.prepareStatement(
        //         "INSERT INTO center(sectorId,id,name,initials,mass,date)"
        //             +"VALUES(?,?,?,?,?,?)")){
        //     for(String[] center : allCenter){
        //         System.out.println(center[0] +" " +center[1] +" " +center[2]);
        //         statement.setString(1,center[0]);
        //         statement.setString(2,center[1]);
        //         statement.setString(3, center[2]);
        //         statement.setString(4,center[3]);
        //         statement.setString(5,center[4]);
        //         statement.setString(6,center[5]);
        //         statement.executeUpdate();
        //     }
        //     System.out.println("END Insert Data Center");
        // };

        // System.out.println("Start\nInsert Data Farmer");
        // try(PreparedStatement statement = connection.prepareStatement(
        //         "INSERT INTO farmer(centerId,id,fpName,fName,sName,birthDate,address,tumbon,ampur,provice,f3,time,startDate,status,amountCow)"
        //             +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")){
        //     for(String[] farmer : allFarmer){
        //         statement.setString(1,farmer[0]);
        //         statement.setString(2,farmer[1]);
        //         statement.setString(3, farmer[2]);
        //         statement.setString(4,farmer[3]);
        //         statement.setString(5,farmer[4]);
        //         statement.setString(6,farmer[5]);
        //         statement.setString(7,farmer[7]);
        //         statement.setString(8,farmer[22]);
        //         statement.setString(9,farmer[8]);
        //         statement.setString(10,farmer[9]);
        //         statement.setString(11,farmer[14]);
        //         statement.setString(12,farmer[17]);
        //         statement.setString(13,farmer[19]);
        //         statement.setString(14,farmer[20]);
        //         statement.setString(15,farmer[21]);
        //         statement.executeUpdate();
        //     }
        //     System.out.println("END Insert Data Farmer");
        // };

        // System.out.println("Start\nInsert Data Cow");
        // try(PreparedStatement statement = connection.prepareStatement(
        //         "INSERT INTO Cow(farmerId , id , status , date , nickName, c_oth , birthDate , momId , dadId , gender , outfg , milk , eurbrd , eurper)"
        //             +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)")){
        //     for(String[] cow : allCow){
        //         statement.setString(1,cow[0]);
        //         statement.setString(2,cow[2]);
        //         statement.setString(3,cow[3]);
        //         statement.setString(4,cow[4]);
        //         statement.setString(5,cow[5]);
        //         statement.setString(6,cow[6]);
        //         statement.setString(7,cow[8]);
        //         statement.setString(8,cow[10]);
        //         statement.setString(9,cow[11]);
        //         statement.setString(10,cow[13]);
        //         statement.setString(11,cow[17]);
        //         statement.setString(12,cow[19]);
        //         statement.setString(13,cow[20]);
        //         statement.setString(14,cow[21]);
                
        //         statement.executeUpdate();
        //     }
        //     System.out.println("END Insert Data Cow");
        // };

        // System.out.println("Start\nInsert Data breed");
        // try(PreparedStatement statement = connection.prepareStatement(
        //         "INSERT INTO breed(id , name , country)"
        //             +"VALUES(?,?,?)")){
        //     for(String[] breed : allBreed){
        //         statement.setString(1,breed[0]);
        //         statement.setString(2,breed[1]);
        //         statement.setString(3,breed[2]);

        //         statement.executeUpdate();
        //     }
        //     System.out.println("END Insert Data breed");
        // };

        // System.out.println("Start\nInsert Data Breeder");
        // try(PreparedStatement statement = connection.prepareStatement(
        //         "INSERT INTO breeder(id , name , dadId , momId)"
        //             +"VALUES(?,?,?,?)")){
        //     for(String[] breeder : allBreeder){
        //         statement.setString(1,breeder[0]);
        //         statement.setString(2,breeder[1]);
        //         statement.setString(3,breeder[2]);
        //         statement.setString(4,breeder[4]);
        //         statement.executeUpdate();
        //     }
        //     System.out.println("END Insert Data Breeder");
        // };

        System.out.println("Start\nInsert Data BreederBreed");
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO breederBreed(breederId , breedId , percen , perInt ,num_up,num_low)"
                    +"VALUES(?,?,?,?,?,?)")){
            for(String[] breederBreed : allBreederBreed){
                statement.setString(1,breederBreed[0]);
                statement.setString(2,breederBreed[1]);
                statement.setString(3,breederBreed[2]);
                statement.setString(4,breederBreed[3]);
                statement.setString(5,breederBreed[4]);
                statement.setString(6,breederBreed[5]);
                
                statement.executeUpdate();
            }
            System.out.println("END Insert Data BreederBreed");
        };

        System.out.println("Start\nInsert Data CowBreed");
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cowBreed(cowId , breedId , percen , perInt,num_up,num_low)"
                    +"VALUES(?,?,?,?,?,?)")){
            for(String[] cowBreed : allCowBreed){
                statement.setString(1,cowBreed[0]);
                statement.setString(2,cowBreed[1]);
                statement.setString(3,cowBreed[2]);
                statement.setString(4,cowBreed[3]);
                statement.setString(5 ,cowBreed[4]);
                statement.setString(6 , cowBreed[5]);

                
                statement.executeUpdate();
            }
            System.out.println("END Insert Data CowBreed");
        };
        
        
    }
    private void readData() throws SQLException{

    }
    private void openDatabaseConnection() throws SQLException{
        System.out.println("Connecting to the database....");
        connection = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/farmdb",
            "root",
            ""
        );
        //if(true)throw new RuntimeException("Simulated error!");
        System.out.println("Connection valid : " + connection.isValid(5)) ;
    }

    private void closeDatabaseConnection() throws SQLException{
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connectiono valid : "+connection.isValid(5));
    }
}
