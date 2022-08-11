

var app = angular.module("myAppp", ["ngRoute"]);

app.config(function ($routeProvider) {
  console.log("davaomyAPP")
  $routeProvider
    .when("/login", {
      templateUrl: "/view/auth/login.html"
    })
    .when("/logup", {
      templateUrl: "/view/auth/logup.html"
    })
	.when("/home", {
      templateUrl: "/view/product/demo.html"
    })

});
app.controller("loginCtrl", function ($scope) {
    console.log("hihihihaaa")
    $scope.message = function (message) {
        if(message=='Đăng Nhập Thành Công'){
            swal.fire({
                icon: 'success',
                showConfirmButton: false,
                title: 'Thêm Mới Thành Công',
                timer: 1000
              })
        }else{
            swal.fire({
                icon: 'error',
                showConfirmButton: false,
                title: 'Tài khoản hoặc mật khẩu không chính xác',
                timer: 1000
              })
        }
    }
  });