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
                    $("#graph1").removeClass("active");
                    $("#graph2").removeClass("active");
                    $("#client").addClass("active");
                    $.get("Admin/client.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}



function showGraphique1() {
    $.ajax({
        url: "userControlleur",
        dataType: "json",
        success: 
                function (result) {
                    $("#client").removeClass("active");
                    $("#graph2").removeClass("active");
                    $("#graph1").addClass("active");
                    $.get("Admin/graphiques.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
function showGraphique2() {
    alert("ddd")
    $.ajax({
        url: "userControlleur",
        dataType: "json",
        success: 
                function (result) {
                    $("#client").removeClass("active");
                    $("#graph1").removeClass("active");
                    $("#graph2").addClass("active");
                    $.get("Admin/graphique2.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
$("#graphiqueCat").click(showGraphique1);
$("#graphiqueGeo").click(showGraphique2);
$("#client").click(showUsers);
showUsers();
});