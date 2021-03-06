/**
 * LTIToolProxyRegistration servlet helps in registering the LTI Tool in any LTI
 * Tool Consumer.
 *
 * @author Sourav Kumar Paul
 * @version 1.0
 *
 */
package org.utp.lti2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.googlecode.objectify.Objectify;
import org.utp.database.BltiKeys;
import org.utp.databaseprocess.BltiKeysProcess;
import org.utp.databaseprocess.ToolDetailsProcess;
import java.util.Calendar;
import java.util.Enumeration;
import org.utp.databaseprocess.ToolCapabilityEnabledProcess;

public class LTIToolProxyRegistration extends HttpServlet {

    DAO dao = new DAO();
    Objectify ofy = dao.ofy();
    Map<String, String> sharedSecrets = new HashMap<String, String>();
    private static final long serialVersionUID = 137L;
    // the following string constants are associated with the ChemVantage Tool Profile and other
    // constants needed to construct a valid Tool Proxy

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override

    /**
     * This method receives post request from LTI Tool Consumer. Shows success
     * upon successful tool proxy registration otherwise shows failure message.
     *
     * @param request
     * @param response
     * 
     * Parameters used are:
     * lti_message_type This parameter contains message type.
     * reg_key This parameter contains unique key. Used for first time
     * registration only.
     * reg_password This parameter contains secret mapped to reg_key.
     * tc_profile_url This parameter contains URL of tool consumer.
     * Method retrieves the Tool Consumer Profile by issuing an HTTP GET request
     * to the URL.
     * launch_presentation_return_url This parameter contains URL of Tool
     * Consumer. After completion of process user is redirected to this URL.
     * toolConsumerProfile This JSONObject contains detail of tool
     * consumer.
     * capability_enabled This String List contains all the capabilities
     * that are enabled by tool provider.
     * tcp This JSONObject contains all the capabilities that are offered
     * by tool consumer.
     * toolProxy This JSONObject contains Product Profiles and security
     * contract that are sent by tool provider to establish LTI integration
     * contract with tool consumer.
     * reply This parameter contains response message sent by the tool
     * consumer upon submitting Tool Proxy to the Tool Proxy REST service via an
     * HTTP request.
     * tool_proxy_guid This is a globally unique identifier for the Tool
     * Proxy.
     * @return Nothing
     * @exception java.io.IOException upon receiving bad request, bad
     * parameters, missing tool_proxy_guid
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + ""
                + "<style>\n"
                + "#box1 {\n"
                + "    background-color: lightgrey;\n"
                + "    width: 100%;\n"
                + "    padding: 5px;\n"
                + "    border: 1px solid black;\n"
                + "    margin: 1px;\n"
                + "}\n"
                + "#box2 {\n"
                + "    background-color: lightgrey;\n"
                + "    width: 100%;\n"
                + "    padding: 5px;\n"
                + "    border: 1px solid black;\n"
                + "    margin: 1px;\n"
                + "}\n"
                + "#box3 {\n"
                + "    background-color: lightgrey;\n"
                + "    width: 100%;\n"
                + "    padding: 5px;\n"
                + "    border: 1px solid black;\n"
                + "    margin: 1px;\n"
                + "}\n"
                + "#box4 {\n"
                + "    background-color: lightgrey;\n"
                + "    width: 100%;\n"
                + "    padding: 5px;\n"
                + "    border: 1px solid black;\n"
                + "    margin: 1px;\n"
                + "}\n"
                + "#box5 {\n"
                + "    background-color: lightgrey;\n"
                + "    width: 100%;\n"
                + "    padding: 5px;\n"
                + "    border: 1px solid black;\n"
                + "    margin: 1px;\n"
                + "}\n"
                + "#box6 {\n"
                + "    background-color: lightgrey;\n"
                + "    width: 100%;\n"
                + "    padding: 5px;\n"
                + "    border: 1px solid black;\n"
                + "    margin: 1px;\n"
                + "}\n"
                + "</style>\n"
                + "<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n"
                + "<script>\n"
                + "$(document).ready(function(){\n"
                + "    $(\"#b1\").click(function(){\n"
                + "        $(\"#box1\").toggle();\n"
                + "    });\n"
                + "});\n"
                + "$(document).ready(function(){\n"
                + "    $(\"#b2\").click(function(){\n"
                + "        $(\"#box2\").toggle();\n"
                + "    });\n"
                + "});\n"
                + "$(document).ready(function(){\n"
                + "    $(\"#b3\").click(function(){\n"
                + "        $(\"#box3\").toggle();\n"
                + "    });\n"
                + "});\n"
                + "$(document).ready(function(){\n"
                + "    $(\"#b4\").click(function(){\n"
                + "        $(\"#box4\").toggle();\n"
                + "    });\n"
                + "});\n"
                + "$(document).ready(function(){\n"
                + "    $(\"#b5\").click(function(){\n"
                + "        $(\"#box5\").toggle();\n"
                + "    });\n"
                + "});\n"
                + "$(document).ready(function(){\n"
                + "    $(\"#b6\").click(function(){\n"
                + "        $(\"#box6\").toggle();\n"
                + "    });\n"
                + "});\n"
                + "</script>"
                + "</head>\n"
                + "<body>");

        // Extracting the Request URI and check for "register" keyword
        String uri = request.getRequestURI();
        String[] parts = uri.split("/");
        String toolId = parts[parts.length - 1];
        String controller = parts[parts.length - 2];
        if ("register".equals(controller)) {

            /**
             * Get all the parameters of request given by tool consumer to tool
             * provider
             */
            StringBuffer debug = new StringBuffer("Debug:\n");
            String lti_message_type = request.getParameter("lti_message_type");
            String reg_key = request.getParameter("reg_key");
            String reg_password = request.getParameter("reg_password");
            String tc_profile_url = request.getParameter("tc_profile_url");
            String launch_presentation_return_url = request.getParameter("launch_presentation_return_url");

