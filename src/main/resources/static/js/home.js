
var app = angular.module("myApp", ["ngRoute"]);

app.config(function ($routeProvider) {
  console.log("davaomyAPP")
  $routeProvider
   

	.when("/account", {
      templateUrl: "/view/page/account.html",
		controller: "accountController"
    })
    .when("/product", {
      templateUrl: "/view/page/product.html",
		controller: "productController"
    })
    .when("/cate", {
      templateUrl: "/view/page/category.html",
		controller: "cateController"
    })
	.when("/authozire", {
      templateUrl: "/view/page/role.html",
		controller: "roleController"
    })

});
