angular.module('front-app').controller('editProductController', function ($scope, $http, $routeParams, $location) {

    const contextPath = 'http://localhost:8082/app/';

    $http.get(contextPath + 'v1/categories')
        .then(function (response){
            $scope.categories = response.data;
        })

    $scope.prepareProductForUpdate = function () {
        $http({
            url: contextPath + 'v1/products/' + $routeParams.productId,
            method: 'GET',
            }).then(function successCallback(response) {
                $scope.updated_product = response.data;
            }, function failureCallback (response) {
               alert(response.data.messages);
               $location.path('/products');
        });
    };

    $scope.updateProduct =function (){

        $http.put(contextPath + 'v1/products',  $scope.updated_product)
            .then(function successCallback (response) {
                $scope.updated_product = null;
                alert("Продукт обновлен");
                $location.path('/products');
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.messages);
            });
    }

    $scope.prepareProductForUpdate()

});
