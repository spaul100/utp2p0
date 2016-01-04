/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utp.toolRegistration;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.validator.UrlValidator;
import org.utp.databaseprocess.ToolCapabilityEnabledProcess;
import org.utp.databaseprocess.ToolDetailsProcess;
import org.utp.utils.Constants;

/**
 *
 * @author Sourav Kumar Paul
 */


public class SubmitToolProfile extends HttpServlet {

    
     private boolean isInteger(String value){
        boolean status=true;
        if(value.length()<1)
            return false;
        for(int i = 0;i<value.length();i++){
            char c=value.charAt(i);
            if(Character.isDigit(c) || c=='.'){
                
            }else{
                status=false;
                break;
            }
        }
        return status;
    }
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession(false);
        String isLoggedIn = (String) session.getAttribute(Constants.LOGGED_IN);
    if(isLoggedIn != null && isLoggedIn.equals("true")) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //direct on 2nd page of tool regestration in which dynamic values are entered and inserting tool regestration page values into data base
        //in form of Json Object.
        //fetching the values of variable from the tool registration form
        request.setAttribute("empty1", "");
        request.setAttribute("empty2", "");
        request.setAttribute("empty3", "");
        request.setAttribute("empty4", "");
        request.setAttribute("empty5", "");
        request.setAttribute("empty6", "");
        request.setAttribute("empty7", "");
        request.setAttribute("empty8", "");
        request.setAttribute("empty9", "");
        request.setAttribute("empty10", "");
        request.setAttribute("empty11", "");
        request.setAttribute("empty12", "");
        request.setAttribute("empty13", "");
        request.setAttribute("empty14", "");
        request.setAttribute("empty15", "");
        request.setAttribute("empty16", "");
        request.setAttribute("empty17", "");
        request.setAttribute("empty18", "");
        request.setAttribute("empty19", "");
        request.setAttribute("empty20", "");
        request.setAttribute("empty21", "");
        request.setAttribute("empty22", "");
        request.setAttribute("empty23", "");
        request.setAttribute("empty24", "");
        request.setAttribute("empty25", "");
        request.setAttribute("empty26", "");
        request.setAttribute("empty27", "");
        request.setAttribute("empty28", "");
        request.setAttribute("empty29", "");
        request.setAttribute("empty30", "");
        request.setAttribute("empty31", "");
        request.setAttribute("empty32", "");
        request.setAttribute("empty33", "");
        request.setAttribute("empty34", "");
        request.setAttribute("empty35", "");
        request.setAttribute("empty36", "");
        request.setAttribute("empty37", "");
        request.setAttribute("empty38", "");
        request.setAttribute("empty39", "");
        String[] check = new String[50];
        int flag = 0;
        String Version = request.getParameter("Version");
        check[0] = ".";
        check[1] = Version;
        String Product_Default_Value = request.getParameter("Product_Default_Value");
        check[2] = Product_Default_Value;
        if (check[2] == "") {
            flag = 1;
            request.setAttribute("empty2", "*Please fill this entry");
        }
        String Product_Key = request.getParameter("Product_Key");
        check[3] = Product_Key;
        if (check[3] == "") {
            flag = 1;
            request.setAttribute("empty3", "*Please fill this entry");
        }
        String Product_Description_Defaultvalue = request.getParameter("Product_Description_Defaultvalue");
        check[4] = Product_Description_Defaultvalue;
        if (check[4] == "") {
            flag = 1;
            request.setAttribute("empty4", "*Please fill this entry");
        }
        String Tool_Description_Key = request.getParameter("Tool_Description_Key");
        check[5] = Tool_Description_Key;
        if (check[5] == "") {
            flag = 1;
            request.setAttribute("empty5", "*Please fill this entry");
        }
        String Product_Version = request.getParameter("Product_Version");
        check[6] = Product_Version;
        if (check[6] == "") {
            flag = 1;
            request.setAttribute("empty6", "*Please fill this entry");
        }
        String Technical_Description_Defaultvalue = request.getParameter("Technical_Description_Defaultvalue");
        check[7] = Technical_Description_Defaultvalue;
        if (check[7] == "") {
            flag = 1;
            request.setAttribute("empty7", "*Please fill this entry");
        }
        String Tool_Technical_Description_Key = request.getParameter("Tool_Technical_Description_Key");
        check[8] = Tool_Technical_Description_Key;
        if (check[8] == "") {
            flag = 1;
            request.setAttribute("empty8", "*Please fill this entry");
        }
        String Vendor_Name_Defaultvalue = request.getParameter("Vendor_Name_Defaultvalue");
        check[9] = Vendor_Name_Defaultvalue;
        if (check[9] == "") {
            flag = 1;
            request.setAttribute("empty9", "*Please fill this entry");
        }
        String Vendor_Name_Key = request.getParameter("Vendor_Name_Key");
        check[10] = Vendor_Name_Key;
        if (check[10] == "") {
            flag = 1;
            request.setAttribute("empty10", "*Please fill this entry");
        }
        String Vendor_Description_Defaultvalue = request.getParameter("Vendor_Description_Defaultvalue");
        check[11] = Vendor_Description_Defaultvalue;
        if (check[11] == "") {
            flag = 1;
            request.setAttribute("empty11", "*Please fill this entry");
        }
        String Vendor_Description_Key = request.getParameter("Vendor_Description_Key");
        check[12] = Vendor_Description_Key;
        if (check[12] == "") {
            flag = 1;
            request.setAttribute("empty12", "*Please fill this entry");
        }
        String Website = request.getParameter("Website");
        check[13] = Website;
        if (check[13] == "") {
            flag = 1;
            request.setAttribute("empty13", "*Please fill this entry");
        }
        String Contact = request.getParameter("Contact");
        check[14] = Contact;
        if (check[14] == "") {
            flag = 1;
            request.setAttribute("empty14", "*Please fill this entry");
        }
        String Support_Team = request.getParameter("Support_Team");
        check[15] = Support_Team;
        if (check[15] == "") {
            flag = 1;
            request.setAttribute("empty15", "*Please fill this entry");
        }
        String Service_Provider_Name_Defaultvalue = request.getParameter("Service_Provider_Name_Defaultvalue");
        check[16] = Service_Provider_Name_Defaultvalue;
        if (check[16] == "") {
            flag = 1;
            request.setAttribute("empty16", "*Please fill this entry");
        }
        String Service_Provider_Name_Key = request.getParameter("Service_Provider_Name_Key");
        check[17] = Service_Provider_Name_Key;
        if (check[17] == "") {
            flag = 1;
            request.setAttribute("empty17", "*Please fill this entry");
        }
        String Service_Provider_Description_Defaultvalue = request.getParameter("Service_Provider_Description_Defaultvalue");
        check[18] = Service_Provider_Description_Defaultvalue;
        if (check[18] == "") {
            flag = 1;
            request.setAttribute("empty18", "*Please fill this entry");
        }
        String Service_Provider_Description_Key = request.getParameter("Service_Provider_Description_Key");
        check[19] = Service_Provider_Description_Key;
        if (check[19] == "") {
            flag = 1;
            request.setAttribute("empty19", "*Please fill this entry");
        }
        String Service_Provider_Support = request.getParameter("Service_Provider_Support");
        check[20] = Service_Provider_Support;
        if (check[20] == "") {
            flag = 1;
            request.setAttribute("empty20", "*Please fill this entry");
        }
        String Service_Owner_Name_Defaultvalue = request.getParameter("Service_Owner_Name_Defaultvalue");
        check[21] = Service_Owner_Name_Defaultvalue;
        if (check[21] == "") {
            flag = 1;
            request.setAttribute("empty21", "*Please fill this entry");
        }
        String Service_Owner_Name_Key = request.getParameter("Service_Owner_Name_Key");
        check[22] = Service_Owner_Name_Key;
        if (check[22] == "") {
            flag = 1;
            request.setAttribute("empty22", "*Please fill this entry");
        }
        String Service_Owner_Description_Defaultvalue = request.getParameter("Service_Owner_Description_Defaultvalue");
        check[23] = Service_Owner_Description_Defaultvalue;
        if (check[23] == "") {
            flag = 1;
            request.setAttribute("empty23", "*Please fill this entry");
        }
        String Service_Owner_Description_Key = request.getParameter("Service_Owner_Description_Key");
        check[24] = Service_Owner_Description_Key;
        if (check[24] == "") {
            flag = 1;
            request.setAttribute("empty24", "*Please fill this entry");
        }
        String Service_Owner_guid = request.getParameter("Service_Owner_guid");
        check[25] = Service_Owner_guid;
        if (check[25] == "") {
            flag = 1;
            request.setAttribute("empty25", "*Please fill this entry");
        }
        String lti_path = request.getParameter("lti_path");
        check[26] = lti_path;
        if (check[26] == "") {
            flag = 1;
            request.setAttribute("empty26", "*Please fill this entry");
        }
        String lti_message_type = request.getParameter("message_type");
        check[27] = lti_message_type;
        if (check[27] == "") {
            flag = 1;
            request.setAttribute("empty27", "*Please fill this entry");
        }
        String Capability_Wanted[] = request.getParameterValues("Capability_Offered");
        String Services_Wanted[] = request.getParameterValues("Services_Offered");
        String Tool_Url = request.getParameter("Tool_Url");
        check[28] = Tool_Url;
        System.out.println(Tool_Url);
        if (check[28] == "") {
            flag = 1;
            request.setAttribute("empty28", "*Please fill this entry");
        }
        String Vendor_Code = request.getParameter("Vendor_Code");
        check[29] = Vendor_Code;
        if (check[29] == "") {
            flag = 1;
            request.setAttribute("empty29", "*Please fill this entry");
        }
        String Product_id = request.getParameter("Product_id");
        check[30] = Product_id;
        if (check[30] == "") {
            flag = 1;
            request.setAttribute("empty30", "*Please fill this entry");
        }
        String Product_Code = request.getParameter("Product_Code");
        check[31] = Product_Code;
        if (check[31] == "") {
            flag = 1;
            request.setAttribute("empty31", "*Please fill this entry");
        }
        String Service_Provider_guid = request.getParameter("Service_Provider_guid");
        check[32] = Service_Provider_guid;
        if (check[32] == "") {
            flag = 1;
            request.setAttribute("empty32", "*Please fill this entry");
        }
        String Resourse_Type_Code = request.getParameter("Resourse_Type_Code");
        check[33] = Resourse_Type_Code;
        if (check[33] == "") {
            flag = 1;
            request.setAttribute("empty33", "*Please fill this entry");
        }
        String Resourse_Name_DefaultValue = request.getParameter("Resourse_Name_DefaultValue");
        check[34] = Resourse_Name_DefaultValue;
        if (check[34] == "") {
            flag = 1;
            request.setAttribute("empty34", "*Please fill this entry");
        }
        String Resourse_Name_DefaultKey = request.getParameter("Resourse_Name_DefaultKey");
        check[35] = Resourse_Name_DefaultKey;
        if (check[35] == "") {
            flag = 1;
            request.setAttribute("empty35", "*Please fill this entry");
        }
        String Resourse_Description_DefaultValue = request.getParameter("Resourse_Description_DefaultValue");
        check[36] = Resourse_Description_DefaultValue;
        if (check[36] == "") {
            flag = 1;
            request.setAttribute("empty36", "*Please fill this entry");
        }
        String Resourse_Description_DefaultKey = request.getParameter("Resourse_Description_DefaultKey");
        check[37] = Resourse_Description_DefaultKey;
        if (check[37] == "") {
            flag = 1;
            request.setAttribute("empty37", "*Please fill this entry");
        }
        String Number_of_Required_Custom_Parameters = request.getParameter("Number_of_Required_Custom_Parameters");
        check[38] = Number_of_Required_Custom_Parameters;
        if (check[38] == "") {
            flag = 1;
            request.setAttribute("empty38", "*Please fill this entry");
        }
        String Number_of_Optional_Custom_Parameters = request.getParameter("Number_of_Optional_Custom_Parameters");
        check[39] = Number_of_Optional_Custom_Parameters;
        if (check[39] == "") {
            flag = 1;
            request.setAttribute("empty39", "*Please fill this entry");
        }

