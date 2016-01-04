<%-- 
    Document   : index
    Created on : 24-Jun-2015, 14:21:29
    Author     : DAYA-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Tool Profile</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/gsdk-base.css" rel="stylesheet" />  
        <link rel='stylesheet' href='css/formstyle.css' type='text/css' />  
        <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>


    </head>

    <body>
        <div>
            <!--   Creative Tim Branding   -->


            <!--   Big container   -->
            <div class="container">
                <div class="row">
                    <div >

                        <!--      Wizard container        -->   
                        <div> 

                            <div class="card wizard-card ct-wizard-azzure" id="wizard">

                                <!--        You can switch "ct-wizard-orange"  with one of the next bright colors: "ct-wizard-blue", "ct-wizard-green", "ct-wizard-orange", "ct-wizard-red"             -->

                                <div class="wizard-header">
                                    <h3>
                                        <b>Tool</b> Profile Registration <br>
                                        <small>Please let us know about your tool.</small>
                                    </h3>
                                </div>
                                <ul>
                                    <li class="active"><a href="#about" data-toggle="tab">Step 1</a></li>
                                    <li><a  href="#account" data-toggle="tab">Step 2</a></li>
                                    <li ><a href="#address" data-toggle="tab">Step 3</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div >
                                        <div class="row">
                                            <div class="container">
                                                <div class="row">
                                                    <form role="form" action="SubmitToolProfile" method="POST" onsubmit="Emptyvalidation(Product_Default_Value)">
                                                        <div class="col-lg-6">
                                                            <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk" style="color: red"></span>Required Field</strong></div>
                                                            <div class="form-group">
                                                                <div class="container">

                                                                    <h3>LTI Version</h3>

                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Enter LTI Version"><b>Version  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control"  name="Version" id="InputName" value="LTI-2p0" readonly="readonly">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div> 
                                                                </div>



                                                                <div class="container">
                                                                    <h3>Product Info</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Name of your Product. eg., YourProduct"><b>Product Name (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Product_Default_Value" id="InputName" placeholder="" value="<%= request.getAttribute("Product_Default_Value")%>" />  
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p style="color:red"><%= (String) request.getAttribute("empty2")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of your Product Name. eg., product.name"><b>Product Name (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Product_Key" id="InputName" placeholder=""  value="<%= request.getAttribute("Product_Key")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty3")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Short Description of your product"><b>Product Description (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Product_Description_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Product_Description_Defaultvalue")%>" value="<%= request.getAttribute("")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty4")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Tool Description. eg., tool.description"><b>Tool Description (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Tool_Description_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Tool_Description_Key")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty5")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Version of your product. eg., 1.0"><b>Product Version  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Product_Version" id="InputName" placeholder="" required value="<%= request.getAttribute("Product_Version")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty6")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Short technical Description of your product. eg., Support for LTI 2.0"><b>Technical Description (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group"> 
                                                                                    <input type="text" class="form-control" name="Technical_Description_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Technical_Description_Defaultvalue")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty7")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Technical Description. eg., tool.technical"><b>Tool Technical Description (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Tool_Technical_Description_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Tool_Technical_Description_Key")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty8")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>



                                                                <div class="container">
                                                                    <h3>Vendor</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Name of Vendor. eg., yourcompany ltd."><b>Vendor Name (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Vendor_Name_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Vendor_Name_Defaultvalue")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty9")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Vendor Name. eg., product.vendor.name"><b>Vendor Name (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Vendor_Name_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Vendor_Name_Key")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty10")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Short Description of Vendor."><b>Vendor Description (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Vendor_Description_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Vendor_Description_Defaultvalue")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty11")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Vendor Description. eg., tool.vendor.description"><b>Vendor Description (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Vendor_Description_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Vendor_Description_Key")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty12")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Enter website of vendor. eg., http://www.example.com"><b>Website  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="http" class="form-control" name="Website" id="InputName" placeholder="http" required value="<%= request.getAttribute("Website")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty13")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;">
                                                                                <label for="InputEmail" data-toggle="tooltip" data-placement="right"  title="Enter contact information of vendor(Email). eg., something@example.com"><b>Contact  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="email" class="form-control" id="InputEmailFirst" name="Contact" placeholder="" required value="<%= request.getAttribute("Contact")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty14")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Enter valid vendor code. It can be string or digits. eg., something.org, 12345"><b>Vender Code  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Vendor_Code" id="InputName" placeholder="" required value="<%= request.getAttribute("Vendor_Code")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty29")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>


                                                                <div class="container">
                                                                    <h3>Product Family</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Id of your product. It can be string or digits. eg., 12345, product#2"><b>Product id  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Product_id" id="InputName" placeholder="" required value="<%= request.getAttribute("Product_id")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty30")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Code of your product. It can be string or digits. eg., 12345, productCode#2"><b>Product Code  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Product_Code" id="InputName" placeholder="" required value="<%= request.getAttribute("Product_Code")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"> </span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty31")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>



                                                                <div class="container">
                                                                    <h3>Support Team</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;">
                                                                                <label for="InputEmail"></label>

                                                                                <div class="input-group">
                                                                                    <input data-toggle="tooltip" data-placement="top"  title="Enter valid email id of your support team. eg., example@something.com" type="email" class="form-control" id="InputEmailFirst" name="Support_Team" placeholder="" required value="<%= request.getAttribute("Support_Team")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty15")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>



                                                                <div class="container">
                                                                    <h3>Service Provider</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Name of service provider. eg., Something.org"><b>Service Provider Name (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Provider_Name_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Provider_Name_Defaultvalue")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty16")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Service Provider Name. eg., service_provider.name"><b>Service Provider Name (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Provider_Name_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Provider_Name_Key")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty17")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Short description of service provider."><b>Service Provider Description (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Provider_Description_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Provider_Description_Defaultvalue")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty18")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Service Provider Description. eg., service_provider.key"><b>Service Provider Description (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Provider_Description_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Provider_Description_Key")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty19")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;">
                                                                                <label for="InputEmail" data-toggle="tooltip" data-placement="right"  title="Enter valid email id of Support team of Service Provider. eg., example@something.com"><b>Service Provider Support  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="email" class="form-control" id="InputEmailFirst" name="Service_Provider_Support" placeholder="" required value="<%= request.getAttribute("Service_Provider_Support")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty20")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Unique id of Service Provider. It can be string or digits. eg., 12345, service#2"><b>GUID  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Provider_guid" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Provider_guid")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty32")%></p>
                                                                            </div>

                                                                        </div>
                                                                    </div>
                                                                </div>



                                                                <div class="container">
                                                                    <h3>Service Owner</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Name of Service Owner. eg., something.org"><b>Service Owner Name (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Owner_Name_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Owner_Name_Defaultvalue")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty21")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Service Owner Name. eg., service_owner.name"><b>Service Owner Name (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Owner_Name_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Owner_Name_Key")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty22")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Short description of Service Owner."><b>Service Owner Description (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Owner_Description_Defaultvalue" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Owner_Description_Defaultvalue")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty23")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of Service Owner Description. eg., service_owner.description"><b>Service Owner Description (Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Owner_Description_Key" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Owner_Description_Key")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty24")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title=" Unique Id of Service Owner. It can be string or digits. eg., 12345, serviceOwner#2"><b>GUID  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Service_Owner_guid" id="InputName" placeholder="" required value="<%= request.getAttribute("Service_Owner_guid")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty25")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>



                                                                <div class="container">
                                                                    <h3>Resource Handler</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName"><b>LTI Launch Path</b></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="lti_path" value="lti/launch" readonly ="readonly" id="InputName" placeholder="" required >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty26")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName"><b>Message Type</b></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="message_type" value = "basic-lti-launch-request" readonly = "readonly" id="InputName" placeholder="" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty27")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Code of Resource Type. Here resource can be quiz, homework, videos etc. It can be string or number eg., 12345, resourceType#2"><b>Resource Type Code  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Resourse_Type_Code" id="InputName" placeholder="" required value="<%= request.getAttribute("Resourse_Type_Code")%>" >
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty33")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Name of your Resource. eg., school assignment tool, quiz, homework, videos"><b>Resource Name (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Resourse_Name_DefaultValue" id="InputName" placeholder="" required  value="<%= request.getAttribute("Resourse_Name_DefaultValue")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty34")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of resource name. eg., quiz.resource.name"><b>Resource Name (Default Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Resourse_Name_DefaultKey" id="InputName" placeholder="" required  value="<%= request.getAttribute("Resourse_Name_DefaultKey")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty35")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Short Description of your resource."><b>Resource Description (Default Value)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Resourse_Description_DefaultValue" id="InputName" placeholder="" required value="<%= request.getAttribute("Resourse_Description_DefaultValue")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty36")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Key of resource description. eg., quiz.resource.description"><b>Resource Description (Default Key)  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Resourse_Description_DefaultKey" id="InputName" placeholder="" required  value="<%= request.getAttribute("Resourse_Description_DefaultKey")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty37")%></p>
                                                                            </div>


                                                                            <div class="container" style="float: left; width: 50%">
                                                                                <h3 data-toggle="tooltip" data-placement="top"  title="Select those capabilities you want from tool consumer.">Capability Wanted  <img src="Design/images/QuestionMark.jpg"></h3>
                                                                                <div class="panel panel-default">
                                                                                    <div class="panel-body">
                                                                                        <select name="Capability_Offered" multiple style="width:100%" size="10" required>
                                                                                            <option value="Context.id">Context.id</option>
                                                                                            <option value="CourseSection.label">CourseSection.label</option>
                                                                                            <option value="CourseSection.longDescription">CourseSection.longDescription</option>
                                                                                            <option value="CourseSection.sourceId">CourseSection.sourcedId</option>
                                                                                            <option value="CourseSection.timeFrame.begin">CourseSection.timeFrame.begin</option>
                                                                                            <option value="CourseSection.title">CourseSection.title</option>
                                                                                            <option value="Membership.role">Membership.role</option>
                                                                                            <option value="Person.address.country">Person.address.country</option>
                                                                                            <option value="Person.address.locality">Person.address.locality</option>
                                                                                            <option value="Person.address.street1">Person.address.street1</option>
                                                                                            <option value="Person.address.timezone">Person.address.timezone</option>
                                                                                            <option value="Person.email.primary">Person.email.primary</option>
                                                                                            <option value="Person.name.family">Person.name.family</option>
                                                                                            <option value="Person.name.full">Person.name.full</option>
                                                                                            <option value="Person.name.given">Person.name.given</option>
                                                                                            <option value="Person.name.middle">Person.name.middle</option>
                                                                                            <option value="Person.phone.mobile">Person.phone.mobile</option>
                                                                                            <option value="Person.phone.primary">Person.phone.primary</option>
                                                                                            <option value="Person.sourceId">Person.sourcedId</option>
                                                                                            <option value="Person.webaddress">Person.webaddress</option>
                                                                                            <option value="ResourceLink.description">ResourceLink.description</option>
                                                                                            <option value="ResourceLink.id">ResourceLink.id</option>
                                                                                            <option value="ResourceLink.title">ResourceLink.title</option>
                                                                                            <option value="Result.autocreate">Result.autocreate</option>
                                                                                            <option value="Result.sourceId">Result.sourcedId</option>
                                                                                            <option value="User.id">User.id</option>
                                                                                            <option value="User.username">User.username</option>

                                                                                        </select>

                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="container" style="float: right; width: 50%">
                                                                                <h3 data-toggle="tooltip" data-placement="top"  title="Select those services you want from tool consumer.">Services Wanted  <img src="Design/images/QuestionMark.jpg"></h3>
                                                                                <div class="panel panel-default">
                                                                                    <div class="panel-body">
                                                                                        <select name="Services_Offered"  multiple style="width:100%" required>
                                                                                            <option value="Tool Consumer Profile">Tool Consumer Profile</option>
                                                                                            <option value="Tool Proxy">Tool Proxy</option>


                                                                                        </select>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="container">
                                                                    <h3>Custom Parameters</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Enter no of required custom parameters you want to insert. eg., 5"><b>Number of Required Custom Parameters  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Number_of_Required_Custom_Parameters" id="InputName" placeholder="" required  value="<%= request.getAttribute("Number_of_Required_Custom_Parameters")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty38")%></p>
                                                                            </div>
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Enter no of optional custom parameters you want to insert. eg., 5"><b>Number of Optional Custom Parameters  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Number_of_Optional_Custom_Parameters" id="InputName" placeholder="" required  value="<%= request.getAttribute("Number_of_Optional_Custom_Parameters")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty39")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="container">
                                                                    <h3 >Tool Url</h3>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="form-group" style="margin-left: 30pt;";">
                                                                                <label for="InputName" data-toggle="tooltip" data-placement="right"  title="Enter url of landing page of your tool. eg., http://www.thing.org/page"><b>Url  </b><img src="Design/images/QuestionMark.jpg"></label>

                                                                                <div class="input-group">
                                                                                    <input type="text" class="form-control" name="Tool_Url" id="InputName" placeholder="" required value="<%= request.getAttribute("Tool_Url")%>">
                                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk" style="color: red"></span></span>
                                                                                </div>
                                                                                <p  style="color:red"><%= (String) request.getAttribute("empty28")%></p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>


                                                                <input type="submit" name="submit" id="submit" value="Next" class="btn btn-info pull-right" onclick="Emptyvalidation("Product_key")">
                                                            </div>

                                                        </div>
                                                    </form>

                                                </div>
                                                <!-- Registration form - END -->

                                            </div>
                                        </div>
                                    </div>





                                </div>

                            </div> <!-- wizard container -->

                        </div>

                    </div><!-- end row -->

                </div> <!--  big container -->







            </div>

    </body>
    <script src="Empty.js" ></script>  
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>

    <!--   plugins 	 -->
    <script src="js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
    <script src="js/wizard.js"></script>

</html>