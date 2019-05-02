'use strict'

var app = angular.module("cardModule", []);

app.controller("card", function($scope, $http) {

    $scope.cardDto = [];

    $scope.cardUpdate = 0;

    $scope.textError = "";

    $scope.number4 = "";
    $scope.number8 = "";
    $scope.number12 = "";
    $scope.number16 = "";

    $scope.customerIdObject = decodeURIComponent(location.search.substring(1).split('&')[0]);
    $scope.customerNameObject = decodeURIComponent(location.search.substring(1).split('&')[1]);

    $scope.customerName = $scope.customerNameObject.substring(1).split('=')[1];

    $scope.customerId = $scope.customerIdObject.substring(1).split('=')[1];

    refreshCardData($scope.customerId);

    $scope.save = function() {

        $scope.textError = "";

        var url = '/card/save';

        if ($scope.cardUpdate === 1) {
            url = '/card/update';
        }

        $scope.cardDto.number = $scope.number4 + "" + $scope.number8 + "" + $scope.number12 + "" + $scope.number16;

        if(validations($scope.cardDto)) {
            $scope.textError = "Por favor ingrese de manera correcta los datos";
            return false;
        }

        $http({
            method: "POST",
            url: url,
            data: {
                number: $scope.cardDto.number,
                ccv: $scope.cardDto.ccv,
                type: $scope.cardDto.type,
                customerIdentification: $scope.customerId
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.delete = function(card) {

        $http({
            method: "POST",
            url: '/card/delete',
            data: {
                number: card.number,
                ccv: card.ccv,
                type: $card.type,
                customerIdentification: $scope.customerId
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.edit = function(card) {

        $scope.number4 = card.number.substring(3);
        $scope.number8 = card.number.substring(7);
        $scope.number12 = card.number.substring(11);
        $scope.number16 = card.number.substring(15);
        $scope.cardDto.ccv = card.ccv;
        $scope.cardDto.type = card.type;
        $scope.cardUpdate = 1;
        $scope.textError = "";
    };

    function refreshCardData(customerId) {
        $http({
            method: 'POST',
            url: '/card/list',
            data: customerId
        }).then(
            function(allCard) {
                $scope.allCard = allCard.data;
            }, error
        );
    }

    function success() {
        refreshCardData($scope.customerId);
        clearFormData();
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
        //alert("Error: " + status + ":" + data);
        $scope.textError = "Ocurrio un error " + data;
    }

    function clearFormData() {
        $scope.cardDto.number = "";
        $scope.cardDto.ccv = "";
        $scope.cardDto.type = "";

        $scope.number4 = "";
        $scope.number8 = "";
        $scope.number12 = "";
        $scope.number16 = "";

        $scope.textError = "";

    };

    function validations(card) {

        var number = /^([0-9])*$/;
        var letters = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/;

        if (!number.test(card.number)) {
            return true;
        }

        if (!number.test(card.ccv)) {
            return true;
        }

        if (!letters.test(card.type)) {
            return true;
        }
    };
});