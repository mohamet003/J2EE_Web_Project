<%-- 
    Document   : index
    Created on : 8 mars 2019, 10:12:07
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>E_Commerce</title>

  <!-- Bootstrap core CSS -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
        <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet">
    </head>
    <body>
        <section id="container">
        <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
         *********************************************************************************************************************************************************** -->
        <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
        <!--logo start-->
                <a href="index.html" class="logo"><b>E_COM<span>MERCE</span></b></a>
        <!--logo end-->
                <div class="nav notify-row" id="top_menu">
                    <div class="top-menu">
                        <ul class="top-menu" style="margin-left: 800%;">
                            <li><a class="logout" href="#">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </header>
        <!--header end-->
        <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
        <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse">
            <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <p class="centered"><a href="#"><img src="img/ui-sam.png" class="img-circle" width="80"></a></p>
                        <h5 class="centered"><i class="fa fa-circle" style="color:lightskyblue"></i> Admin</h5>
                        <li class="mt">
                            <a href="index.html">
                                <i class="fa fa-th"></i>
                                <span>Clients</span>
                            </a>
                        </li>
                        <li class="mt">
                            <a href="graphiques.html">
                            <i class="fa fa-bar-chart-o"></i>
                            <span>Graphiques</span>
                            </a>
                        </li>
                    </ul>
            <!-- sidebar menu end-->
                </div>
            </aside>
        <!--sidebar end-->
        <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
        <!--main content start-->
            <section id="main-content">
                <section class="wrapper site-min-height">
                    <h3><i class="fa fa-angle-right"></i> Liste des clients</h3>
                        <section id="unseen">
                            <table class="table table-striped table-advance table-hover">
                                <hr>
                                    <thead>
                                        <tr>
                                            <th><i class="fa fa-bullhorn"></i>Nom</th>
                                            <th class="hidden-phone"><i class="fa fa-question-circle"></i>Téléphone</th>
                                            <th><i class="fa fa-bookmark"></i> Prix</th>
                                            <th><i class=" fa fa-edit"></i> Adress</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <a href="#">Kone</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>12000.00$ </td>
                                            <td><span class="label label-info label-mini">Castres</span></td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-bar-chart-o"></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="#">Mohamet</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>17900.00$ </td>
                                            <td><span class="label label-warning label-mini">Castres</span></td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-bar-chart-o"></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="#">Another</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>14400.00$ </td>
                                            <td><span class="label label-success label-mini">Castres</span></td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-bar-chart-o"></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="#">Gelel</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>22000.50$ </td>
                                            <td><span class="label label-success label-mini">Castres</span></td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-bar-chart-o"></i></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <a href="#">Total</a>
                                            </td>
                                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                                            <td>12120.00$ </td>
                                            <td><span class="label label-warning label-mini">Castres</span></td>
                                            <td>
                                                <button class="btn btn-primary btn-xs"><i class="fa fa-bar-chart-o"></i></button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </section>    
                        </section>
        <!-- /wrapper -->
                    </section>
                </section>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="lib/jquery/jquery.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="lib/jquery.ui.touch-punch.min.js"></script>
    <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
    <script src="lib/jquery.scrollTo.min.js"></script>
    <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
    <!--common script for all pages-->
    <script src="lib/common-scripts.js"></script>
    <!--script for this page-->
</body>

</html>
