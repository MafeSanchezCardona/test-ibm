'use strict'

var app = angular.module("customerModule", []);

app.controller("customer", function($scope, $http) {

    $scope.customerDto = [];

    $scope.customerUpdate = 0;

    $scope.textError = "";

    refreshCustomerData();

    $scope.save = function() {

        $scope.textError = "";

        var url = '/customer/save';

        if ($scope.customerUpdate === 1) {
            url = '/customer/update';
        }

        if(validations($scope.customerDto)) {
            $scope.textError = "Por favor ingrese de manera correcta los datos";
            return false;
        }

        $http({
            method: "POST",
            url: url,
            data: {
                identification: $scope.customerDto.identification,
                name: $scope.customerDto.name,
                address: $scope.customerDto.address,
                city: $scope.customerDto.city,
                telephone: $scope.customerDto.telephone
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.delete = function(customer) {
        $http({
            method: "POST",
            url: '/customer/delete',
            data: {
                identification: customer.identification,
                name: customer.name,
                address: customer.address,
                city: customer.city,
                telephone: customer.telephone
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.edit = function(customer) {
        $scope.customerDto.identification = customer.identification;
        $scope.customerDto.name = customer.name;
        $scope.customerDto.address = customer.address;
        $scope.customerDto.city = customer.city;
        $scope.customerDto.telephone = customer.telephone;
        $scope.customerUpdate = 1;
        $scope.textError = "";
    };

    function refreshCustomerData() {
        $http({
            method: 'GET',
            url: '/customer/list'
        }).then(
            function(allCustomer) {
                $scope.allCustomer = allCustomer.data;
            }, error
        );
    }

    function success() {
        refreshCustomerData();
        clearFormData();
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
        //alert("Error: " + status + ":" + data);
        $scope.textError = "Ocurrio un error " + data;
    }

    function clearFormData() {
        $scope.customerDto.identification ="";
        $scope.customerDto.name = "";
        $scope.customerDto.address = "";
        $scope.customerDto.city = "";
        $scope.customerDto.telephone = "";
        $scope.customerUpdate = 0;
        $scope.textError = "";

    };

    $scope.getCards = function(customer) {
        var url = '/card/load?customerId =' + customer.identification + '&customerName =' + customer.name;
        window.open(url, "_blank");
    };

    $scope.getTransaction = function(customer) {
        var url = '/transaction/load?customerId =' + customer.identification + '&customerName =' + customer.name;
        window.open(url, "_blank");
    };

    function validations(customer) {

        var number = /^([0-9])*$/;
        var letters = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+$/;

        if (!number.test(customer.identification)) {
            return true;
        }

        if (!number.test(customer.telephone)) {
            return true;
        }

        if (!letters.test(customer.name)) {
            return true;
        }
    };

});