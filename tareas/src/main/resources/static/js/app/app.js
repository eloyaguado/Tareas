'use strict'
var taskApp = angular.module('tasks', ['ui.bootstrap', 'tasks.controllers',
    'tasks.services'
]);
taskApp.constant("CONSTANTS", {
    getTaskById: "/task/getTaskById/",
    getAllTasks: "/task/getAllTasks",
    saveTask: "/task/saveTask",
    updateTask: "/task/updateTask",
    deleteTask: "/task/deleteTask"
});