(function () {
  'use strict';

  angular
    .module('app')
    .controller('NavBarController', NavBarController);

  /** @ngInject */
  function NavBarController($timeout, $state, toastr, AuthenticationService) {
    var vm = this;

    vm.logout = function() {
      AuthenticationService.ClearCredentials();
      toastr.success("Successfully logout.")
      $state.go('login');
    }
  }
})();
