'use strict'

var app = angular.module("transactionModule", []);

app.controller("transaction", function($scope, $http) {

    $scope.transactionDto = [];
    $scope.allCardByCustomer = [];

    $scope.date = {
        value: new Date()
    };

    $scope.transactionUpdate = 0;

    $scope.textError = "";
    $scope.selectedCardNumber = "";

    $scope.customerIdObject = decodeURIComponent(location.search.substring(1).split('&')[0]);
    $scope.customerNameObject = decodeURIComponent(location.search.substring(1).split('&')[1]);

    $scope.customerName = $scope.customerNameObject.substring(1).split('=')[1];

    $scope.customerId = $scope.customerIdObject.substring(1).split('=')[1];

    refreshTransactionData($scope.customerId);
    getCards($scope.customerId);

    $scope.save = function() {

        var url = '/transaction/save';

        if ($scope.transactionUpdate === 1) {
            url = '/transaction/update';
        }

        $scope.transactionDto.cardNumber = $scope.selectedCardNumber;
        $scope.transactionDto.date = $scope.date.value;

        $http({
            method: "POST",
            url: url,
            data: {
                id: $scope.transactionDto.id,
                date: $scope.transactionDto.date,
                description: $scope.transactionDto.description,
                amount: $scope.transactionDto.amount,
                cardNumber: $scope.transactionDto.cardNumber
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.delete = function(transaction) {

        transaction.cardNumber = $scope.selectedCardNumber;
        transaction.date = $scope.date.value;

        $http({
            method: "POST",
            url: '/transaction/delete',
            data: {
                id: transaction.id,
                date: transaction.date,
                description: transaction.description,
                amount: transaction.amount,
                cardNumber: transaction.cardNumber
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.edit = function(transaction) {

        $scope.transactionDto.id = transaction.id;
        $scope.transactionDto.date = transaction.date;
        $scope.transactionDto.description = transaction.description;
        $scope.transactionDto.amount = transaction.amount;
        $scope.transactionDto.cardNumber = transaction.cardNumber;
        $scope.selectedCardNumber = transaction.cardNumber;
        $scope.transactionUpdate = 1;
        $scope.date = {
            value: transaction.date
        };
    };

    function refreshTransactionData(customerId) {
        $http({
            method: 'POST',
            url: '/transaction/list-by-customer',
            data: customerId
        }).then(
            function(allTransaction) {
                $scope.allTransaction = allTransaction.data;
            }, error
        );
    }

    function success() {
        refreshTransactionData($scope.customerId);
        clearFormData();
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
        //alert("Error: " + status + ":" + data);
        $scope.textError = "Ocurrio un error " + data;
    }

    function clearFormData() {
        $scope.transactionDto.id = "";
        $scope.transactionDto.date = "";
        $scope.transactionDto.description = "";
        $scope.transactionDto.amount = "";
        $scope.transactionDto.cardNumber = "";
        $scope.selectedCardNumber = "";
        $scope.date = {
            value: new Date()
        };

    };

    function getCards(customerId) {
        $http({
            method: 'POST',
            url: '/card/list',
            data: customerId
        }).then(
            function(allCard) {
                $scope.allCardByCustomer = allCard.data;
            }, error
        );
    }
});