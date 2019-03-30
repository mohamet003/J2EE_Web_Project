<%-- 
    Document   : orders
    Created on : 16 mars 2019, 18:42:43
    Author     : mohametkone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="LoginController">Menu Principal</a></li>
					<li class="active">Commandes</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
			<div class="ckeck-top heading">
				<h2>COMMANDE(S)</h2>
			</div>
			<div class="ckeckout-top">
			<div class="cart-items">
			 <h3>My Shopping Bag </h3>

				
			<div class="in-check" >
                            
                            
				<ul class="unit">
					<li><span></span></li>					
					<li><span>QUANTITÉ</span></li>		
					<li><span>MONTANT</span></li>
					<li><span>DATE COMMANDE</span></li>
                                        <li><span></span></li>
                                        <li><span></span></li>
					<div class="clearfix"> </div>
				</ul>
                              
                            
                                {{#orders}}
                                
                                    <ul class="cart-header" id="{{order_num}}">
                                            <div class="close1" data-id="{{order_num}}"> </div>
                                                    <li class="ring-in">
                                                    <a href="single.html" >
                                                    <img src="client/images/order.png" style="width: 86px;" class="img-responsive" alt="">
                                                    </a>
                                                    </li>
                                                    <li><span class="cost">{{quantity}}</span></li>
                                                    <li><span class="cost">{{shipping_cost}} €</span></li>
                                                    <li><span class="cost">{{shipping_date}}</li>
                                                   
                                                    
                                            <div class="clearfix"> </div>
                                    </ul>
                                
                                {{/orders}}
                                
			</div>
			</div>  
		 </div>
		</div>
	</div>
        
<script>$(document).ready(function(c) {
$('.close1').on('click', function(c){
    let id = $(this).data('id');
        $('#'+id).fadeOut('slow', function(c){
                $('#'+id).remove();
        });
        });	  
});
</script>


