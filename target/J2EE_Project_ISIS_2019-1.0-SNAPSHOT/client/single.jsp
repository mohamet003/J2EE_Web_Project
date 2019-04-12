<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="exampleModalLabel">{{txt_alert}}</h2>

      </div>
      <div class="modal-body">
       <img style="height:20vh;" class="img-responsive zoom-img" src="client/images/order.png" alt="" />
      </div>
      <div class="modal-footer">
          <a href="#" class="add-cart item_add" data-dismiss="modal" id="voirCommande"  >Voir Mes commandes</a>
          <a href="#" class="add-cart item_add" data-dismiss="modal" id="" >Fermer</a>
           	<!--start-single
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>-->
      </div>
    </div>
  </div>
</div>

<!--start-single-->
<div class="single contact">
        <div class="container">
                <div class="single-main">
                        <div class="col-md-9 single-main-left">
                        <div class="sngl-top">
                                <div class="col-md-5 single-top-left">	
                                        <div class="flexslider">
                                                  <ul class="slides">
                                                        <li data-thumb="client/images/s-1.jpg">
                                                                <div class="thumb-image"> <img src="client/images/s-1.jpg" data-imagezoom="true" class="img-responsive" alt=""/> </div>
                                                        </li>
                                                  </ul>
                                        </div>

                                </div>	
                                <div class="col-md-7 single-top-right">
                                      {{#product}}  
                                        <div class="single-para simpleCart_shelfItem">
                                        <h2>{{description}} </h2>
                                                <div class="star-on">
                                                        <ul class="star-footer">
                                                                        <li><a href="#"><i> </i></a></li>
                                                                        <li><a href="#"><i> </i></a></li>
                                                                        <li><a href="#"><i> </i></a></li>
                                                                        <li><a href="#"><i> </i></a></li>
                                                                        <li><a href="#"><i> </i></a></li>
                                                                </ul>
                                                        <div class="review">
                                                                <a href="#"> 1 customer review </a>

                                                        </div>
                                                <div class="clearfix"> </div>
                                                </div>

                                        <h5 class="item_price" id="price" data-price="{{purchase_cost}}" data-qteOneHand="{{quantity_on_hand}}"> {{purchase_cost}} € </h5>

                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>

                                                <ul class="tag-men">
                                                    <input type="number" id="qte" value="{{qte}}" placeholder="Quantité" min="1" class="form-control" >
                                                    <div id="alert"></div>
                                                </ul>
                                            <a href="#" class="add-cart item_add" data-toggle="modal" data-target="#exampleModal" id="{{action}}" data-idProduct="{{product_ID}}" >{{txt_btn}}</a>
                                        </div>

                                    {{/product}}  
                                </div>
                                <div class="clearfix"> </div>
                        </div>

                        <div class="latestproducts">
                            <div class="product-top">
                                <div class="product-one">
                                    {{#products}} 
                                                <div class="col-md-3 product-left">
                                                    <div class="product-main simpleCart_shelfItem">
                                                        <a href="#" lass="mask"  ><img class="img-responsive zoom-img single" src="client/images/p-1.png" alt="" /></a>
                                                        <div class="product-bottom">
                                                            <h3>{{ description }}</h3>
                                                            <p>Explore Now</p>
                                                            <h4><a class="item_add" href="#"><i></i></a> <span class="item_price">{{ purchase_cost }} €</span></h4>
                                                        </div>
                                                        <div class="srch">
                                                            <span id="rate" data-rate="{{rate}}" >-{{rate}}%</span>
                                                        </div>
                                                    </div>
                                                </div>

                                     {{/products}}  
                                        <div class="clearfix"></div>
                                        </div>
                                </div>
                        </div>
                </div>
                    
        <div class="col-md-3 single-right">
                <div class="w_sidebar">
                        <section  class="sky-form">
                                <h4>Montant</h4>
                                <div class="row1 scroll-pane">
                                    <label class="money" id="montantBrute"></label>
                                    <label style="color:green" class="money"  id="remise"></label>
                                    <label style="color:red" class="money"  id="frais"></label>
                                    <label class="money"  id="montant"></label>		
                                </div>
                        </section>

                </div>
        </div>

                        <div class="clearfix"> </div>
                </div>
        </div>
</div>

<style>
    a{
        text-decoration: none;
    }
    
    .money{
        font: 1.2rem 'AmstelvarAlpha', sans-serif;
    }
</style>
	<!--end-single-->

        <script>
            
       //le prix du produit
       var price = $("#price").data("price");
       // la quantité du produit
       var qte = 0;
       // le montant à payer
       var montant = 0;
       // le taux de remise
       var rate = $("#rate").data("rate");
       // quantité dispo
       var qteDispo = $("#price").data("qteOneHand");
       // frais de port
       var fraisExpedition = 0 ;
       
       
       qte = $("#qte").val();
       calculMontant(qte,price);
       
       $("#qte").change(function(){
           qte = $("#qte").val();
           calculMontant(qte,price);
       });
       
       
       $("#qte").keyup(function(){
           qte = $("#qte").val();
           calculMontant(qte,price);
       });


       // l'évenement qui permet d'effectuer la commande
        $("#purchase").click(function(){
            let id = $(this).data("idproduct");
            if (verifQte (qte,qteDispo)) {
                Purchasing(id,qte,fraisExpedition);
            }else{
                console.log("incorrect");
            }
            
            
        });
        
        //calculer le montant en fonction de la remise
        function calculMontant(qte,price){
            let remise =    Math.round(((qte*price*rate)/100) * 100) / 100 ;
            montant =  Math.round(((qte*price) - remise) * 100) / 100;
            fraisExpedition  =  Math.round((qte*4.5) * 100) / 100;
            console.log("Montant Hors remise: "+Math.round((qte*price) * 100) / 100+" remise : "+remise+" montant: "+montant)
            $("#montantBrute").text("Montant Brut  : "+Math.round((qte*price) * 100) / 100+" €");
            $("#remise").text("Remise "+rate+"% :    - "+remise+" €");
            $("#frais").text("Frais d'envoi    :    + "+fraisExpedition+" €");
            montant = Math.round((montant + fraisExpedition) * 100) / 100 ;
            $("#montant").text("Montant à payer : "+montant+" €");
        }
        
        // verif quantité à commender
        
        function verifQte (qte,qteDispo){
            if (qte <= qteDispo || qte === 0) {
                
                
                return false;
            }
            return true;
        }
        
        
        // mettre a jour la commande
        $("#updatepurchase").click(function(){
        //console.log($(this));
        let id = $(this).data("idproduct");
        qte = $("#qte").val();
        $.ajax({
            url: "OrderController?target=updateorder&idOrder="+id+"&qte="+qte+"&frais="+fraisExpedition,
            dataType: "json",
            success: function () {
                   
            }
        });

    });
             
                
                
        // lister les commandes 
        $("#voirCommande").click(function(){

                $("#exampleModal").hide();
                 setTimeout(function(){
                   $('#orders').trigger('click');
                }, 1000);


        });
        
        
        // fermer le modale 
        $("#close").click(function(){
  
                $("#exampleModal").hide();
                 setTimeout(function(){
                   location.reload();
                }, 1000);


        });

        // methode qui permet d'effectue la commande       
        function Purchasing(id,qte,fraisExpedition) {
        $.ajax({
            url: "OrderController?target=addorder&idProduct="+id+"&qte="+qte+"&frais="+fraisExpedition,
            dataType: "json",
            success: function () {
                   
            }
        });
    }

                
                
                
   
        </script>