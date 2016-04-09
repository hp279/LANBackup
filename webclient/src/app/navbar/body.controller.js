(function () {
  'use strict';

  angular
    .module('app')
    .controller('NavBarController', NavBarController);

  /** @ngInject */
  function NavBarController($timeout, toastr) {
    var vm = this;
  }
})();
