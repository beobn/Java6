app.controller("roleController",function($scope, $http){
    let host="http://localhost:8080/rest/role";
    $scope.formadd = {}
    $scope.authoritys = {}
    $scope.roles = {}
	$scope.acs = {}
    $scope.load_all_role = function () {
      let url = `http://localhost:8080/rest/role/getall`;
      $http.get(url).then(resp => {
          $scope.roles = resp.data;
          console.log("success", resp)
      }).catch(error => {
          console.log("error", error)
      })
    }
 	$scope.load_all_account = function () {
      let url = `http://localhost:8080/rest/account/getall`;
      $http.get(url).then(resp => {
          $scope.acs = resp.data;
          console.log("success", resp)
      }).catch(error => {
          console.log("error", error)
      })
    }
	$scope.load_all_authoritys = function () {
      let url = `http://localhost:8080/rest/authority/getall`;
      $http.get(url).then(resp => {
          $scope.authoritys = resp.data;
          console.log("success", resp)
      }).catch(error => {
          console.log("error", error)
      })
    }
	$scope.authority_of=function(ac,role){
		for(var i = 0 ; i<$scope.authoritys.length;i++){
			if($scope.authoritys[i].account.username == ac.username){
				if($scope.authoritys[i].role.id == role.id){
					return true;
				}
			}
		}
	}
	$scope.deleteauthority=function(ac,role){
		var idd;
		for(var i = 0 ; i<$scope.authoritys.length;i++){
			if($scope.authoritys[i].account.username == ac.username){
				if($scope.authoritys[i].role.id == role.id){
					idd=$scope.authoritys[i].id
				}
			}
		}
		let url = `/rest/authority/delete/${idd}`;
			         $http.get(url).then(resp => {
			            authoritys.splice(i);
			            console.log("success", resp)
						swal.fire({
			              icon: 'success',
			              showConfirmButton: false,
			              title: 'Hủy Quyền Thành Công',
			              timer: 1000
			            })
			        }).catch(error => {
			            console.log("error", error)
						swal.fire({
			              icon: 'error',
			              showConfirmButton: false,
			              title: 'Phân Quyền Thất Bại',
			              timer: 1000
			            })
			        })
		
	}
	$scope.changauthority=function(ac,role){
		let url = '/rest/authority/change';
		authority ={account:ac,role:role}
		$http.post(url, authority).then(resp => {
            console.log("Success", resp)
            swal.fire({
              icon: 'success',
              showConfirmButton: false,
              title: 'Phân Quyền Thành Công',
              timer: 1000
            })
        }).catch(error => {
            console.log("error", error)
            swal.fire({
              icon: 'error',
              showConfirmButton: false,
              title: 'Phân Quyền Thất Bại',
              timer: 1000
            })
        })
      }
	$scope.changed=function(ac,role){
		var authority = $scope.authority_of(ac,role);
		if(authority==true){
			var idd;
		for(var i = 0 ; i<$scope.authoritys.length;i++){
			if($scope.authoritys[i].account.username == ac.username){
				if($scope.authoritys[i].role.id == role.id){
					idd=$scope.authoritys[i].id
				}
			}
		}
		let url = `/rest/authority/delete/${idd}`;
			         $http.get(url).then(resp => {
			            authoritys.splice(i);
			            console.log("success", resp)
						swal.fire({
			              icon: 'success',
			              showConfirmButton: false,
			              title: 'Hủy Quyền Thành Công',
			              timer: 1000
			            })
			        }).catch(error => {
			            console.log("error", error)
						swal.fire({
			              icon: 'error',
			              showConfirmButton: false,
			              title: 'Phân Quyền Thất Bại',
			              timer: 1000
			            })
			        })
		
			
		}else{
			let url = '/rest/authority/change';
		authority ={account:ac,role:role}
		$http.post(url, authority).then(resp => {
            console.log("Success", resp)
            swal.fire({
              icon: 'success',
              showConfirmButton: false,
              title: 'Phân Quyền Thành Công',
              timer: 1000
            })
        }).catch(error => {
            console.log("error", error)
            swal.fire({
              icon: 'error',
              showConfirmButton: false,
              title: 'Phân Quyền Thất Bại',
              timer: 1000
            })
        })
			
		}
	}
   /*
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
    }*/
    $scope.load_all_role();
	$scope.load_all_account();
	$scope.load_all_authoritys();
})