        request.setAttribute("Product_Default_Value", Product_Default_Value);
        request.setAttribute("Product_Key", Product_Key);
        request.setAttribute("Product_Description_Defaultvalue", Product_Description_Defaultvalue);
        request.setAttribute("Tool_Description_Key", Tool_Description_Key);
        request.setAttribute("Product_Version", Product_Version);
        request.setAttribute("Technical_Description_Defaultvalue", Technical_Description_Defaultvalue);

        request.setAttribute("Tool_Technical_Description_Key", Tool_Technical_Description_Key);
        request.setAttribute("Vendor_Name_Defaultvalue", Vendor_Name_Defaultvalue);
        request.setAttribute("Vendor_Name_Key", Vendor_Name_Key);
        request.setAttribute("Vendor_Description_Defaultvalue", Vendor_Description_Defaultvalue);
        request.setAttribute("Vendor_Description_Key", Vendor_Description_Key);
        request.setAttribute("Website", Website);
        request.setAttribute("Contact", Contact);
        request.setAttribute("Support_Team", Support_Team);
        request.setAttribute("Service_Provider_Name_Defaultvalue", Service_Provider_Name_Defaultvalue);
        request.setAttribute("Service_Provider_Name_Key", Service_Provider_Name_Key);
        request.setAttribute("Service_Provider_Description_Defaultvalue", Service_Provider_Description_Defaultvalue);
        request.setAttribute("Service_Provider_Description_Key", Service_Provider_Description_Key);
        request.setAttribute("Service_Provider_Support", Service_Provider_Support);
        request.setAttribute("Service_Owner_Name_Defaultvalue", Service_Owner_Name_Defaultvalue);
        request.setAttribute("Service_Owner_Name_Key", Service_Owner_Name_Key);
        request.setAttribute("Service_Owner_Description_Defaultvalue", Service_Owner_Description_Defaultvalue);
        request.setAttribute("Service_Owner_Description_Key", Service_Owner_Description_Key);
        request.setAttribute("Service_Owner_guid", Service_Owner_guid);
        request.setAttribute("Resourse_Type_Code", Resourse_Type_Code);
        request.setAttribute("Resourse_Name_DefaultValue", Resourse_Name_DefaultValue);
        request.setAttribute("Resourse_Name_DefaultKey", Resourse_Name_DefaultKey);
        request.setAttribute("Resourse_Description_DefaultValue", Resourse_Description_DefaultValue);
        request.setAttribute("Resourse_Description_DefaultKey", Resourse_Description_DefaultKey);
        request.setAttribute("Number_of_Required_Custom_Parameters", Number_of_Required_Custom_Parameters);
        request.setAttribute("Number_of_Optional_Custom_Parameters", Number_of_Optional_Custom_Parameters);
        request.setAttribute("Product_id", Product_id);
        request.setAttribute("Product_Code", Product_Code);
        request.setAttribute("Service_Provider_guid", Service_Provider_guid);
        request.setAttribute("Vendor_Code", Vendor_Code);
        request.setAttribute("Tool_Url", Tool_Url);

        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([ \\w]+\\.)+[\\w]+[\\w]$";
        Boolean b1 = Contact.matches(EMAIL_REGEX);
        Boolean b2 = Support_Team.matches(EMAIL_REGEX);
        Boolean b3 = Service_Provider_Support.matches(EMAIL_REGEX);
        if (b1 == false) {
            flag = 1;
            System.out.println("1");
            request.setAttribute("Contact", "");
            request.setAttribute("empty14", "*Invalid Email");;
        }
        if (b2 == false) {
            flag = 1;
            System.out.println("1");
            request.setAttribute("Support_Team", "");
            request.setAttribute("empty15", "*Invalid Email");
        }
        if (b3 == false) {
            flag = 1;
            request.setAttribute("Service_Provider_Support", "");
            request.setAttribute("empty20", "*Invalid Email");
        }

