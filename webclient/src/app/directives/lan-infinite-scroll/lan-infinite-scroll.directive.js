angular
  .module('app.directives')
  .directive('lanInfiniteScroll', ['$compile', '$timeout', lanInfiniteScroll]);

function lanInfiniteScroll($compile, $timeout) {
  return {
    restrict: 'A',
    scope: {
      nextItems: '&lanInfiniteScroll'
    },
    link: function(scope, element, attrs) {
      element.hide();

      var nextPage = function() {
        if (scope.loading) return;

        scope.loading = true;
        if (attrs.loadingMessage) {
          showInfiniteScrollMessage(element, attrs.loadingMessage);
        }

        scope.nextItems().then(function(items) {
          element.show();
          scope.loading = false;
          hideInfiniteScrollMessage();
        });
      };

      nextPage();
      scope.nextPage = nextPage;

      element.attr('infinite-scroll', 'nextPage()');
      element.attr('infinite-scroll-immediate-check', 'false');
      element.removeAttr('ng-show ng-hide sui-infinite-scroll-resource sui-infinite-scroll');
      $compile(element)(scope);
    }
  }
}

function showInfiniteScrollMessage(element, message) {
  if (element.is(":visible")) {
    angular.element("#infinite-scroll-message em").html(message);
    angular.element("#infinite-scroll-message").show();
  };
};

function hideInfiniteScrollMessage() {
  angular.element("#infinite-scroll-message").hide();
};
