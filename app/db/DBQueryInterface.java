/*
 * This project is the sole property of Siddharth Mehta. It may not be duplicated or reproduced without my consent. Please direct all technical queries to mehtasiddharth@hotmail.co.uk
 */

/*
 * This file has been created by Siddharth Mehta and is not intended for reuse without permission. It may not be shared outside the scope of the work for which it was designed.
 */

package db;

import models.SearchRegion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBQueryInterface {

    private static Connection conn = JDBCConnector.getConnectionInstance();

    /**
     *
     *
     * @return ResultSet
     */
    public static ResultSet fetchPublicationsAndAuthors(){
        try {
            String sql = "select p.title, a.author_name from publication p, author a where p.id in (select publication_id from author_publication c where a.id = c.author_id)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * \
     * @param searchRegion
     * @return
     */
    public static ResultSet fetchSpatialRegionTitles(SearchRegion searchRegion){
        try {
            String sql = "SELECT title FROM publication\n" +
                    "WHERE ST_Within(spatial_point, linestring(point(" + searchRegion.getSource().getYear() + "," + searchRegion.getSource().getMonth() + ")" + ", point(" + searchRegion.getDestination().getYear() + "," + searchRegion.getDestination().getMonth() + ")))";
            System.out.println(sql);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Close JDBC Connection
     */
    public static void closeConnection() {
        try{
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
