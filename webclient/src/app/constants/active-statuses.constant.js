(function () {
  'use strict';

  angular
    .module('app.constants')
    .constant('ACTIVE_STATUSES', [
      {id: 'all', title: 'All'},
      {id: 'enabled', title: 'Enabled'},
      {id: 'disabled', title: 'Disabled'}
    ]);
})();
