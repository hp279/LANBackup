(function () {
  'use strict';

  angular
    .module('app')
    .config(routerConfig);

  /** @ngInject */
  function routerConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('app', {
        abstract: true,
        templateUrl: 'app/navbar/body.html',
        controller: 'NavBarController',
        controllerAs: 'ctrl'
      })
      .state('app.home', {
        url: '/',
        views: {
          'main': {
            templateUrl: 'app/main/body.html',
            controller: 'MainController',
            controllerAs: 'ctrl'
          }
        }
      })
      .state('app.backup-configuration', {
        url: '/backup-configuration',
        views: {
          'main': {
            templateUrl: 'app/backup-configuration/body.html',
            controller: 'BackupConfigurationController',
            controllerAs: 'ctrl'
          }
        },
        resolve: {
          initClients: ['Client', function (Client) {
            return Client.query().$promise;
          }]
        }
      })
      .state('app.activity-logs', {
        url: '/activity-logs',
        views: {
          'main': {
            templateUrl: 'app/activity-logs/body.html',
            controller: 'ActivityLogsController',
            controllerAs: 'ctrl'
          }
        }
      })

    $urlRouterProvider.otherwise('/');
  }

})();


