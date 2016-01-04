/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utp.databaseprocess;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import org.utp.dbhelper.LTI2DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.utp.database.RegisteredTool;

/**
 *
 * @author mukul
 */
public class ToolDetailsProcess {

    /**
     * This method will insert tooldetail in tool_detail table for next toolId
     *
     * @param toolDetail
     * @return id
     */
    public int insert(String toolDetail) throws JSONException {

        Connection con = null;
        PreparedStatement pstmt = null;
        int id = 0;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {
                /*turn off auto commit*/
                con.setAutoCommit(false);

                /*find next id*/
                id = nextToolId();

                /*Insert the value into tool_detail*/
                pstmt = con.prepareStatement("INSERT INTO tool_detail VALUES(?,?,?,?,?,?,?)");

                /*create jsonobject of tooldetail*/
                JSONObject test = new JSONObject();
                JSONObject json = new JSONObject(toolDetail);

                /*
                 * Set the values in the sql statement
                 */
                pstmt.setInt(1, id);
                pstmt.setString(2, toolDetail);
                pstmt.setString(3, null);
                pstmt.setString(4, null);
                pstmt.setString(5, (String) json.get("Tool_Url"));
                pstmt.setString(6, null);
                pstmt.setString(7, null);
           
                pstmt.executeUpdate();
                con.commit();

            } catch (SQLException sqle) {

            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
            }

        }

