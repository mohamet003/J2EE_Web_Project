<%-- 
    Document   : products
    Created on : 8 mars 2019, 16:05:23
    Author     : mohametkone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br><br>
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="LoginController">Menu Principal</a></li>
					<li class="active">Products</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
        
<br><br>
<div class="container">
    <div class="product-top">
        {{#products}}  
        <div class="product-one">

            {{#.}}  

            <div class="col-md-3 product-left" data-qte="{{ quantity_on_hand }}" >
                <div class="product-main simpleCart_shelfItem">
                    <a href="#" lass="mask"  ><img class="img-responsive zoom-img single" data-idproduct="{{product_ID}}" data-rate="{{rate}}" src="client/images/p-1.png" alt="" /></a>
                    <div class="product-bottom">
                        <h3>{{ description }}</h3>
                        <p>Explore Now</p>
                        <h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">{{ purchase_cost }} €</span></h4>
                    </div>
                    <div class="srch" data-id="{{product_ID}}">
                        <span>REMISE -{{rate}}%</span>
                    </div>
                </div>
            </div>
            {{/.}} 
            


            <div class="clearfix"></div>
        </div>
        <br>
        {{/products}}
        
        {{^products.length}}
        <h1>Produit(s) Non Disponible</h1>
        {{/products.length}}
    </div>
</div>











<script>
    // Afficher un produit


    function showSingleProduct() {

        let id = $(this).data("idproduct");
        let rate = $(this).data("rate");
        
        
        $.ajax({
            url: "SingleProductController?idProduct="+id+"&rate="+rate,
            dataType: "json",
            success: function (data) {
                    console.log("tata "+ data);
                $.get("client/single.jsp", function (template) {
                    data["txt_btn"]= "Commander"; 
                    data["txt_alert"]= "Votre Commande a bien été enrégistrée !";
                    data["qte"]= 1;
                    data["action"]= "purchase";
                    //console.log(data);
                    var processedTemplate = Mustache.to_html(template, data);
                    $("#globalContainer").hide();
                    $('#container').html(processedTemplate);
                });
            }
        });
    }
var tab = $(".product-left");


for (var i = 0, max = 10; i < tab.size(); i++) {
    
    let qte = tab.eq(i).data("qte");
    
    if (qte === 0) {
        
        tab.eq(i).find("div:last").removeClass("srch");     
        tab.eq(i).find("div:last").html("<span> En rupture </span>");
        tab.eq(i).find("div:last").addClass("srchR");
        tab.eq(i).removeClass("product-left");
        tab.eq(i).addClass("product-left-rupture");
        
        
    }
}


    $(".single").click(showSingleProduct);

</script>