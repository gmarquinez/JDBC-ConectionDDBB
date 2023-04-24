package com.example;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;

public class Application {

    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        try{
            openDatabaseConnection();
            deleteData("%");
            readData();
            createData(1, "12345" ,"Harry Potter", "Gabriel K.Q.", "Sudamericana", 5 , 3 );
            createData(2,"123456" ,"Harry", "Gabriel K.Q.", "Sudamericana", 6 , 3 );
            createData(3,"123457" ,"Harry Pot", "Gabriel K.Q.", "Sudamericana", 7 , 3 );
            readData();
            updateData(3,"456789","HOBBIT", "G.G.M", "Planeta", 6 , 4  );
            deleteData("12345");
            readData();
        } finally {
             closeDatabaseConnection();
        }
    }

    private static void createData(int id_biblioteca ,String isbn, String titulo, String autor, String editorial, int numCopias, int numCopiasDisponibles) throws SQLException {
        System.out.println("Creating Data...");
        int rowsInserted;
        try (PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO libros (id_biblioteca ,ISBN, titulo, autor, editorial, numCopias, numCopiasDisponibles) VALUES (?,?,?,?,?,?,?)")){

            statement.setInt(1, id_biblioteca);
            statement.setString(2, isbn);
            statement.setString(3, titulo);
            statement.setString(4, autor);
            statement.setString(5, editorial);
            statement.setInt(6, numCopias);
            statement.setInt(7, numCopiasDisponibles);
            rowsInserted = statement.executeUpdate();
        }
        System.out.println("Rouws Inserted:" + rowsInserted);
    }


    private static void readData() throws SQLException {
        System.out.println("Reading data...");
        try (PreparedStatement statement= connection.prepareStatement("SELECT isbn, autor, editorial FROM libros")){
            ResultSet resultSet = statement.executeQuery();
            boolean empty = true;
           while(resultSet.next()){
               String isbn = resultSet.getString("isbn");
               String autor = resultSet.getString("autor");
               String editorial = resultSet.getString("editorial");
               System.out.println("\t* " + isbn + ": " + autor + ": " + editorial);
               empty = false;
           }
           if(empty){
               System.out.println("\t (No data)");
           }
        }
    }

    private static void updateData(int id_biblioteca ,String isbn, String titulo, String autor, String editorial, int numCopias,
                                   int numCopiasDisponibles) throws SQLException {
        System.out.println("Updating data...");
        try (PreparedStatement statement = connection.prepareStatement("UPDATE libros SET isbn = ?, titulo = ?, autor = ?, editorial = ?, numcopias = ?, numcopiasdisponibles = ? WHERE id_biblioteca = ?")) {
            statement.setString(1, isbn);
            statement.setString(2, titulo);
            statement.setString(3, autor);
            statement.setString(4, editorial);
            statement.setInt(5, numCopias);
            statement.setInt(6, numCopiasDisponibles);
            statement.setInt(7, id_biblioteca);
            int rowsUpdate = statement.executeUpdate();
            System.out.println("Rows Updated: " + rowsUpdate);
        }
    }

    private static void deleteData(String nameExpresion) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM libros WHERE isbn= ?")) {
            statement.setString( 1, nameExpresion);
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        }
    }


    private static void openDatabaseConnection() throws SQLException {
        System.out.println("Connecting to the database");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/biblioteca",
                "test", "test");
        //if(true) throw new RuntimeException("Simulated error!");
        System.out.println("Connection Valid:" + connection.isValid(5));
    }

    private static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection Valid:" + connection.isValid(5));

    }
}
