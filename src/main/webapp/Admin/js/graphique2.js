/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
       google.charts.load('current', {packages: ['corechart']});
       google.charts.setOnLoadCallback(drawChart1);
       google.charts.setOnLoadCallback(drawChart2);
     })
function drawChart1() {
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
                     'width':1020,
                     'height':300};

      // Instantiate and draw the chart.
      var chart = new google.visualization.Histogram(document.getElementById('chart1'));
      chart.draw(data, null);
      chart.draw(data, options);
      }

function drawChart2() {
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
                     'width':100,
                     'height':100};

      // Instantiate and draw the chart.
      var chart = new google.visualization.Histogram(document.getElementById('chart2'));
      chart.draw(data, null);
      chart.draw(data, options);
      }