<%-- 
    Document   : graphiques
    Created on : 29 mars 2019, 16:57:59
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
<div class="row">
    <div class="col">
        <br/><br/>
    </div>
    <!-- row -->
    <div class="row tm-content-row">
        <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
            <div class="tm-bg-primary-dark tm-block">
                <h2 class="tm-block-title">Latest Hits</h2>
                <canvas id="lineChart"></canvas>
            </div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
            <div class="tm-bg-primary-dark tm-block">
                <h2 class="tm-block-title">Performance</h2>
                <canvas id="barChart"></canvas>
            </div>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-taller">
                <h2 class="tm-block-title">Storage Information</h2>
                <div id="pieChartContainer">
                    <canvas id="pieChart" class="chartjs-render-monitor" width="200" height="200"></canvas>
                </div>                        
            </div>
        </div>  
    </div>
</div>
</div>
  <script src="Admin/js/Chart.min.js"></script>
<script>
        Chart.defaults.global.defaultFontColor = 'white';
        let ctxLine,
            ctxBar,
            ctxPie,
            optionsLine,
            optionsBar,
            optionsPie,
            configLine,
            configBar,
            configPie,
            lineChart;
        barChart, pieChart;
        // DOM is ready
        $(function () {
            drawLineChart(); // Line Chart
            drawBarChart(); // Bar Chart
            drawPieChart(); // Pie Chart

            $(window).resize(function () {
                updateLineChart();
                updateBarChart();                
            });
        })
    </script>