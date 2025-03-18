/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Ald;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author aca
 */
public class DatabaseConnection {
    private static Connection connection;
    private String host, database, username, password;
    private int port = 3306;

    public DatabaseConnection(String host, String database, String username, String password) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
    }
    
    public Connection getConnection() throws SQLException{
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println("No existe la clase");
        }
        
        String url = "jdbc:mariadb://" + host + ":" + port + "/" + database;
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    
    
}
