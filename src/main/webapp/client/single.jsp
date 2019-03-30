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
        <h2 class="modal-title" id="exampleModalLabel">Commande effectuée avec succès</h2>

      </div>
      <div class="modal-body">
       <img style="height:20vh;" class="img-responsive zoom-img" src="client/images/order.png" alt="" />
      </div>
      <div class="modal-footer">
          <a href="#" class="add-cart item_add" data-dismiss="modal" id="voirCommande"  >Voir Mes commandes</a>
           <a href="#" class="add-cart item_add" data-dismiss="modal"  >Continuer Mes achats</a>
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

                                                <h5 class="item_price"> {{purchase_cost}} € </h5>

                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>

                                                <ul class="tag-men">
                                                    <input type="number" id="qte" placeholder="Quantité" min="1" class="form-control" >
                                                    <div id="alert"></div>
                                                </ul>
                                            <a href="#" class="add-cart item_add" data-toggle="modal" data-target="#exampleModal" id="purchase" data-idProduct="{{product_ID}}" >Commander</a>
                                        </div>

                                    {{/product}}  
                                </div>
                                <div class="clearfix"> </div>
                        </div>

                        <div class="latestproducts">
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
                                                            <span>-50%</span>
                                                        </div>
                                                    </div>
                                                </div>

                                     {{/products}}  
                                        <div class="clearfix"></div>
                                </div>
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
</style>
	<!--end-single-->

        <script>
            
       

        $("#purchase").click(function(){
            console.log($(this));
            let nbr = $("#qte").val();
            let id = $(this).data("idproduct");
            Purchasing(id,nbr);
            if(nbr === ""){
                console.log(id+" nn "+nbr);
                $("#alert").html("<div class='alert alert-danger' role='alert'>Saisie de la Quantité incorrecte !</div>")
            }

        });
                
                

        $("#voirCommande").click(function(){

                $("#exampleModal").hide();
                 setTimeout(function(){
                   $('#orders').trigger('click');
                }, 1000);


        });

                
        function Purchasing(id,qte) {
        $.ajax({
            url: "OrderController?target=addorder&idProduct="+id+"&qte="+qte,
            dataType: "json",
            success: function () {
                   
            }
        });
    }

                
                
                
   
        </script>