<%-- 
    Document   : products
    Created on : 8 mars 2019, 16:05:23
    Author     : mohametkone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <div class="product-top">
        {{#products}}  
        <div class="product-one">

            {{#.}}  

            <div class="col-md-3 product-left">
                <div class="product-main simpleCart_shelfItem">
                    <a href="#" lass="mask"  ><img class="img-responsive zoom-img single" data-idproduct="{{product_ID}}" src="client/images/p-1.png" alt="" /></a>
                    <div class="product-bottom">
                        <h3>{{ description }}</h3>
                        <p>Explore Now</p>
                        <h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">{{ purchase_cost }} €</span></h4>
                    </div>
                    <div class="srch">
                        <span>-50%</span>
                    </div>
                </div>
            </div>
            {{/.}} 

            <div class="clearfix"></div>
        </div>
        <br>
        {{/products}}
    </div>
</div>











<script>
    // Afficher un produit


    function showSingleProduct() {

        let id = $(this).data("idproduct");
        
        
        
        $.ajax({
            url: "SingleProductController?idProduct=" + id,
            dataType: "json",
            success: function (result) {

                $.get("client/single.jsp", function (template) {
                    console.log(result);
                    var processedTemplate = Mustache.to_html(template, result);
                    $("#globalContainer").hide();
                    $('#container').html(processedTemplate);
                });
            }
        });
    }


    $(".single").click(showSingleProduct);

</script>