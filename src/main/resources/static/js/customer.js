'use strict'

var app = angular.module("testIbm", []);

// Controller Part
app.controller("customer", function($scope, $http) {

    $scope.customerDto = [];
    $scope.customerForm = {
        identification: "",
        name: "",
        addres: "",
        city: "",
        telephone: ""
    };

    refreshCustomerData();


    $scope.save = function() {
        var method = "";
        var url = "";

        method = "POST";
        url = '/customer/save';



        $http({
            method: method,
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

    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employee/' + employee.empId
        }).then(_success, _error);
    };

    $scope.editCustomer = function(employee) {
        $scope.customerDto.identification = employee.identification;
        $scope.customerDto.name = employee.name;
        $scope.customerDto.address = employee.address;
    };

    function refreshCustomerData() {
        $http({
            method: 'GET',
            url: '/customer/list'
        }).then(
            function(res) { // success
                $scope.customerDto = res.data;
                $scope.allCustomer = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function success(res) {
        refreshCustomerData();
        clearFormData();
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function clearFormData() {
        $scope.customerForm.identification="";
        $scope.customerForm.name= "";
        $scope.customerForm.addres= "";
        $scope.customerForm.city= "";
        $scope.customerForm.telephone= "";

    };
});