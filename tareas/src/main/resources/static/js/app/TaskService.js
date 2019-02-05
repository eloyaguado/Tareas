'use strict'
angular.module('tasks.services', []).factory('TaskService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getTaskById = function(taskId) {
        var url = CONSTANTS.getTaskById + taskId;
        return $http.get(url);
    }
    service.getAllTasks = function() {
        return $http.get(CONSTANTS.getAllTasks);
    }
    service.saveTask = function(taskDto) {
        return $http.post(CONSTANTS.saveTask, taskDto);
    }
    service.updateTask = function(taskDto) {
        return $http.post(CONSTANTS.updateTask, taskDto);
    }
    service.deleteTask = function(taskId) {
        return $http.post(CONSTANTS.deleteTask, taskId);
    }
    return service;
}]);