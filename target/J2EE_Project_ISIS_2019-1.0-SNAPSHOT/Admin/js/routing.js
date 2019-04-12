<<<<<<< HEAD
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
                    $("#graphiqueGeo").removeClass("active");
                    $("#graphiqueCat").removeClass("active");
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
        url: "CategorysController",
        dataType: "json",
        success: 
                function (result) {
                    $("#client").removeClass("active");
                    $("#graphiqueGeo").removeClass("active");
                    $("#graphiqueCat").addClass("active");
                    $.get("Admin/graphiques.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
function showGraphique2() {
    $.ajax({
        url: "StateController",
        dataType: "json",
        success: 
                function (result) {
                    $("#client").removeClass("active");
                    $("#graphiqueCat").removeClass("active");
                    $("#graphiqueGeo").addClass("active");
                    $.get("Admin/graphique2.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
$("#graphiqueCat").click(showGraphique);
$("#graphiqueGeo").click(showGraphique2);
$("#client").click(showUsers);
showUsers();
=======
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
                    $("#graphiqueGeo").removeClass("active");
                    $("#graphiqueCat").removeClass("active");
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
        url: "CategorysController",
        dataType: "json",
        success: 
                function (result) {
                    $("#client").removeClass("active");
                    $("#graphiqueGeo").removeClass("active");
                    $("#graphiqueCat").addClass("active");
                    $.get("Admin/graphiques.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
function showGraphique2() {
    $.ajax({
        url: "ZoneController",
        dataType: "json",
        success: 
                function (result) {
                    console.log(result);
                    $("#client").removeClass("active");
                    $("#graphiqueCat").removeClass("active");
                    $("#graphiqueGeo").addClass("active");
                    $.get("Admin/graphique2.jsp", function(template){
                    var processedTemplate = Mustache.to_html(template, result);
                    $('#container').html(processedTemplate);
                    });
                    
                }
    });
}
$("#graphiqueCat").click(showGraphique);
$("#graphiqueGeo").click(showGraphique2);
$("#client").click(showUsers);
showUsers();
>>>>>>> ce5799d56a684743bc277e7719f7eac75c86c62b
});