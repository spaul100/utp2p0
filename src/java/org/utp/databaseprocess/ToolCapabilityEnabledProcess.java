/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utp.databaseprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.utp.database.toolCapabilityEnabled;
import org.utp.dbhelper.LTI2DBConnection;

/**
 *
 * @author Mukul Gupta
 */
public class ToolCapabilityEnabledProcess {

    public void insert(String[] capability, int id) {

        Connection con = null;
        PreparedStatement pstmt = null;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {


                /*Insert the value into tool_capability_enabled*/
                pstmt = con.prepareStatement("INSERT INTO tool_capability_enabled VALUES(?,?,?,?)");

                /* 
                 * Set the values in the sql statement
                 */
                for (int i = 0; i < capability.length; i++) {
                    pstmt.setInt(1, id);
                    pstmt.setString(2, (String) capability[i]);
                    pstmt.setString(3, null);
                    pstmt.setString(4, null);

                    pstmt.executeUpdate();

                }
            } catch (SQLException sqle) {

            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
            }

        }
    }

    
    
    /**
     * This method is used to insert values in toolcapabilityenabled table
     *
     * @param toolcapabilityEnabled
     */
    public void insert(toolCapabilityEnabled toolcapabilityEnabled) {

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

                /*Insert the value into tool_capability_enabled*/
                pstmt = con.prepareStatement("UPDATE tool_capability_enabled set name=? ,variable=? where id=? and capability=?");

                /* 
                 * Set the values in the sql statement
                 */
               
                pstmt.setString(1, toolcapabilityEnabled.getName());
                pstmt.setString(2, toolcapabilityEnabled.getVariable());
                pstmt.setInt(3, toolcapabilityEnabled.getid());
                pstmt.setString(4, toolcapabilityEnabled.getcapability());

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
     * This method will return all capability for a given id
     *
     * @param id
     * @return capability (array of strings )
     */
    public ArrayList getCapability(int id) {

        ArrayList capability = new ArrayList();

        /*Initialising object of ResultSet*/
        ResultSet result = null;

        Connection con = null;
        PreparedStatement pstmt = null;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {

                /* SQL statement to to fetch all the 
                 * capability for a given id
                 */
                String sql = "SELECT capability FROM  tool_capability_enabled where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in capability arraylist*/
                while (result.next()) {
                    capability.add(result.getString(1));

                }

            } catch (SQLException sqle) {
                capability = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return capability;
    }

    /**
     * This method will return name for a given id
     *
     * @param id
     * @return name (array of strings )
     */
    public ArrayList getName(int id) {

        ArrayList name = new ArrayList();

        /*Initialising object of ResultSet*/
        ResultSet result = null;

        Connection con = null;
        PreparedStatement pstmt = null;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {

                /* SQL statement to to find name 
                 * for given id
                 */
                String sql = "SELECT name FROM  tool_capability_enabled where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in name arraylist*/
                while (result.next()) {
                    name.add(result.getString(1));

                }

            } catch (SQLException sqle) {
                name = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return name;
    }

    /**
     * This method will return variable for a given id
     *
     * @param id
     * @return variable (array of strings )
     */
    public ArrayList getVariable(int id) {

        ArrayList variable = new ArrayList();

        /*Initialising object of ResultSet*/
        ResultSet result = null;

        Connection con = null;
        PreparedStatement pstmt = null;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {

                /* SQL statement to to fetch variable for
                 * a given id
                 */
                String sql = "SELECT variable FROM  tool_capability_enabled where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in variable variable*/
                while (result.next()) {
                    variable.add(result.getString(1));

                }

            } catch (SQLException sqle) {
                variable = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return variable;
    }
}
