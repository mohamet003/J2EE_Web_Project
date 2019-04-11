<%-- 
    Document   : graphique2
    Created on : 4 avr. 2019, 13:27:13
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
<br/><br/>
<div class="row">
    <div id="chart" class="col-lg-11"></div>
    <div class="col-lg-1 btn btn-group-vertical" role="group" aria-label="First group">
        <a class="tm-product-delete-link" style="background: #3D4E62; margin-left: -16px" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i class="fas fa-plus" style="color:white"></i>
        </a>
        <div class="collapse row" id="collapseExample" style="width: 40px;">
            <a href="#" id="graph1" class="tm-product-delete-link col-lg-12" style="background: #3D4E62;">
                <i class="fas fa-chart-area" style="color:white"></i>
            </a>
            <a href="#" id="graph2" class="tm-product-delete-link col-lg-12" style="background: #3D4E62;">
                <i class="fas fa-chart-line" style="color:white"></i>
            </a>
            <a href="#" id="graph3" class="tm-product-delete-link col-lg-12" style="background: #3D4E62;">
                <i class="fas fa-chart-bar" style="color:white"></i>
            </a>
            <a href="#" id="graph4" class="tm-product-delete-link col-lg-12" style="background: #3D4E62;">
                <i class="fas fa-diagnoses" style="color:white"></i>
            </a>
        </div>
    </div>
</div><br/><br/>
  <div class="form-row">
    <div class="form-group col-md-3">
      <label for="dateFin">Date début</label>
      <input type="date" class="form-control border border-info rounded" id="dateD" style="background: white; color: #3D4E62;">
    </div>
    <div class="form-group col-lg-3">
      <label for="dateDebut">Date fin</label>
      <input type="date" class="form-control border border-info rounded" id="dateF" style="background: white; color: #3D4E62;">
    </div>
    <div class="form-group col-md-3">
      <label for="zone">Zone</label>
      <select id="zone" class="form-control" style="background: white; color: #3D4E62; height: 50px;">
         <option selected>Choose...</option> 
        
         {{#state}}
            <option class="infosZone" id ="{{.}}">{{.}}</option>
         {{/state}}
      </select>
    </div>
    <div class="form-group col-md-3">
        <button type="button" class="btn btn-primary" class="form-control fa fa-paper-plane btn btn-primary rounded-pill" id="valider" style="margin-top: 32px;">visualiser</button>
    </div>
  </div>
</div>
<script src="Admin/js/zoneGeographiqueJS.js"></script>