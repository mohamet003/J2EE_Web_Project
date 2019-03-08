/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){ 

function showProducts() {
    // On fait un appel AJAX pour chercher les codes
    $.ajax({
        url: "ProductController",
        dataType: "json",
        success: 
                function (result) {
                    
                    $.get("client/products.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#products').html(processedTemplate);
                    });
                    
                }
    });
}

showProducts();

});