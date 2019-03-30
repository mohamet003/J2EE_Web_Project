/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){ 

   
    function showProducts() {
        $.ajax({
            url: "ProductController",
            dataType: "json",
            success:function (result) {
                        $.get("client/products.jsp", function(template){
                        var processedTemplate = Mustache.to_html(template, result);
                        $('#container').html(processedTemplate);
                        });   
                    }
        });
    }


    function showOrders() {
      
        $.ajax({
            url: "OrderController",
            dataType: "json",
            success:function (result) {
                        console.log(result);
                        $.get("client/orders.jsp", function(template){
                        var processedTemplate = Mustache.to_html(template, result);
                        $("#globalContainer").hide();
                        $('#container').html(processedTemplate);
                        });

                    }
        });
    }


$("#orders").click(showOrders);

// Afficher les commandes de l'utilisateur
//document.getElementById("orders").addEventListener("click",showOrders);

// afficher les produits
showProducts();


});