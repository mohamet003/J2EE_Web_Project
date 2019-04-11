<%-- 
    Document   : graphique2
    Created on : 4 avr. 2019, 13:27:13
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
<div class="row">
    <div class="col">
        <br/><br/>
    </div>
    
    <!-- row -->
        <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 ">
           
                <div id="chart"></div>
           
        </div>
</div><br/>
<div>
    <div class="col-lg-2 btn" role="group" aria-label="First group">
        <a href="#" id="graph1" class="tm-product-delete-link" style="background: #3D4E62;">
            <i class="fas fa-chart-area" style="color:white"></i>
        </a>
        <a href="#" id="graph2" class="tm-product-delete-link" style="background: #3D4E62;">
            <i class="fas fa-chart-area" style="color:white"></i>
        </a>
        <a href="#" id="graph3" class="tm-product-delete-link" style="background: #3D4E62;">
            <i class="fas fa-chart-area" style="color:white"></i>
        </a>
        <a href="#" id="graph4" class="tm-product-delete-link" style="background: #3D4E62;">
            <i class="fas fa-chart-area" style="color:white"></i>
        </a>
    </div>
</div><br/><br/>
  <div class="form-row">
    <div class="form-group col-md-3">
      <label for="dateFin">Date début</label>
      <input type="text" class="form-control" id="dateFin" style="background: white; color: #3D4E62; border-bottom: solid 1px #3D4E62; ">
    </div>
    <div class="form-group col-md-3">
      <label for="dateDebut">Date fin</label>
      <input type="text" class="form-control" id="dateDebut" style="background: white; color: #3D4E62; border-bottom: solid 1px #3D4E62; ">
    </div>
    <div class="form-group col-md-3">
      <label for="categorie">Catégorie</label>
      <select id="categorie" class="form-control" style="background: white; color: #3D4E62; border-bottom: solid 1px #3D4E62;">
         <option selected>Choose...</option> 
        
         {{#state}}
            <option class="infosZone" id ="{{.}}">{{.}}</option>
         {{/state}}
      </select>
    </div>
    <div class="form-group col-md-3">
        <button type="button" class="btn btn-primary" class="form-control" style="margin-top: 32px;">visualiser</button>
    </div>
  </div>
</div>
<script src="Admin/js/zoneGeoJS.js"></script>