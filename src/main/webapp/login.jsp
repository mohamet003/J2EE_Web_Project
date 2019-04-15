<%-- 
    Document   : login
    Created on : 1 mars 2019, 21:23:21
    Author     : mohametkone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<title>Login V16</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="client/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="client/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="client/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="client/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="client/css/util.css">
	<link rel="stylesheet" type="text/css" href="client/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('client/images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Authentification
				</span>
                            <form class="login100-form validate-form p-b-33 p-t-5" action="LoginController" method="post">

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="email" name="email" placeholder="EMAIL">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100"  type="password" name="password" placeholder="Mot de passe">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
                                            <button class="login100-form-btn" name="connexion" value="connexion">
							Connexion
						</button>
					</div>

				</form>
                            
                                <c:if test = "${result == 'error'}">
                                    <br>
                                    <div class="alert alert-danger" role="alert">
                                         Email ou mot de passe incorrect !
                                     
                                    </div>
                                </c:if>
			</div>
		</div>
	</div>

	
<!--===============================================================================================-->
	<script src="client/vendor/jquery/jquery-3.2.1.min.js"></script>

	<script src="client/js/main.js"></script>

</body>
</html>



