(function () {
  'use strict';

  angular
    .module('app.dataservices')
    .factory('Client', Client)

  /** @ngInject */
  function Client($resource) {
    var resource = $resource(
      'api/admin/clients/:id',
      {},
      {
        query: {
          method: 'GET',
          isArray: true
        },
        get: {
          method: 'GET',
          isArray: false
        },
        delete: {
          method: 'DELETE',
          isArray: false
        },
        create: {
          method: 'POST',
          isArray: false
        },
        update: {
          method: 'PUT',
          isArray: false
        },
        enable: {
          url: 'api/admin/clients/:id/enable',
          method: 'POST',
        },
        disable: {
          url: 'api/admin/clients/:id/disable',
          method: 'POST',
        },
        configlog: {
          url: 'api/admin/clients/:id/configlog',
          method: 'GET',
          isArray: true
        }
      })

    return resource;
  };

})();
