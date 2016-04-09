(function() {
  'use strict';

  angular
    .module('app',
      [
        'ngAnimate',
        'ngCookies',
        'ngTouch',
        'ngSanitize',
        'ngMessages',
        'ngAria',
        'ngResource',
        'ui.router',
        'ui.bootstrap',
        'toastr',
        'angular.filter',
        'infinite-scroll',

        'app.components',
        'app.dataservices',
        'app.directives',
        'app.constants',
        'app.filters',
        'app.backup-configuration',
        'app.activity-logs'
      ]);

})();
