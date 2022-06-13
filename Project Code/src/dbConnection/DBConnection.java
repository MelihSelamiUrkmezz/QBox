
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection{
    public static final String db_username="root";
    public static final String db_password="";
    public static final String db_name="QBox";
    public static final String db_host="localhost";
    public static final int db_port=30306;
    public Connection con=null;
    public Statement sqlquery=null;
    public PreparedStatement psqlquery=null;
    public ResultSet rs = null;

    public DBConnection() {
        
        String url="jdbc:mysql://"+DBConnection.db_host+":"+DBConnection.db_port+"/"+DBConnection.db_name+"?useUnicode=true&characterEncoding=utf8";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.print("Sql driver is not found.");

        }
        try {
            con = DriverManager.getConnection(url, DBConnection.db_username, DBConnection.db_password);
            System.out.println("Connection is succesfuly..");
        } catch (SQLException e) {
            System.out.println("Connection is not succesfuly.");
        }
         
    }

}
