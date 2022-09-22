angular.module('front-app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8082/app/';


    $http.get(contextPath + 'v1/categories')
        .then(function (response){
            $scope.categories = response.data;
        })


    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'v1/products',
            method: 'GET',
            params: {
                pageIndex: pageIndex
            }
        }).then(function (response) {
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
        });
    };

    $scope.showInfo = function (product) {
        alert(product.title);
    };

    $scope.delete = function (product) {
        let id = product.id;
        $http({
            url: contextPath + 'v1/products/delete/' + id,
            method: 'GET',

        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.createNewProduct =function (){

        $http.post(contextPath + 'v1/products',  $scope.new_product)
            .then(function successCallback (response) {
            $scope.loadProducts();
            $scope.new_product = null;
        }, function failureCallback (response) {
            console.log(response);
            alert(response.data.messages);
        });
        console.log($scope.new_product);
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.loadProducts();
});
