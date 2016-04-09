(function () {
  'use strict';

  angular
    .module('app.dataservices')
    .factory('Client', Client)

  /** @ngInject */
  function Client($resource) {
    var resource = $resource(
      'api/clients/:id',
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
          url: 'api/clients/:id/enable',
          method: 'POST',
        },
        disable: {
          url: 'api/clients/:id/disable',
          method: 'POST',
        }
      })

    return resource;
  };

})();