            out.print("<div>\n"
                    + "  <h2><center>LTI Tool Proxy Registration Request</center></h2>\n"
                    + "<h4>Raw POST Parameters  <button id = b1>Toggle</button></h4> "
                    + "  "
                    + "<div id = box1 >"
                    + "lti_message_type : " + lti_message_type
                    + "<br>reg_key : " + reg_key
                    + "<br>reg_password : " + reg_password
                    + "<br>tc_profile_url : " + tc_profile_url
                    + "<br>launch_presentation_return_url : " + launch_presentation_return_url
                    + "</div></div>\n"
            );

            /**
             * Error Handling of all the parameters received
             */
            try {
                if ("basic-lti-launch-request".equals(lti_message_type)) {
                    throw new Exception("The correct LTI Launch URL is https://" + request.getServerName() + "/lti/");
                }
                if (!"ToolProxyRegistrationRequest".equals(lti_message_type)) {
                    throw new Exception("Invalid message type");
                }
                if (reg_key == null || reg_key.isEmpty()) {
                    throw new Exception("Required reg_key parameter is missing.");
                }
                if (reg_password == null || reg_password.isEmpty()) {
                    throw new Exception("Required reg_password parameter is missing.");
                }
                if (tc_profile_url == null || tc_profile_url.isEmpty()) {
                    throw new Exception("Required tc_profile_url parameter is missing.");
                }
                if (launch_presentation_return_url == null || launch_presentation_return_url.isEmpty()) {
                    throw new Exception("Required launch_presentation_return_url parameter is missing.");
                }

                out.print("\n<p>Retrieving tool consumer profile from " + tc_profile_url);

                // Fetching tool consumer profile by issuing an url connection to tc_profile_url
                JSONObject toolConsumerProfile = fetchToolConsumerProfile(tc_profile_url);

                out.print("<br>Retrieved " + toolConsumerProfile.toString().length() + " characters.</p>");

                out.print("<div>\n"
                        + "<h4>Retrieve Tool Consumer <button id =b2>Toggle</button></h4> "
                        + "  "
                        + "<div id = box2 >"
                        + "<pre id=\"json1\"></pre>\n"
                        + "\n"
                        + "<script>\n"
                        + "var data = " + toolConsumerProfile.toString() + "\n"
                        + "\n"
                        + "\n"
                        + "document.getElementById(\"json1\").innerHTML = JSON.stringify(data, undefined, 2);\n"
                        + "</script> "
                        + "</div></div>\n");

                // Capabilities that are enabled by by mutual understanding of both parties
                List<String> capability_enabled = getCapabilities(toolId, toolConsumerProfile);

                JSONArray svc = toolConsumerProfile.getJSONArray("service_offered");
                out.print("<br>Found " + svc.length() + " services.");

                for (int i = 0; i < svc.length(); i++) {
                    JSONObject svJson = svc.getJSONObject(i);
                    out.print("<br>Service id : " + svJson.getString("@id"));
                }

                JSONArray tcp = toolConsumerProfile.getJSONArray("capability_offered");
                out.print("<br><br>Found " + tcp.length() + " capabilities.");

                // One secret is being generated and assigned to oauth_secret
                String oauth_secret = BLTIConsumer.generateSecret();

                // Get Base Url
                StringBuffer base_url = request.getRequestURL();

                base_url.delete(base_url.indexOf("lti"), base_url.length()).delete(0, base_url.indexOf("://") + 3);
               // Launch url contains /lti/launch

                // Construct Tool Proxy 
                JSONObject toolProxy = constructToolProxy(toolId, toolConsumerProfile, tc_profile_url, base_url, oauth_secret, capability_enabled, reg_key);

                debug.append("tool_proxy_formed_ok.");

                out.print("<div>\n"
                        + "<h4>Registration Request <button id =b3>Toggle</button></h4> "
                        + "  "
                        + "<div id = box3 >"
                        + "<pre id=\"json2\"></pre>\n"
                        + "\n"
                        + "<script>\n"
                        + "var data = " + toolProxy.toString() + "\n"
                        + "\n"
                        + "\n"
                        + "document.getElementById(\"json2\").innerHTML = JSON.stringify(data, undefined, 2);\n"
                        + "</script> "
                        + "</div></div>\n");

                /*
                  Tool Provider issues a POST request to the specified endpoint, 
                 using the reg_password value as the oauth_consumer_secret 
                 when signing the request. 
                 */
                out.print("<div>\n"
                        + "<h4>Registration Request Headers  <button id = b4>Toggle</button></h4> "
                        + "  "
                        + "<div id = box4 >"
                        + "POST"
                        + "<br>Register Endpoint : " + getTCServiceEndpoint("application/vnd.ims.lti.v2.toolproxy+json", toolConsumerProfile)
                        + "<br>Content Type : application/vnd.ims.lti.v2.toolproxy+json"
                        + "</div></div>\n");

                String reply = new LTIMessage("application/vnd.ims.lti.v2.toolproxy+json", toolProxy.toString(), getTCServiceEndpoint("application/vnd.ims.lti.v2.toolproxy+json", toolConsumerProfile), reg_key, reg_password).send();

                debug.append("tc_response_received.");

                Enumeration<String> en = request.getHeaderNames();

                out.print("<div>\n"
                        + "<h4>Registration Response Headers  <button id = b5>Toggle</button></h4> ");
                out.print("<div id = box5 >");
                while (en.hasMoreElements()) {
                    String param = en.nextElement();
                    out.print("<br>" + param + " : " + request.getHeader(param));
                }

                out.print("</div></div>\n");

                out.print("<div>\n"
                        + "<h4>Registration Response <button id =b6>Toggle</button></h4> "
                        + "  "
                        + "<div id = box6 >"
                        + "<pre id=\"json3\"></pre>\n"
                        + "\n"
                        + "<script>\n"
                        + "var data = " + reply + "\n"
                        + "\n"
                        + "\n"
                        + "document.getElementById(\"json3\").innerHTML = JSON.stringify(data, undefined, 2);\n"
                        + "</script> "
                        + "</div></div>\n");
                String tool_proxy_guid = null;
                String tool_proxy_url = null;
                String tool_settings_url = null;

                /*
                 Upon sending POST request, response contains tool_proxy_guid a unique code that is used for further
                 communication between both parties.
                 */
                try {
                    JSONObject replyBody = new JSONObject(reply);
                    debug.append("json_reply_ok.");
                    tool_proxy_guid = replyBody.getString("tool_proxy_guid");
                    tool_proxy_url = replyBody.getString("@id");
                    try {
                        tool_settings_url = replyBody.getString("custom_uri");
                    } catch (Exception e) {

                    }
                    if (tool_proxy_guid.isEmpty() || tool_proxy_url.isEmpty()) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    throw new Exception("Could not parse response to tool proxy registration request.");
                }

                BltiKeys blti = new BltiKeys();
                blti.setOauthConsumerKey(tool_proxy_guid);
                blti.setSecret(oauth_secret);
                BltiKeysProcess keysProcess = new BltiKeysProcess();
                keysProcess.insert(blti);

                debug.append("LTI_credentials_formed_ok.");
                // all steps completed successfully with no exceptions thrown, so report success back to TC administrator
                out.print("<br><p>Status = success<br>Tool Registered Successfully : <a href=" + launch_presentation_return_url + ">Return to Moodle</a></p>");
            } catch (Exception e) {
                e.printStackTrace();
                out.print("<br><p>Sorry, the Tool Proxy Registration failed.<br>" + e.getMessage() + "<br>" + debug.toString() + "<br><a href=" + launch_presentation_return_url + ">Return to Moodle</a></p>");

            }
            out.print("</body></html>");
        }
    }

    /**
     * This method is used to show error to lti consumer. Upon getting any
     * exception system is redirected to tool consumer's return url and a
     * message is appended to it.
     *
     * @param request
     * @param response
     * @param s It contains message that is been appended to return url upon
     * getting any exception.
     * @param message
     * @param e
     * @throws java.io.IOException
     * @return Nothing
     */
    public void doError(HttpServletRequest request, HttpServletResponse response, String s, String message, Exception e)
            throws java.io.IOException {
        try {
            String return_url = request.getParameter("launch_presentation_return_url");

            return_url += (return_url.indexOf('?') > 1 ? "&lti_msg=" : "?lti_msg=") + URLEncoder.encode(s, "UTF-8");

            return;
        } catch (Exception e2) {
            // in case no return URL was provided, show the error to the user
            PrintWriter out = response.getWriter();

        }
    }

    /**
     *
     * @param tc_profile_url This parameter contains tool consumer profile url.
     * This url contains all the details of tool consumer.
     * @return It returns JSONObject of tool consumer's profile.
     * @throws Exception
     */
    JSONObject fetchToolConsumerProfile(String tc_profile_url) throws Exception {
        JSONObject tc_profile = null;
        URL u = new URL(tc_profile_url);
        HttpURLConnection connection = (HttpURLConnection) u.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(u.openStream()));
            StringBuffer res = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
            }
            reader.close();
            tc_profile = new JSONObject(res.toString());
        }
        return tc_profile;
    }

    /**
     * This method selects capabilities upon mutual understanding of two
     * parties. Tool Consumer offers some capabilities and tool provider selects
     * some or all capabilities from offered list.
     *
     * @param toolId Registration Id of tool in universal tool provider.
     * @param toolConsumerProfile This parameter contains JSONObject of tool
     * consumer's profile.
     * @return
     * @throws JSONException
     */
    List<String> getCapabilities(String toolId, JSONObject toolConsumerProfile) throws JSONException {
        // list of capabilities offered by the Tool Consumer
        ToolDetailsProcess capability = new ToolDetailsProcess();
        String json = capability.getToolDetail(Integer.parseInt(toolId));
        JSONObject json_tool = new JSONObject(json);

        JSONArray capabilities_wanted = (JSONArray) json_tool.get("Capability_Wanted");

        List<String> capability_offered = new ArrayList<String>();
        List<String> capability_enabled = new ArrayList<String>();
        JSONArray tcp = toolConsumerProfile.getJSONArray("capability_offered");
        for (int i = 0; i < tcp.length(); i++) {
            capability_offered.add(tcp.getString(i));
        }

        for (int i = 0; i < capabilities_wanted.length(); i++) {
            String s = (String) capabilities_wanted.get(i);
            if (capability_offered.contains(s)) {
                capability_enabled.add(s);
            }
        }

        return capability_enabled;
    }

    /**
     *
     * @param toolId Registration Id of tool in universal tool provider.
     * @param toolConsumerProfile This parameter contains JSONObject of tool
     * consumer's profile.
     * @param tc_profile_url This parameter contains tool consumer profile
     * url.This url contains all the details of tool consumer.
     * @param base_url
     * @param shared_secret This parameter contains secret that is used for
     * authentication purpose.
     * @param capability_enabled This parameter contains enabled capability.
     * @param oauth_consumer_key This parameter contains unique key.
     * @return
     * @throws Exception
     */
    JSONObject constructToolProxy(String toolId, JSONObject toolConsumerProfile, String tc_profile_url, StringBuffer base_url, String shared_secret, List<String> capability_enabled, String oauth_consumer_key)
            throws Exception {
        JSONObject toolProxy = new JSONObject();
        toolProxy.put("@context", "http://purl.imsglobal.org/ctx/lti/v2/ToolProxy");
        toolProxy.put("@type", "ToolProxy");
        toolProxy.put("@id", "");
        toolProxy.put("lti_version", toolConsumerProfile.getString("lti_version"));
        toolProxy.put("tool_proxy_guid", oauth_consumer_key);
        toolProxy.put("tool_consumer_profile", tc_profile_url);
        toolProxy.put("tool_profile", getToolProfile(toolId, base_url, capability_enabled));
        toolProxy.put("security_contract", getSecurityContract(toolConsumerProfile, shared_secret, capability_enabled));
        return toolProxy;
    }

    /**
     * This method prepares tool profile.
     *
     * @param toolId Registration Id of tool in universal tool provider.
     * @param base_url
     * @param capability_enabled This parameter contains enabled capability.
     * @return
     * @throws Exception
     */
    JSONObject getToolProfile(String toolId, StringBuffer base_url, List<String> capability_enabled) throws Exception {  // this is the (mostly static) tool profile for ChemVantage

        Calendar calendar = Calendar.getInstance();

        /*  get a java.util.Date from the calendar instance.
         *  this date will represent the current instant, or "now".
         * 
         */
        java.util.Date now = calendar.getTime();

        //  a java current time (now) instance
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        ToolDetailsProcess capability = new ToolDetailsProcess();
        String json = capability.getToolDetail(Integer.parseInt(toolId));
        JSONObject json_tool = new JSONObject(json);

        JSONObject toolProfile = new JSONObject()
                .put("lti_version", json_tool.get("lti_version").toString())
                .put("product_instance", json_tool.get("product_instance"))
                .put("base_url_choice", new JSONArray()
                        .put(new JSONObject()
                                .put("selector", "DefaultSelector")
                                .put("default_base_url", "http://" + base_url.toString())
                                .put("secure_base_url", "https://" + base_url.toString())));

        // the following are parameters that are available only at the option of the Tool Consumer (LMS)
        JSONArray parameter = new JSONArray();

        ToolCapabilityEnabledProcess capabilityWanted = new ToolCapabilityEnabledProcess();
        ArrayList<String> capabilities = capabilityWanted.getCapability(Integer.parseInt(toolId));
        ArrayList<String> name = capabilityWanted.getName(Integer.parseInt(toolId));
        ArrayList<String> variable = capabilityWanted.getVariable(Integer.parseInt(toolId));

        for (int i = 0; i < capabilities.size(); i++) {
            if (capability_enabled.contains(capabilities.get(i))) {
                parameter.put(new JSONObject("{ \"name\":\"" + name.get(i) + "\",\n"
                        + "                \"variable\":\"" + variable.get(i) + "\"}"));
            }
        }

        // construct a generic message object for every basic-lti-launch-request 
        JSONObject msg = new JSONObject();
        msg.put("path", "lti/launch/" + toolId);
        msg.put("message_type", "basic-lti-launch-request");
        JSONArray enabled_capability = new JSONArray();
        for (String cap : capability_enabled) {
            enabled_capability.put(cap);
        }

        msg.put("enabled_capability", enabled_capability);
        JSONArray resource_handler = new JSONArray();
        resource_handler.put(new JSONObject().put("resource_type", json_tool.get("resource_type"))
                .put("description", json_tool.get("description"))
                .put("resource_name", json_tool.get("resource_name"))
                .put("message", new JSONArray()
                        .put(msg
                                .put("parameter", parameter
                                        .put(new JSONObject("{'name':'show'}"))))));

        toolProfile.put("resource_handler", resource_handler);
        return toolProfile;
    }

    /**
     * This method constructs a Security contract that is being send along with
     * tool proxy
     *
     * @param toolConsumerProfile
     * @param shared_secret
     * @param capabilities
     * @return
     * @throws Exception
     */
    JSONObject getSecurityContract(JSONObject toolConsumerProfile, String shared_secret, List<String> capabilities) throws Exception {
        JSONObject security_contract = new JSONObject();
        security_contract.put("shared_secret", shared_secret);

        JSONArray tool = new JSONArray();

        security_contract.put("tool_service", tool);

        return security_contract;

    }

    /**
     * This method returns service Endpoint corresponding to format of
     * particular service.
     *
     * @param formatString
     * @param toolConsumerProfile
     * @return
     * @throws Exception
     */
    String getTCServiceEndpoint(String formatString, JSONObject toolConsumerProfile) throws Exception {
        JSONArray service_offered = toolConsumerProfile.getJSONArray("service_offered");
        for (int i = 0; i < service_offered.length(); i++) {
            try {
                JSONObject s = service_offered.getJSONObject(i);
                if (s.has("format")) {
                    JSONArray formats = s.getJSONArray("format");
                    for (int j = 0; j < formats.length(); j++) {
                        if (formats.getString(j).toLowerCase().equals(formatString)) {
                            return s.getString("endpoint");
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
    /**
     * This method returns service Id corresponding to format of
     * particular service.
     * @param formatString
     * @param toolConsumerProfile
     * @return
     * @throws JSONException 
     */
    private String getTCServiceId(String formatString, JSONObject toolConsumerProfile) throws JSONException {
        JSONArray service_offered = toolConsumerProfile.getJSONArray("service_offered");
        for (int i = 0; i < service_offered.length(); i++) {
            try {
                JSONObject s = service_offered.getJSONObject(i);
                if (s.has("format")) {
                    JSONArray formats = s.getJSONArray("format");
                    for (int j = 0; j < formats.length(); j++) {
                        if (formats.getString(j).toLowerCase().equals(formatString)) {
                            return s.getString("@id");
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

}
