package com.mycompany.afterupdate;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private Connection connection;

    public void createConnection() throws IOException, ClassNotFoundException, SQLException {

        Properties prop = new Properties();

        prop.load(new FileInputStream(System.getProperty("user.home") + "/mydb.cfg"));

        System.out.println("user.home: " + System.getProperty("user.home"));
        String host = prop.getProperty("host").toString();
        String username = prop.getProperty("username").toString();
        String password = prop.getProperty("password").toString();
        String driver = prop.getProperty("driver").toString();

        System.out.println("host: " + host + "\nusername: " + username + "\npassword: " + password + "\ndriver: " + driver);

        Class.forName(driver);
        connection = DriverManager.getConnection(host, username, password);
        System.out.println("Connection Object: " + connection);
    }

    public String getDbInfo() throws SQLException, ClassNotFoundException, IOException{
        
        String result = "";        
        createConnection();
        DatabaseMetaData dmd = getConnection().getMetaData();
        
        result = dmd.getDatabaseProductVersion()+"\n"+dmd.getURL()+"\n";
                
        return result;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    
}