        String[] schemes = {"http", "https",}; // DEFAULT schemes = "http", "https", "ftp"
        UrlValidator urlValidator = new UrlValidator(schemes);
        Boolean u1 = urlValidator.isValid(Tool_Url);
        Boolean u2 = urlValidator.isValid(Website);
        
        if (u1 == false) {
            request.setAttribute("Tool_Url", "");
            request.setAttribute("empty28", "*Invalid Url");
        }
        if (u2 == false) {
            request.setAttribute("Website", "");
            request.setAttribute("empty13", "*Invalid Url");
        }
        boolean isInteger = isInteger(Number_of_Required_Custom_Parameters);
        if (!isInteger) {
            flag = 1;
            request.setAttribute("Number_of_Required_Custom_Parameters", "");
            request.setAttribute("empty38", "*Invalid Entry (String not allowed)");
        } else {
            int var1 = Integer.parseInt(Number_of_Required_Custom_Parameters);
            if (var1 < 0) {
                flag = 1;
                request.setAttribute("Number_of_Required_Custom_Parameters", "");
                request.setAttribute("empty38", "*Invalid Entry (Negative Number)");
            }
        }
        isInteger = isInteger(Number_of_Optional_Custom_Parameters);
        if (!isInteger) {
            flag = 1;
            request.setAttribute("Number_of_Optional_Custom_Parameters", "");
            request.setAttribute("empty39", "*Invalid Entry (String not allowed)");
        } else {
            int var2 = Integer.parseInt(Number_of_Optional_Custom_Parameters);

            if (var2 < 0) {
                flag = 1;
                request.setAttribute("Number_of_Optional_Custom_Parameters", "");
                request.setAttribute("empty39", "*Invalid Entry (Negative Number)");
            }
        }

