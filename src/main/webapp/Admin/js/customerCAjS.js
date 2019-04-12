/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
       google.charts.load('current', {packages: ['corechart']});
       google.charts.setOnLoadCallback(affcherGraphique);
         $(".users").click(affcherGraphique);
         $("#botChange").click(changeIcon);
})

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
    $('#myPieChart').html("");
    $("#dateD").val('');
    $("#dateF").val('');
    //recuperation de l'id de l'utilisateur
     let id = this.id;
     
        $("#valider").click(affiche)
        function affiche(event){
            $("#botChange").removeAttr("hidden");
            let dateD = $("#dateD").val();
            let dateF = $("#dateF").val();
            let url = "CAcustomerController?id="+id+"&dateD="+dateD+"&dateF="+dateF;
            $.ajax({
                url: url,
                type : "GET",
                dataType: "json",
                success: graphique,
                error : afficherErreur,
            }) ;
        }
}

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
                   'title':'My Big Pie Chart',
                   'is3D':true,
                   'width':800,
                   'height':500};
    // Instantiate and draw the chart.
    let chart = new google.visualization.ScatterChart(document.getElementById('myPieChart'));
    chart.draw(data, null);
    chart.draw(data, options); 
    $("#graph1").click(graphDiff);
    $("#graph2").click(graphDiff);
    $("#graph3").click(graphDiff);
    $("#graph4").click(graphDiff);
    
    //appels des diferent graphiques
    function graphDiff(event){
    switch (this.id){
          case "graph1" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.AreaChart(document.getElementById('myPieChart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph2" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.ColumnChart(document.getElementById('myPieChart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph3" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.LineChart(document.getElementById('myPieChart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph4" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
            }
}
               
}


