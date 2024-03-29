// RelDatabase.java
// Author: José Alexander Brenes Brenes
// Description: Establishes the relationship between the application and the database
package aerolinea.datos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RelDatabase {

    private static final String PROPERTIES_FILE_PATH = "properties/aerolinea.properties";
    public static final String PROPERTIES_FILE_NAME = PROPERTIES_FILE_PATH;
    Connection cnx;
    private static RelDatabase instance;

    private RelDatabase() {
        cnx = this.getConnection();
    }

    public static RelDatabase getInstance() {
        if (instance == null) {
            instance = new RelDatabase();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Properties prop = new Properties();
            URL resourceUrl = getClass().getResource(PROPERTIES_FILE_NAME);
            File file = new File(resourceUrl.toURI());
            prop.load(new BufferedInputStream(new FileInputStream(file)));
            String driver = prop.getProperty("database_driver");
            String server = prop.getProperty("database_server");
            String port = prop.getProperty("database_port");
            String user = prop.getProperty("database_user");
            String password = prop.getProperty("database_password");
            String database = prop.getProperty("database_name");
            String URL_conexion = "jdbc:mysql://" + server + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC&user=" + user + "&password=" + password + "&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(URL_conexion);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return null;
    }

    public int executeUpdate(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    public ResultSet executeQuery(String statement) {
        try {
            Statement stm = cnx.createStatement();
            return stm.executeQuery(statement);
        } catch (SQLException ex) {
        }
        return null;
    }

}
