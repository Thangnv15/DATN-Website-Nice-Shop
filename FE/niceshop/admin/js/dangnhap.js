myapp.controller("loginAdmin-ctrl",function($scope, $http,$filter){
    $scope.account = [];
    $scope.roles = [];

    //khời tạo hiển thị ban đầu 
    $http.get("http://localhost:8080/api/taikhoan")
        .then(function(response){
            //Gán dữ liệu trả về từ API vào biến $scope.accounts
            $scope.account = response.data;
        },function(error){
            console.error('lỗi quá trình gọi API TaiKhoan',error);
        });

    //lấy danh sách vai trò 
    $http.get("http://localhost:8080/api/vaitro")
        .then(function(response){
            $scope.roles = response.data;
        }, function(error){
            console.error('Lỗi quá trình gọi API VaiTro',error);
        });
        $scope.login - function(){
            var inputEmail = $scope.us
        }
})