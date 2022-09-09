angular.module('front-app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    // $scope.loadProducts = function () {
    //     $http.get(contextPath + 'products')
    //         .then(function (response) {
    //             console.log(response);
    //             $scope.productsPage = response.data;
    //         });
    // };

    $http.get('http://localhost:8082/app/products/json/1')
        .then(function (response){
            $scope.product = response.data;
        })


    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
        });
    };

    $scope.showInfo = function (product) {
        alert(product.title);
    };

    // $scope.wrongRequest = function () {
    // WRONG:
    // $http.get(contextPath + 'products/update/1');
    // reload();

    // CORRECT
    // $http.get(contextPath + 'products/update/1')
    //     .then(function (response) {
    //         reload();
    //     });
    // }

    $scope.loadProducts(2);
});
