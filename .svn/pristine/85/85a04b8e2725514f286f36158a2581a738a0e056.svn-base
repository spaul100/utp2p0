/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utp.databaseprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.utp.database.BltiKeys;
import org.utp.dbhelper.LTI2DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author Mukul Gupta
 */
public class BltiKeysProcess {

    /**
     * This method is used to insert values into bltikeys table
     *
     * @param bltiKeys
     */
    public void insert(BltiKeys bltiKeys) {

        Connection con = null;
        PreparedStatement pstmt = null;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {
                /*turn off auto commit*/
                con.setAutoCommit(false);

                /*set a save point*/
                /*Insert the value into blti_keys*/
                pstmt = con.prepareStatement("INSERT INTO blti_keys VALUES(?,?)");

                /* 
                 * Set the values in the sql statement
                 */
                pstmt.setString(1, bltiKeys.getOauthConsumerKey());
                pstmt.setString(2, bltiKeys.getSecret());

                pstmt.executeUpdate();
                con.commit();

            } catch (SQLException sqle) {

            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
            }

        }
    }

    /**
     *
     * This method will fetch secret key for given oauthConsumerKey
     *
     * @return secret
     * @param bltiKeys
     */
    public String getSecret(String oauthConsumerKey) {

        Connection con = null;
        PreparedStatement pstmt = null;
        String secret = null;
        String sql;

        /*Initialising object of ResultSet*/
        ResultSet result = null;
        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {

                /*sql statement to fetch secret key for a given oauthconsumerkey*/
                sql = ("SELECT secret FROM blti_keys WHERE oauth_consumer_key=?");
                pstmt = con.prepareStatement(sql);

                /* 
                 * Set the values in the sql statement
                 */
                pstmt.setString(1, oauthConsumerKey);

                result = pstmt.executeQuery();

                /*fetch the result in secret variable*/
                if (result.next()) {
                    secret = result.getString(1);
                }

            } catch (SQLException sqle) {

            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeResultSet(result);
                LTI2DBConnection.closeDBConnection(con);
            }

        }
        return secret;
    }
}
