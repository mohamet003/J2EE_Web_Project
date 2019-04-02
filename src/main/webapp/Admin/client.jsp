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
                            <th scope="col">PRIX</th>
                            <th scope="col">QUANTITE</th>
                            <th scope="col">DATE EXPIRATION</th>
                            <th scope="col">&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row"><input type="checkbox" /></th>
                            <td class="tm-product-name">Lorem Ipsum Product 5</td>
                            <td>1,800</td>
                            <td>200</td>
                            <td>22 Feb 2019</td>
                            <td>
                                <a href="#" class="tm-product-delete-link">
                                    <i class="fas fa-chart-area" style="color:orange"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><input type="checkbox" /></th>
                            <td class="tm-product-name">Lorem Ipsum Product 11</td>
                            <td>2,000</td>
                            <td>400</td>
                            <td>21 Jan 2019</td>
                            <td>
                                <a href="#" class="tm-product-delete-link">
                                    <i class="fas fa-chart-area" style="color:orange"></i>
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- table container -->
        </div>
    </div>
</div>