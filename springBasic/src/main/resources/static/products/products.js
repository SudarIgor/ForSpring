angular.module('front-app').controller('productsController', function ($scope, $http, $location) {

    const contextPath = 'http://localhost:8082/app/';
    let currentPageIndex = 1;

    $scope.loadProducts = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
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

    $scope.delete = function (product) {
        let id = product.id;
        $http({
            url: contextPath + 'v1/products/' + id,
            method: 'DELETE',

        }).then(function (response) {
            $scope.loadProducts(currentPageIndex);
            console.log(currentPageIndex);
        });
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.navToEditProductPage = function (productId) {
        $location.path('/edit_product/' + productId);
    }

    $scope.loadProducts();
});
