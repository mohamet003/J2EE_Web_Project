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
        
                <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" ata-backdrop="static">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title" id="exampleModalLabel">Étes-vous sure de vouloir supprimer cette commande ?</h1>

              </div>
              <div class="modal-body">
               <img style="height:20vh;" class="img-responsive zoom-img" src="client/images/supprimer.jpeg" alt="" />
              </div>
              <div class="modal-footer">
                    <!--start-single
                  <a href="#" class="add-cart item_add" data-dismiss="modal" id="voirCommande"  >Voir Mes commandes</a>
                   <a href="#" class="add-cart item_add" data-dismiss="modal"  >Continuer Mes achats</a>
                      -->
                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                 <button type="button" class="btn btn-danger" data-dismiss="modal" id="del">Supprimer</button>
              </div>
            </div>
          </div>
        </div>

        
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
                                            <div class="close1" data-toggle="modal" data-target="#exampleModal"  data-id="{{order_num}}"> </div>
                                                    <li class="ring-in">
                                                    <a href="#" data-id="{{product_ID}}" data-idorder="{{order_num}}" data-qte="{{quantity}}" class="detail">
                                                    <img src="client/images/order.png" style="width: 86px;" class="img-responsive" alt="">
                                                    </a>
                                                    </li>
                                                    <li><span class="cost">{{quantity}}</span></li>
                                                    <li><span class="cost">{{cost}} €</span></li>
                                                    <li><span class="cost">{{shipping_date}}</li>
                                                   
                                                    
                                            <div class="clearfix"> </div>
                                    </ul>
                                
                                {{/orders}}
                                

                                
			</div>
			</div>  
		 </div>
		</div>
	</div>
        
<script>

$(document).ready(function(c) {
    
var id = 0;

$('.close1').on('click', function(c){
    id = $(this).data('id');	  
});

$('#del').click(function() {
    deleteOrder(id);
    $('#'+id).fadeOut('slow', function(c){
            $('#'+id).remove();
    });
});

});


function deleteOrder(id) {
$.ajax({
    url: "OrderController?target=deleteorder&idOrder="+id,
    dataType: "json",
    success: function () {

    }
});

}

$(".detail").click(function(){
    
    id = $(this).data('id');
    var idorder = $(this).data('idorder');
    var qte = $(this).data('qte');
 console.log("depuis details "+idorder);
$.ajax({
    url: "SingleProductController?idProduct="+id,
    dataType: "json",
    success: function (datas) {
        
        $.get("client/single.jsp", function (template) {
            datas["txt_btn"]= "Modifier la Commande"; 
            datas["txt_alert"]= "Votre commande a bien été modifiée ?";
            datas["qte"]= qte;
            datas["idorder"]= idorder;
            datas["action"]= "updatepurchase";

            console.log(datas);
            var processedTemplate = Mustache.to_html(template,datas);
            $("#globalContainer").hide();
            $('#container').html(processedTemplate);
        });
}
});
 
    
});




</script>


