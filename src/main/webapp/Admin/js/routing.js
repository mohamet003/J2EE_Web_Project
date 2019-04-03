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
                    
                    console.log(result);
                    $("#graphique").removeClass("active");
                    $("#client").addClass("active");
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
                    $("#client").removeClass("active");
                    $("#graphique").addClass("active");
                    $.get("Admin/graphiques.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
$("#graphique").click(showGraphique);
$("#client").click(showUsers);
showUsers();
});