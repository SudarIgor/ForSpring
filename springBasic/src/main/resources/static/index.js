angular.module('front-app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8082/app/';


    // $http.get('http://localhost:8082/app/products/1')
    //     .then(function (response){
    //         $scope.product = response.data;
    //     })


    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                pageIndex: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.pages = response.data.totalPages;
            $scope.pageNumber = response.data.number + 1;

        });
    };

    $scope.showInfo = function (product) {
        alert(product.title);
    };

    $scope.delete = function (product) {
        let id = product.id;
        $http({
            url: contextPath + 'products/delete/' + id,
            method: 'GET',

        }).then(function (response) {
            $scope.loadProducts();
        });
    };


    $scope.loadProducts(2);
});
