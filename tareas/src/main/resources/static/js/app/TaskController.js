'use strict'
var module = angular.module('tasks.controllers', []);
    module.controller("TaskController", ["$scope", "TaskService",
    function($scope, TaskService) {
        $scope.taskDto = {
            id: null,
            description: null,
            status:null
        };

        //$scope.status = [];

        $scope.saveTask = function() {
            if ($scope.taskDto.description == null ||  $scope.taskDto.description === ''){
                var div = document.getElementById('messageDiv');
                div.innerHTML += taskLabels.descriptionNoEmpty;
                setTimeout(function () {
                    div.innerHTML = '';
                },5000);
            } else {
                TaskService.saveTask($scope.taskDto).then(function () {
                    console.log("works");
                    TaskService.getAllTasks().then(function (value) {
                        $scope.allTasks = value.data;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                    $scope.taskDto = {
                        id: null,
                        description: null,
                        statusDto: null
                    };
                }, function (reason) {
                    console.log("error occured");
                }, function (value) {
                    console.log("no callback");
                });
            }
        }
        $scope.updateTask = function(task) {
            if (task.description == null ||  task.description === ''){
                var div = document.getElementById('messageDiv');
                div.innerHTML += taskLabels.descriptionNoEmpty;
                setTimeout(function () {
                    div.innerHTML = '';
                },5000);
            } else {
                var e = document.getElementById("select#" + task.id);
                var newStatus = e.options [e.selectedIndex].value;
                task.status = newStatus;
                TaskService.updateTask(task).then(function () {
                    console.log("works");
                    TaskService.getAllTasks().then(function (value) {
                        $scope.allTasks = value.data;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                    $scope.taskDto = {
                        id: null,
                        description: null,
                        statusDto: null
                    };
                }, function (reason) {
                    console.log("error occured");
                }, function (value) {
                    console.log("no callback");
                });
            }
        }
        $scope.deleteTask = function(taskId) {
            if(confirm(taskLabels.deleteTask)) {
                TaskService.deleteTask(taskId).then(function () {
                    console.log("works");
                    TaskService.getAllTasks().then(function (value) {
                        $scope.allTasks = value.data;
                    }, function (reason) {
                        console.log("error occured");
                    }, function (value) {
                        console.log("no callback");
                    });
                    $scope.taskDto = {
                        id: null,
                        description: null,
                        statusDto: null
                    };
                }, function (reason) {
                    console.log("error occured");
                }, function (value) {
                    console.log("no callback");
                });
            }
        }
        $scope.taskLabels = taskLabels;
        $scope.statusList = [{
            id: 0,
            description: taskLabels.inPortfolio,
        }, {
            id: 1,
            description: taskLabels.inProgress,
        }, {
            id: 2,
            description: taskLabels.finished,
        }];

        //$scope.statusSelected = $scope.statusList[0];
        var init = function () {
            TaskService.getAllTasks().then(function(value) {
                $scope.allTasks = value.data;
            });
        };

        init();
    }
]);