/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){ 

   
function showUsers() {
    $.ajax({
        url: "userControlleur",
        dataType: "json",
        success: 
                function (result) {
                    $.get("Admin/client.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}



function showGraphique() {
    $.ajax({
        url: "userControlleur",
        dataType: "json",
        success: 
                function (result) {
              
                    $.get("Admin/graphiques.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}

document.getElementById("client").addEventListener("click",showUsers);
showUsers();
});