        if (flag == 1) {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("ToolPageError.jsp");
            dispatcher.forward(request, response);
        }

        out.print("<html lang=\"en\">\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\" />\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n"
                + "        <title>Tool Profile</title>\n"
                + "\n"
                + "        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />\n"
                + "        <meta name=\"viewport\" content=\"width=device-width\" />\n"
                + "\n"
                + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" />\n"
                + "        <link href=\"css/gsdk-base.css\" rel=\"stylesheet\" />  \n"
                + "\n"
                + "        <link href=\"http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css\" rel=\"stylesheet\">\n"
                + "\n"
                + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                + "        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n"
                + "        \n"
                + "\n"
                + "        <script>\n"
                + "            $(document).ready(function () {\n"
                + "                $('[data-toggle=\"tooltip\"]').tooltip();\n"
                + "            });\n"
                + "        </script>\n"
                + "\n"
                + "\n"
                + "    </head>\n"
                + "\n"
                + "    <body>\n"
                + "        <div>\n"
                + "            <!--   Creative Tim Branding   -->\n"
                + "\n"
                + "\n"
                + "            <!--   Big container   -->\n"
                + "            <div class=\"container\">\n"
                + "                <div class=\"row\">\n"
                + "                    <div >\n"
                + "\n"
                + "                        <!--      Wizard container        -->   \n"
                + "                        <div> \n"
                + "                          \n"
                + "                                <div class=\"card wizard-card ct-wizard-azzure\" id=\"wizard\">\n"
                + "\n"
                + "                                    <!--        You can switch \"ct-wizard-orange\"  with one of the next bright colors: \"ct-wizard-blue\", \"ct-wizard-green\", \"ct-wizard-orange\", \"ct-wizard-red\"             -->\n"
                + "\n"
                + "                                    <div class=\"wizard-header\">\n"
                + "                                        <h3>\n"
                + "                                            <b>Tool</b> Profile Registration <br>\n"
                + "                                            <small>Please let us know about your tool.</small>\n"
                + "                                        </h3>\n"
                + "                                    </div>\n"
                + "                                    <ul>\n"
                + "                                        <li ><a href=\"#about\" data-toggle=\"tab\">Step 1</a></li>\n"
                + "                                        <li class=\"active\"><a  href=\"#account\" data-toggle=\"tab\">Step 2</a></li>\n"
                + "                                        <li ><a href=\"#address\" data-toggle=\"tab\">Step 3</a></li>\n"
                + "                                    </ul>\n"
                + "                                    <div class=\"tab-content\">\n"
                + "                                        <div >\n"
                + "                                            <div class=\"row\">\n"
                + "                                                <div class=\"container\">\n"
                + "                                                    <div class=\"row\">\n"
                + "                                                        <form role=\"form\" action=\"SubmitCapabilityDetails\" method=\"POST\">\n"
                + "                                                            <div class=\"col-lg-6\">\n"
                + "                                                                <div class=\"well well-sm\"><strong><span class=\"glyphicon glyphicon-asterisk\" style=\"color: red\"></span>Required Field</strong></div>\n"
                + "                                                                <div class=\"form-group\">");

