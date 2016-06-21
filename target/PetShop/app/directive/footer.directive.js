(function() {
	'use strict';

	function FooterDirective() {
		return {
			templateUrl : 'app/template/footer.template.html'
		};
	}

	/*
	 * Dependency injection
	 */
	FooterDirective.$inject = [];

	/*
	 * Angular module definition and it's components
	 */
	angular.module('PetShopApp')
	  .directive('footer', FooterDirective);

})();