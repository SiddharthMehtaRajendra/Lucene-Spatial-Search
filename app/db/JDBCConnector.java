/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

/*
 * This file has been created by Siddharth Mehta and is not intended for reuse without permission. It may not be shared outside the scope of the work for which it was designed.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

    private volatile static Connection conn;

    private JDBCConnector(){}

    /**
     * This is a Singleton class which generates only one instance of The JDBC Connector to preserve memory.
     * @return
     */
    public static Connection getConnectionInstance(){
        if(conn == null) {
            synchronized (JDBCConnector.class) {
                if (conn == null) {
                    try {
                        conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/soc_publication",
                                "root", "Fiserv2of2a!");
                    } catch(SQLException e){
                        System.out.println("Exception Occurred" + e);
                    }
                }
            }
        }
        return conn;
    }



}