        return id;
    }

    /**
     * This method will fetch all the recommended parameter from tool_detail
     * table for a particular id
     *
     * @param id
     * @return recommended
     */
    public String getRecommendedParameter(int id) {

        String recommended = null;

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

                /* SQL statement to to find all the
                 *recommended parameter for given id
                 */
                String sql = "SELECT recommended_parameter FROM  tool_detail where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in recommended variable*/
                if (result.next()) {
                    recommended = result.getString(1);

                }

            } catch (SQLException sqle) {
                recommended = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return recommended;
    }

    /**
     * This method will fetch all the optional parameter from tool_detail table
     * for a particular id
     *
     * @param id
     * @return optional
     */
    public String getOptionalParameter(int id) {

        String optional = null;

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

                /* SQL statement to fetch all the optional
                 *parameter for a given tool_detail
                 */
                String sql = "SELECT optional_parameter FROM  tool_detail where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in optional variable*/
                if (result.next()) {
                    optional = result.getString(1);

                }

            } catch (SQLException sqle) {
                optional = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return optional;
    }

    /**
     * This method will insert recommended parameter and optional parameter in
     * tool_detail table for a given tool_id
     *
     * @param recommended_parameter
     * @param optional_parameter
     * @param id
     * @throws JSONException
     */
    public void insert(String recommended_parameter, String optional_parameter, int id) throws JSONException {

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

                /*Insert the value into tool_detail*/
                if (isValid(id)) {

                    pstmt = con.prepareStatement("Update tool_detail set recommended_parameter =? , optional_parameter = ? where id = ?");

                    /* 
                     * Set the values in the sql statement
                     */
                    pstmt.setString(1, recommended_parameter);
                    pstmt.setString(2, optional_parameter);
                    pstmt.setInt(3, id);

                    pstmt.executeUpdate();

                    con.commit();
                }
            } catch (SQLException sqle) {

            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
            }

        }

    }

    /**
     * This method check whether the given id is valid or nt
     *
     * @param id
     * @return true (if valid) false (not valid)
     */
    public boolean isValid(int id) {

        int ans = 0;

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

                /* SQL statement to count total row for given id
                 */
                String sql = "SELECT count(*) FROM  tool_detail where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in ans variable*/
                if (result.next()) {
                    ans = result.getInt(1);

                }

            } catch (SQLException sqle) {
                ans = -1;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        if (ans == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to calculate next valid id for tool_detail table
     *
     * @return id
     */
    public synchronized int nextToolId() {

        ResultSet result = null;
        int id = 0;

        Connection con = null;
        PreparedStatement pstmt = null;

        /* Establish connection with the database if not already connected */
        if (LTI2DBConnection.isClosed(con)) {
            con = LTI2DBConnection.getDBConnection();
        }

        if (!LTI2DBConnection.isClosed(con)) {
            try {

                /* SQL statement to find max id in tool_detail table
                 */
                String sql = "SELECT MAX(id) FROM tool_detail";
                pstmt = con.prepareStatement(sql);

                result = pstmt.executeQuery();

                /*calculate the result and store in id variable*/
                if (result.next()) {
                    id = result.getInt("MAX(id)");
                } else {
                    id = 0;
                }

                id++;

            } catch (SQLException sqle) {
                id = -1;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);

            }
        }
        return id;
    }

    /**
     * This method is used to calculate tool detail for given id
     *
     * @param id
     * @return toolDetail
     */
    public String getToolDetail(int id) {

        String toolDetail = null;

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

                /* SQL statement to fetch tool_detail
                 * for given tool_id
                 */
                String sql = "SELECT json_tool FROM  tool_detail where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in tool_detail variable*/
                if (result.next()) {
                    toolDetail = result.getString(1);

                }

            } catch (SQLException sqle) {
                toolDetail = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return toolDetail;
    }

    /**
     * This method will fetch all the tool profile from tool_detail
     *
     * @return registeredTool (array of RegisteredTool)
     * @throws JSONException
     */
    public ArrayList getRegisteredTool() throws JSONException {

        ArrayList<RegisteredTool> registeredTool = new ArrayList();

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

                /* SQL statement to select all the tool detail
                 */
                String sql = "SELECT * FROM  tool_detail";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);

                result = pstmt.executeQuery();

                /*calculate the result and store in registeredTool variable*/
                while (result.next()) {
                    RegisteredTool details = new RegisteredTool();

                    String json = result.getString(2);
                    JSONObject jsondetail = new JSONObject(json);
                    JSONObject msg1 = jsondetail.getJSONObject("product_instance");
                    JSONObject msg2 = msg1.getJSONObject("product_info");
                    JSONObject msg3 = msg2.getJSONObject("product_name");

                    details.settoolId(result.getInt(1));
                    details.setToolName((String) msg3.get("default_value"));
                    details.setRegistrationUrl(getRegisterationUrl(result.getInt(1)));
                    details.setToolProfile(result.getString(2));

                    registeredTool.add(details);
                }

            } catch (SQLException sqle) {
                registeredTool = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return registeredTool;
    }

    /**
     * This method will insert registeredUrl in toolurl table for given id
     *
     * @param toolUrl
     */
    public void insertRegisteredUrl(String toolUrl ,int id) {

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
                /*Insert the value into tool_url*/
                pstmt = con.prepareStatement("Update tool_detail set  registration_url = ?  where id = ?");

                /* 
                 * Set the values in the sql statement
                 */
                pstmt.setInt(2, id);
                pstmt.setString(1, toolUrl);

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
     * This method will insert registeredUrl in toolurl table for given id
     *
     * @param toolUrl
     */
    public void insertLaunchUrl(String launchUrl ,int id) {

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
                /*Insert the value into tool_url*/
                pstmt = con.prepareStatement("Update tool_detail set  launch_url = ?  where id = ?");

                /* 
                 * Set the values in the sql statement
                 */
                pstmt.setInt(2, id);
                pstmt.setString(1, launchUrl);

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
     * this method will fetch url for given id
     *
     * @param id
     * @return toolUrl
     */
    public String getToolUrl(int id) {

        String toolUrl = null;

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

                /* SQL statement to fetch the url
                 *for given id
                 */
                String sql = "SELECT tool_url FROM  tool_detail where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in toolUrl variable*/
                if (result.next()) {
                    toolUrl = result.getString(1);

                }

            } catch (SQLException sqle) {
                toolUrl = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return toolUrl;
    }

    /**
     * this method will fetch registrationUrl for given id
     *
     * @param id
     * @return toolUrl
     */
    public String getRegisterationUrl(int id) {

        String registerationUrl = null;

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

                /* SQL statement to fetch the url
                 *for given id
                 */
                String sql = "SELECT registration_url FROM  tool_detail where "
                        + "id = ? ";

                /* 
                 * Set the values in the sql statement
                 */
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                result = pstmt.executeQuery();

                /*calculate the result and store in registrationUrl variable*/
                if (result.next()) {
                    registerationUrl = result.getString(1);

                }

            } catch (SQLException sqle) {
                registerationUrl = null;
            } finally {
                LTI2DBConnection.closePStatement(pstmt);
                LTI2DBConnection.closeDBConnection(con);
                LTI2DBConnection.closeResultSet(result);
            }

        }
        return registerationUrl;
    }
    

}
