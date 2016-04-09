(function () {
  'use strict';

  angular
    .module('app.backup-configuration')
    .controller('BackupConfigurationController', BackupConfigurationController);

  /** @ngInject */
  function BackupConfigurationController($timeout, ACTIVE_STATUSES, initClients, Client, toastr) {
    var vm = this;

    debugger;
    vm.filters = ACTIVE_STATUSES;

    vm.filter = vm.filters[1];

    vm.items = initClients;

    vm.update = function () {
      Client.query().$promise.then(function (response) {
        vm.items = response;
      });
    }

   /* vm.onAddButtonClick = function () {
      add.call().then(
        function (response) {
          $state.go('admin.settings.teams.edit', {id: response.id});
        });
    }

    vm.onArchiveButtonClick = function (item) {
      archive.call(item).then(
        function (response) {
          vm.update();
        });
    }

    vm.onUnarchiveButtonClick = function (item) {
      unarchive.call(item).then(
        function (response) {
          vm.update();
        });
    }

    vm.onResendWelcomeEmailButtonClick = function (item) {
      resendWelcomeEmail.call(item)
    }

    vm.onPermissionsButtonClick = function () {
      Team.get_permissions().$promise.then(
        function (_permissions) {
          setPermissions.call(_permissions).then(
            function (response) {
              vm.update();
            });
        });
    } */

    vm.filterFunc = function (item) {
      switch (vm.filter.id) {
        case 'all':
          return true;
        case 'active':
          return item.enabled;
        case 'archived':
          return !item.enabled;
        default:
          return true;
      }
    }
  }
})();
