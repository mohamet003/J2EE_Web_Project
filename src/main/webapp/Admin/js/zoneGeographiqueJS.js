/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
       google.charts.load('current', {packages: ['corechart']});
       google.charts.setOnLoadCallback(affcherGraphique);
        $(".infosZone").click(affcherGraphique);
        
})

var id = 0;
function affcherGraphique(event){
     id = this.id;    
    //recuperer la longitude et la latitude
    $.ajax({
        url: "http://nominatim.openstreetmap.org/search?state=France&units=metric&lang=fr&format=json&addressdetails=1&city=castres&q="+id,
        dataType : "json",
        success: 
                function initMap (result) {
                    console.log(result);
                    let  lat = result[1].lat;
                    let  lon = result[1].lon;
                    var myLatLng = {lat: -25.363, lng: 131.044};
                    myLatLng.lng =parseFloat(lon);
                    myLatLng.lat = parseFloat(lat);
                    var map = new google.maps.Map(document.getElementById('map'), {
                        center: myLatLng,
                        zoom: 12
                    });
                    
                    var marker = new google.maps.Marker({
                    map: map,
                    position: myLatLng,
                    title: 'zone selectionné'
                    });
                    }
                    
        });
                
<<<<<<< HEAD
    
    //afficher le graphique 
    function affiche(event){
        let dateD = $("#dateD").val();
        let dateF = $("#dateF").val();
        let url = "CAZoneGeoController?id="+id+"&dateD="+dateD+"&dateF="+dateF;
        $.ajax({
            url: url,
            type : "GET",
            dataType: "json",
            success: graphique,
            error : afficherErreur,
        }) ;
    }
}

var id = 0;
function changeIcon(event){
    if($("#bimagine").hasClass("fa-plus")){
        $("#bimagine").removeClass("fa-plus");
        $("#bimagine").addClass("fa-minus");
    }
    else{
        $("#bimagine").removeClass("fa-minus");
        $("#bimagine").addClass("fa-plus");
    }
}

function affcherGraphique(event){
    $("#botChange").attr("hidden", "hidden");
    id = this.id;
    console.log("fdfdfdf  "+id);
}

=======
       
        // Create a map object and specify the DOM element
        // for display.
        
   
>>>>>>> 81b4f4cdbf7918a966551a46f307c63a9a9393dc
$("#valider").click(function(event){
    let dateD = $("#dateD").val();
    let dateF = $("#dateF").val();
    let url = "CAZoneGeoController?id="+id+"&dateD="+dateD+"&dateF="+dateF;
    $.ajax({
        url: url,
        type : "GET",
        dataType: "json",
        success: graphique,
        error : afficherErreur,
    }) ;
})



//afficher l'erreur 
function afficherErreur(error) {
    console.log(error)
}

//remplissage et affichage du graphique
function graphique(result) {
    let items = result.ca;
    let data = new google.visualization.DataTable();
    data.addColumn('string', 'date');
    data.addColumn('number', 'CA');
    for(item of items){
        data.addRows([ [item.date,item.CA] ]);    
    }
    // mise en option des caractéristiques des charts
    let options = {'legend':'left',
                   'title':'Chiffre d\'affaire par zone géographique',
                   'is3D':true,
                   'width':650,
                   'height':400};
    // Instantiate and draw the chart.
    let chart = new google.visualization.ScatterChart(document.getElementById('chart'));
    chart.draw(data, null);
    chart.draw(data, options); 
    $("#botChange").removeAttr("hidden");
    $("#graph1").click(graphDiff);
    $("#graph2").click(graphDiff);
    $("#graph3").click(graphDiff);
    $("#graph4").click(graphDiff);
    
    //appels des diferent graphiques
    function graphDiff(event){
    switch (this.id){
          case "graph1" : 
               $("#chart").html("");
               var chart = new google.visualization.AreaChart(document.getElementById('chart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph2" : 
               $("#chart").html("");
               var chart = new google.visualization.ColumnChart(document.getElementById('chart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph3" : 
               $("#chart").html("");
               var chart = new google.visualization.LineChart(document.getElementById('chart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph4" : 
               $("#chart").html("");
               var chart = new google.visualization.PieChart(document.getElementById('chart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
            }
}
               
}

}