           //fetching the values of variable from the tool registration form
       
        
        JSONObject toolProfile = null;
        try {
            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
            toolProfile = new JSONObject()
                    .put("lti_version", "LTI-2p0")
                    .put("product_instance", new JSONObject()
                            .put("product_info", new JSONObject()
                                    .put("product_name", new JSONObject().put("default_value", Product_Default_Value)
                                            .put("key", Product_Key))
                                    .put("product_version", Product_Version)
                                    .put("description", new JSONObject().put("default_value", Product_Description_Defaultvalue)
                                            .put("key", Tool_Description_Key))
                                    .put("technical_description", new JSONObject().put("default_value", Technical_Description_Defaultvalue)
                                            .put("key", Tool_Technical_Description_Key))
                                    .put("product_family", new JSONObject()
                                            .put("@id", Product_id)
                                            .put("code", Product_Code)
                                            .put("vendor", new JSONObject()
                                                    .put("code", Vendor_Code)
                                                    .put("vendor_name", new JSONObject().put("default_value", Vendor_Name_Defaultvalue)
                                                            .put("key", Vendor_Name_Key))
                                                    .put("description", new JSONObject().put("default_value", Vendor_Description_Defaultvalue)
                                                            .put("key", Vendor_Description_Key))
                                                    .put("website", Website)
                                                    .put("timestamp", currentTimestamp)
                                                    .put("contact", new JSONObject().put("email", Contact)))))
                            .put("support", new JSONObject().put("email", Support_Team))
                            .put("service_provider", new JSONObject()
                                    .put("guid", Service_Provider_guid)
                                    .put("timestamp", currentTimestamp)
                                    .put("service_provider_name", new JSONObject().put("default_value", Service_Provider_Name_Defaultvalue)
                                            .put("key", Service_Provider_Name_Key)))
                            .put("description", new JSONObject().put("default_value", Service_Provider_Description_Defaultvalue)
                                    .put("key", Service_Provider_Description_Key))
                            .put("service_owner", new JSONObject()
                                    .put("guid", Service_Owner_guid)
                                    .put("timestamp", currentTimestamp)
                                    .put("description", new JSONObject().put("default_value", Service_Owner_Description_Defaultvalue)
                                            .put("key", Service_Owner_Description_Key))
                                    .put("service_owner_name", new JSONObject().put("default_value", Service_Owner_Name_Defaultvalue)
                                            .put("key", Service_Owner_Name_Key))))
                    .put("base_url_choice", new JSONArray()
                            .put(new JSONObject()
                                    .put("selector", "DefaultSelector")
                                    .put("default_base_url", "http://")
                                    .put("secure_base_url", "https://")))
                    .put("Capability_Wanted", Capability_Wanted)
                    .put("Services_Wanted", Services_Wanted)
                    .put("message_type", new JSONObject().put("path", lti_path)
                            .put("message_type", lti_message_type))
                    .put("resource_type", new JSONObject().put("code", Resourse_Type_Code))
                    .put("resource_name", new JSONObject().put("default_value", Resourse_Name_DefaultValue)
                            .put("key", Resourse_Name_DefaultKey))
                    .put("description", new JSONObject().put("default_value", Resourse_Description_DefaultValue)
                            .put("key", Resourse_Description_DefaultKey))
                    .put("Tool_Url", Tool_Url);
        } catch (Exception e) {

        }
        
        
        
