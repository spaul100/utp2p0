/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utp.toolRegistration;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.utp.database.toolCapabilityEnabled;
import org.utp.databaseprocess.ToolCapabilityEnabledProcess;
import org.utp.databaseprocess.ToolDetailsProcess;
import org.utp.utils.Constants;

/**
 *
 * @author Sourav Kumar Paul
 */
public class SubmitCapabilityDetails extends HttpServlet {

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
            throws ServletException, IOException, JSONException {
        HttpSession session = request.getSession(false);
        String isLoggedIn = (String) session.getAttribute(Constants.LOGGED_IN);
        if (isLoggedIn != null && isLoggedIn.equals("true")) {

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                String registerUrl = request.getParameter("registerUrl");
                String launchUrl = request.getParameter("launchUrl");
                String size = request.getParameter("size");
                String requiredCustomParameters = request.getParameter("required_parameters_size");
                String optionalCustomParameters = request.getParameter("optional_parameters_size");
                System.out.println("req :" + requiredCustomParameters);
                System.out.println("opt : " + optionalCustomParameters);
                String parts[] = registerUrl.split(("/"));
                String id = parts[parts.length - 1];

                ToolCapabilityEnabledProcess capabilityProcess = new ToolCapabilityEnabledProcess();

                ArrayList<String> capabilities = capabilityProcess.getCapability(Integer.parseInt(id));
                toolCapabilityEnabled capaInsert = new toolCapabilityEnabled();
                for (int i = 0; i < capabilities.size(); i++) {
                    String capa = capabilities.get(i);
                    String name = request.getParameter(capa + "/Name");
                    String variable = request.getParameter(capa + "/Variable");
                    capaInsert.setid(Integer.parseInt(id));
                    capaInsert.setcapability(capa);
                    capaInsert.setName(name);
                    capaInsert.setVariable(variable);

                    capabilityProcess.insert(capaInsert);
                }

                /*   while (en.hasMoreElements()) {
                 String param = en.nextElement();
                 String paramValue = request.getParameter(param);
                 String capa = null;

                 if ((param.equals("registerUrl") || (param.equals("launchUrl")) || (param.equals("size")) || (param.equals("submit")) || (param.contains("Required_Parameter"))|| (param.equals("required_parameters_size")) || param.equals("optional_parameters_size") || (param.contains("Optional_Parameter")))) {
                 continue;
                 }

                 String capability[] = param.split("/");
                 capa = capability[0];

                 String value = en.nextElement();
                 String paramVariable = request.getParameter(value);

                 capabilities.setid(Integer.parseInt(id));
                 capabilities.setcapability(capa);
                 capabilities.setName(paramValue);
                 capabilities.setVariable(paramVariable);

                 capabilityProcess.insert(capabilities);

                 } */
                Enumeration<String> en = request.getParameterNames();
                System.out.println("Now Parameter");
                en = request.getParameterNames();
                JSONArray customRequired = new JSONArray();
                JSONArray customOptional = new JSONArray();
                while (en.hasMoreElements()) {
                    String param = en.nextElement();
                    if (param.contains("Required_Parameter")) {
                        String paramValue = request.getParameter(param);
                        customRequired.put(paramValue);
                    } else if (param.contains("Optional_Parameter")) {
                        String paramValue = request.getParameter(param);
                        customOptional.put(paramValue);
                    }

                }
                System.out.println("required :" + customRequired);
                System.out.println("optional : " + customOptional);

                ToolDetailsProcess parameterInsert = new ToolDetailsProcess();
                parameterInsert.insert(customRequired.toString(), customOptional.toString(), Integer.parseInt(id));
                out.print("<html lang=\"en\">\n"
                        + "    <head>\n"
                        + "        <meta charset=\"utf-8\" />\n"
                        + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n"
                        + "        <title>Tool Profile</title>\n"
                        + "\n"
                        + "        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width\" />\n"
                        + "<link rel=\"stylesheet\" href=\"css/successMessage.css\">\n"
                        + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" />\n"
                        + "        <link href=\"css/gsdk-base.css\" rel=\"stylesheet\" />  \n"
                        + "        <link href=\"css/successMessage.css\" rel=\"stylesheet\" />  \n"
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
                        + "<style>\n"
                        + "#header {\n"
                        + "    background-color:9fdd85;\n"
                        + "    color:white;\n"
                        + "    text-align:center;\n"
                        + "    padding:5px;\n"
                        + "}"
                        + "#copy { position: absolute; left:45px }"
                        + "#tb5 {\n"
                        + "	border:2px solid #456879;\n"
                        + "	border-radius:20px;\n"
                        + "	height: 35px;\n"
                        + "	width: 500px;\n"
                        + "font-weight: bold;"
                        + "text-align : center;"
                        + "}"
                        + "</style>\n"
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
                        + "                                        <li><a  href=\"#account\" data-toggle=\"tab\">Step 2</a></li>\n"
                        + "                                        <li class=\"active\" ><a href=\"#address\" data-toggle=\"tab\">Step 3</a></li>\n"
                        + "                                    </ul>\n"
                        + "                                    <div class=\"tab-content\">\n"
                        + "                                        <div >\n"
                        + "                                            <div class=\"row\">\n"
                        + "                                                <div class=\"container\">\n"
                        + "                                                    <div class=\"row\">\n"
                        + "                                                        <form role=\"form\" action=\"index.jsp\" method=\"Post\">\n"
                        + "                                                            <div class=\"col-lg-6\">");

                out.print("<div id=copy style=center class=\"container\" >\n"
                        + "  <div  id=header class=\"jumbotron padding-left: 800pt  col-sm-6 col-md-11\" >\n"
                        + "    <h2>You have registered your Tool successfully</h2>      \n"
                        + "<hr>"
                        + "    <h4>For further reference please note down your tool proxy registration url</h4>      \n"
                        + "<p> <b><input id=tb5 type=\"text\" name=\"country\" value=\"" + registerUrl + "\" readonly></b></p>"
                );
            //out.println("<div>Register Url : " + registerUrl);
                // out.println("Launch Url : " + launchUrl);
                out.print("</div</div>");
                out.print("<p></p>\n"
                        + "                                                                <br>    <input type=\"submit\" name=\"submit\" id=\"submit\" class=\"btn btn-primary\" value=\"Finish\" >\n"
                        + "                                                                "
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

            }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(SubmitCapabilityDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(SubmitCapabilityDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
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
