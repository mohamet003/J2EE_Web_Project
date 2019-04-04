<%-- 
    Document   : client
    Created on : 29 mars 2019, 16:56:44
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container mt-4">
    <div class="row">
        <div class="col">
          <p class="text-white mt-5 mb-5">Bienvenue, <b>Admin</b></p>
        </div>
    </div>
    <div class="row tm-content-row">
        <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
            <div class="tm-product-table-container">
                <table class="table table-hover tm-product-table">
                    <thead>
                        <tr>
                            <th scope="col">&nbsp;</th>
                            <th scope="col">NOM</th>
                            <th scope="col">EMAIL</th>
                            <th scope="col">ADRESSELINE1</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        {{#client}}
                        <tr>
                            <th scope="row"><input type="checkbox" /></th>
                            <td class="tm-product-name">{{name}}</td>
                            <td>{{email}}</td>
                            <td>{{addressLine1}}</td>
                            <td> 
                                <a href="#" class="tm-product-delete-link" data-toggle="modal" data-target="#exampleModal">
                                    <i class="fas fa-chart-area" style="color:white"></i>
                                </a>
                            </td>
                        </tr>
                        {{/client}}
                    </tbody>
                </table>
            </div>
            <!-- table container -->
        </div>
    </div>
</div>

<!-- insertion d'une classe modal -->

<div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style="max-width: 80%;">
    <div class="modal-content">
      <div class="modal-body">
          <button type="button" class="close" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
          </button>
          <div class="row">
                <div class="col-lg-10" id="myPieChart"></div>
                <div class="col-lg-2 btn btn-group-vertical" role="group" aria-label="First group">
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
          </div>
          <div>
              <div class="row">
                <div class="col">
                    <input type="text" class="form-control" placeholder="date debut" style="background: white; color: #3D4E62; border-bottom: solid 1px #3D4E62; " >
                </div>
                  <div class="col">
                    <input type="text" class="form-control" placeholder="date fin" style="background: white; color: #3D4E62; border-bottom: solid 1px #3D4E62; ">
                </div>
                <div class="col">
                    <button type="button" class="btn" class="form-control" style="background: #3D4E62; color: white;">visualiser</button>
                </div>
              </div>
          </div>
      </div>
    </div>
  </div>
</div>
<script src="Admin/js/graphiqueUser.js"></script>