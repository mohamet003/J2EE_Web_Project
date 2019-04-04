/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
       google.charts.load('current', {packages: ['corechart']});
        google.charts.setOnLoadCallback(drawChart);
        $("#graph1").click(drawChart);
        $("#graph2").click(drawChart);
        $("#graph3").click(drawChart);
        $("#graph4").click(drawChart);
     })

    function drawChart(event) {
      // Define the chart to be drawn.
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Element');
      data.addColumn('number', 'Percentage');
      data.addRows([
        ['Nitrogen', 0.78],
        ['Oxygen', 0.21],
        ['Other', 0.01]
      ]);
      
      // Set chart options
      var options = {'legend':'left',
                     'title':'My Big Pie Chart',
                     'is3D':true,
                     'width':1100,
                     'height':400};

      // Instantiate and draw the chart.
      var chart = new google.visualization.Histogram(document.getElementById('chart1'));
      chart.draw(data, null);
      chart.draw(data, options);
      switch (this.id){
          case "graph1" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.AreaChart(document.getElementById('chart1'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph2" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.ScatterChart(document.getElementById('chart1'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph3" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.LineChart(document.getElementById('chart1'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
           case "graph4" : 
               $("#myPieChart").html("");
               var chart = new google.visualization.Histogram(document.getElementById('chart1'));   
               chart.draw(data, null);
               chart.draw(data, options);
               break;
      }
      
       
    }
    
    
