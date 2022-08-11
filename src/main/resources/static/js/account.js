app.controller("accountController",function($scope, $http){
    let host="http://localhost:8080/rest/account";
    $scope.formadd = {}
    $scope.dataedit = {}
    $scope.items = {}
    $scope.load_all = function () {
      let url = `${host}/getall`;
      $http.get(url).then(resp => {
          $scope.items = resp.data;
          console.log("success", resp)
      }).catch(error => {
          console.log("error", error)
          console.log("1");
      })
    }
    $scope.create = function () {
        let item = angular.copy($scope.formadd);
        let url = `${host}/add`;
        $http.post(url, item).then(resp => {
            var key = resp.data.username;
            $scope.items[key] = item;
            console.log("Success", resp)
            $scope.load_all();
            swal.fire({
              icon: 'success',
              showConfirmButton: false,
              title: 'Thêm Mới Thành Công',
              timer: 1000
            })
        }).catch(error => {
            console.log("error", error)
            swal.fire({
              icon: 'error',
              showConfirmButton: false,
              title: 'Thêm Mới Thất Bại',
              timer: 1000
            })
        })
      }
      $scope.formedit = function (id) {
        let url = `${host}/edit/${$scope.items[id].username}`;
        $http.get(url).then(resp => {
            $scope.dataedit = resp.data;
            console.log("success", resp)
        }).catch(error => {
            console.log("error", error)
        })
    }
    $scope.update = function () {
        let item = angular.copy($scope.dataedit);
        let url = `${host}/add`;
       
        $http.put(url, item).then(resp => {
            var index = $scope.items.findIndex(item=> item.username === $scope.dataedit.username);
            $scope.items[index] = resp.data;
            console.log("Success", resp)
            swal.fire({
              icon: 'success',
              showConfirmButton: false,
              title: 'Cập Nhật Thành Công',
              timer: 1000
            })
        }).catch(error => {
            console.log("error", error)
            swal.fire({
              icon: 'error',
              showConfirmButton: false,
              title: 'Cập Nhật Thất Bại',
              timer: 1000
            })
        })
      }
      $scope.delete = function (id) {
        console.log("da vao delete")
        let url = `${host}/delete/${$scope.items[id].username}`;
        $http.get(url).then(resp => {
            $scope.load_all();
            console.log("success", resp)
            swal.fire({
                icon: 'success',
                showConfirmButton: false,
                title: 'Xóa Thành Công',
                timer: 1000
              })
        }).catch(error => {
            swal.fire({
                icon: 'error',
                showConfirmButton: false,
                title: 'Xóa Thất Bại',
                timer: 1000
              })
            console.log("error", error)
        })
    }
    $scope.load_all();
})