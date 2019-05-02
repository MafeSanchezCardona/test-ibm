'use strict'

var app = angular.module("AdviserModule", []);

app.controller("adviser", function($scope, $http) {

    $scope.adviserDto = [];

    $scope.adviserUpdate = 0;

    $scope.textError = "";

    refreshAdviserData();

    $scope.save = function() {

        var url = '/adviser/save';

        if ($scope.adviserUpdate === 1) {
            url = '/adviser/update';
        }

        $http({
            method: "POST",
            url: url,
            data: {
                identification: $scope.adviserDto.identification,
                name: $scope.adviserDto.name,
                specialty: $scope.adviserDto.specialty
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.delete = function(adviser) {
        $http({
            method: "POST",
            url: '/adviser/delete',
            data: {
                identification: adviser.identification,
                name: adviser.name,
                specialty: adviser.specialty
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
    };

    $scope.edit = function(adviser) {
        $scope.adviserDto.identification = adviser.identification;
        $scope.adviserDto.name = adviser.name;
        $scope.adviserDto.specialty = adviser.specialty;
        $scope.adviserUpdate = 1;
    };

    function refreshAdviserData() {
        $http({
            method: 'GET',
            url: '/adviser/list'
        }).then(
            function(listAdviser) {
                $scope.allAdviser = listAdviser.data;
            }, error
        );
    }

    function success() {
        refreshAdviserData();
        clearFormData();
    }

    function error(res) {
        var data = res.data;
        var status = res.status;
        //alert("Error: " + status + ":" + data);
        $scope.textError = "Ocurrio un error " + data;
    }

    function clearFormData() {
        $scope.adviserDto.identification ="";
        $scope.adviserDto.name = "";
        $scope.adviserDto.specialty = "";

    };
});