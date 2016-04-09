angular
  .module('app.filters')
  .filter('date', [DateFilter]);

function DateFilter(date) {
  return function(value) {
    return moment(value).format("MMM Do YYYY, h:mm:ss a");
  };
};
