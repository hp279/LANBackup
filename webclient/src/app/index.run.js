(function () {
  'use strict';

  angular
    .module('app')
    .run(['$rootScope',  '$state', '$cookieStore', '$http', runBlock]);

  function runBlock($rootScope, $state, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
      $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }

    $rootScope.$on('$stateChangeStart',
      function(event, toState, toParams, fromState, fromParams, options){
        console.log(toState);
        // redirect to login page if not logged in
        if (toState.name !== 'login' && !$rootScope.globals.currentUser) {
          event.preventDefault();

          // transitionTo() promise will be rejected with
          // a 'transition prevented' error

          $state.go('login');
        }
      })
  }

})();
