<%-- 
    Document   : graphiques
    Created on : 29 mars 2019, 16:57:59
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <br/><br/>
<div class="row">
    <div id="chart1" class="col-lg-11"></div>
    <div class="col-lg-1 btn btn-group-vertical" role="group" aria-label="First group">
        <a id="botChange" class="tm-product-delete-link" style="background: #3D4E62; margin-left: -16px" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            <i id="imagine" class="fas fa-plus" style="color:white"></i>
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
    <div class="form-group col-lg-3">
      <label for="dateFin">Date début</label>
      <input type="date" class="form-control border border-info rounded" id="dateD" style="background: white; color: #3D4E62;">
    </div>
    <div class="form-group col-lg-3">
      <label for="dateDebut">Date fin</label>
      <input type="date" class="form-control border border-info rounded" id="dateF" style="background: white; color: #3D4E62;">
    </div>
    <div class="form-group col-lg-3">
      <label for="categorie">Catégorie</label>
      <select id="categorie" class="form-control" style="background: white; color: #3D4E62; height: 50px;">
         <option selected>Choose...</option>
        {{#categorys}}
        <option class="infosCat" id="{{Prod_Code}}">{{description}}</option>
        {{/categorys}}
      </select>
    </div>
    <div class="form-group col-lg-3">
        <button type="button" class="btn btn-primary" class="form-control fa fa-paper-plane btn btn-primary rounded-pill" id="valider" style="color: white; margin-top: 32px;">visualiser</button>
    </div>
  </div>
</div>
<script src="Admin/js/graphiques.js"></script>