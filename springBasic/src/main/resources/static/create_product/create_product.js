angular.module('front-app').controller('createProductController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8082/app/';

    $http.get(contextPath + 'v1/categories')
        .then(function (response){
            $scope.categories = response.data;
        })

    $scope.createNewProduct =function (){

        if ($scope.new_product == null) {
            alert('Форма не заполнена');
            return;
        }

        $http.post(contextPath + 'v1/products',  $scope.new_product)
            .then(function successCallback (response) {
               $scope.new_product = null;
                alert("Продукт создан");
                $location.path('/products');
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.messages);
            });
    }

});
