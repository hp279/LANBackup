angular
  .module('app.dataservices')
  .factory('Client', ['$resource', Client])

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
      count: {
        url: 'staff/locations/count',
        method: 'GET',
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
      deactivate: {
        url: 'staff/locations/:id/deactivate',
        method: 'POST',
      },
      activate: {
        url: 'staff/locations/:id/activate',
        method: 'POST',
      }
    })

  return resource;
};
