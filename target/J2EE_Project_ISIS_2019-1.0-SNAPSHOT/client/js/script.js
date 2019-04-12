/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){ 



   
    function showProducts(id,idd) {
        $.ajax({
            url: "ProductController?idCategory="+id+"&idd="+idd,
            dataType: "json",
            success:function (result) {
                        $.get("client/products.jsp", function(template){
                            console.log(result);
                        var processedTemplate = Mustache.to_html(template, result);
                        $("#globalContainer").hide();
                         $(".loader").show();
                        $('#container').html(processedTemplate);
                         $(".loader").hide();
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
    
    
    $("#recherche").keyup(function() {
       let resultat = $(this).val();
       console.log(resultat);
       $.ajax({
            url: "ProductController?resultat="+resultat,
            dataType: "json",
            success:function (result) {
                
                        $.get("client/products.jsp", function(template){
                            console.log(result);
                        var processedTemplate = Mustache.to_html(template, result);
                        $("#globalContainer").hide();
                         $(".loader").show();
                        $('#container').html(processedTemplate);
                         $(".loader").hide();
                        }); 

                    }
        });
    });

// Afficher les commandes de l'utilisateur
$("#orders").click(showOrders);

// Afficher les produits des catégories
$(".categorys").click(function () {

    let id  = $(this).data('id');
    let idd  = $(this).data('iddiscount');
    console.log("ddd "+ idd);
    showProducts(id,idd);
})


});