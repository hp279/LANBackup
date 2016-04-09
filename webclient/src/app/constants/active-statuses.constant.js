angular
  .module('app.constants')
  .constant('ACTIVE_STATUSES', [
    {id: 'all', title: 'All'},
    {id: 'active', title: 'Active'},
    {id: 'archived', title: 'Archived'}
  ]);