        ToolDetailsProcess db = new ToolDetailsProcess();
        int id = -1;
        try {
            id = db.insert(toolProfile.toString());
        } catch (JSONException ex) {
            Logger.getLogger(SubmitToolProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url12[] = new String[2];
       
        url12[0] = Constants.BASE_URL + "/lti/register/" + id;
        url12[1] = Constants.BASE_URL + "/lti/launch/" + id;
        
        ToolDetailsProcess registration = new ToolDetailsProcess();
        registration.insertRegisteredUrl(url12[0], id);
        registration.insertLaunchUrl(url12[1], id);
        
        ToolCapabilityEnabledProcess capability = new ToolCapabilityEnabledProcess();
        capability.insert(Capability_Wanted, id);
        

        JSONArray jsonCapability = new JSONArray();

        for (int i = 0; i < Capability_Wanted.length; i++) {
            jsonCapability.put(Capability_Wanted[i]);
        }

        JSONArray jsonUrl = new JSONArray();

        for (int i = 0; i < url12.length; i++) {
            jsonUrl.put(url12[i]);
        }

        for (int i = 0; i < jsonCapability.length(); i++) {
            try {
                out.print("<div class=\"container\">\n"
                        + "                                    <h2>" + jsonCapability.getString(i) + "</h2>\n"
                        + "                                    <div class=\"panel panel-default\">\n"
                        + "                                        <div class=\"panel-body\">\n"
                        + "                                            <div class=\"form-group\" style=\"margin-left: 30pt;\";\">\n"
                        + "                                                <label for=\"InputName\" data-toggle=\"tooltip\" data-placement=\"right\"  title=\"Enter variable name. This variable name will be used by LMS to send parameters. eg., membership_role\"><b>Name  </b><img src=\"Design/images/QuestionMark.jpg\"></label>\n"
                        + "                                                <div class=\"input-group\">\n"
                        + "                                                    <input type=\"text\" class=\"form-control\" name=\"" + jsonCapability.getString(i) + "/Name\" id=\"InputName\" placeholder=\"\" required>\n"
                        + "                                                    <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\" style=\"color: red\"></span></span>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"form-group\" style=\"margin-left: 30pt;\";\">\n"
                        + "                                                <label for=\"InputName\"><b>Variable  </b></label>\n"
                        + "                                                <div class=\"input-group\">\n"
                        + "                                                    <input type=\"text\" class=\"form-control\" name=\"" + jsonCapability.getString(i) + "/Variable\" value=\"" + jsonCapability.getString(i) + "\" readonly =\"readonly\" id=\"InputName\" placeholder=\"\" required>\n"
                        + "                                                    <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\" style=\"color: red\"></span></span>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>");
            } catch (JSONException ex) {
                Logger.getLogger(SubmitToolProfile.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        int custom_required_parameters = Integer.parseInt(Number_of_Required_Custom_Parameters);
        if (custom_required_parameters > 0) {
            out.print("<div class=\"container\">\n"
                    + "                                                                        <h3 ><b>Custom Required Parameters  </b></h3>\n"
                    + "                                                                        <div class=\"panel panel-default\">\n"
                    + "                                                                            <div class=\"panel-body\">");
            System.out.println("custom : " + custom_required_parameters);
            for (int i = 1; i <= custom_required_parameters; i++) {
                out.print("<div class=\"form-group\" style=\"margin-left: 30pt;\";\">\n"
                        + "                                                                                    <label for=\"InputName\" data-toggle=\"tooltip\" data-placement=\"top\"  title=\"These custom parameters are required and will always submitted by tool consumer. Custom parameters are always fetched by using 'custom_' keyword before parameter name.\"><b>Parameter " + i + "  </b><img src=\"Design/images/QuestionMark.jpg\"></label>\n"
                        + "                                                                                    <div class=\"input-group\">\n"
                        + "                                                                                        <input type=\"text\" class=\"form-control\" name=\"Required_Parameter" + i + "\" id=\"InputName\" placeholder=\"\" required>\n"
                        + "                                                                                        <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\" style=\"color: red\"></span></span>\n"
                        + "                                                                                    </div>\n"
                        + "                                                                                </div>");
            }

            out.print("</div>\n"
                    + "                                                                        </div>\n"
                    + "                                                                    </div>");
        }
        int custom_optional_parameters = Integer.parseInt(Number_of_Optional_Custom_Parameters);
        if (custom_optional_parameters > 0) {
            out.print("<div class=\"container\">\n"
                    + "                                                                        <h3 ><b>Custom Optional Parameters  </b></h3>\n"
                    + "                                                                        <div class=\"panel panel-default\">\n"
                    + "                                                                            <div class=\"panel-body\">");

            System.out.println("custom : " + custom_optional_parameters);
            for (int i = 1; i <= custom_optional_parameters; i++) {
                out.print("<div class=\"form-group\" style=\"margin-left: 30pt;\";\">\n"
                        + "                                                                                    <label for=\"InputName\" data-toggle=\"tooltip\" data-placement=\"right\"  title=\"These custom parameters are optional. Tool Consumer may or may not send this parameters. Custom parameters are always fetched by using 'custom_' keyword before parameter name.\"><b>Parameter " + i + "  </b><img src=\"Design/images/QuestionMark.jpg\"></label>\n"
                        + "                                                                                    <div class=\"input-group\">\n"
                        + "                                                                                        <input type=\"text\" class=\"form-control\" name=\"Optional_Parameter" + i + "\" id=\"InputName\" placeholder=\"\" required>\n"
                        + "                                                                                        <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-asterisk\" style=\"color: red\"></span></span>\n"
                        + "                                                                                    </div>\n"
                        + "                                                                                </div>");

            }
            out.print("</div>\n"
                    + "                                                                        </div>\n"
                    + "                                                                    </div>");

        }

        out.print("                                                    <input type=\"hidden\" class=\"form-control\" name=\"" + "registerUrl" + "\" value = \"" + url12[0] + "\" id=\"InputName\" placeholder=\"\" required>\n"
                + "                                                    <input type=\"hidden\" class=\"form-control\" name=\"" + "launchUrl" + "\" value = \"" + url12[1] + "\" id=\"InputName\" placeholder=\"\" required>\n"
                + "                                                    <input type=\"hidden\" class=\"form-control\" name=\"" + "size" + "\" value = \"" + Capability_Wanted.length + "\" id=\"InputName\" placeholder=\"\" required>\n"
                + "                                                    <input type=\"hidden\" class=\"form-control\" name=\"" + "required_parameters_size" + "\" value = \"" + custom_required_parameters + "\" id=\"InputName\" placeholder=\"\" required>\n"
                + "                                                    <input type=\"hidden\" class=\"form-control\" name=\"" + "optional_parameters_size" + "\" value = \"" + custom_optional_parameters + "\" id=\"InputName\" placeholder=\"\" required>\n"
        );
        out.print(" <input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Next\" class=\"btn btn-info pull-right\">\n"
                + "                                                                </div>\n"
                + "\n"
                + "                                                            </div>\n"
                + "                                                        </form>\n"
                + "\n"
                + "                                                    </div>\n"
                + "                                                    <!-- Registration form - END -->\n"
                + "\n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "                                        \n"
                + "                                </div>\n"
                + "                           \n"
                + "                        </div> <!-- wizard container -->\n"
                + "                    </div>\n"
                + "                </div><!-- end row -->\n"
                + "            </div> <!--  big container -->\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "        </div>\n"
                + "\n"
                + "    </body>\n"
                + "\n"
                + "    <script src=\"js/jquery-1.10.2.js\" type=\"text/javascript\"></script>\n"
                + "    <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n"
                + "\n"
                + "    <!--   plugins 	 -->\n"
                + "    <script src=\"js/jquery.bootstrap.wizard.js\" type=\"text/javascript\"></script>\n"
                + "    <script src=\"js/wizard.js\"></script>\n"
                + "\n"
                + "</html>");
    } else {
        response.sendRedirect("login.jsp");
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
