(function() {
	'use strict';

	function HeaderDirective() {
		return {
			templateUrl : 'app/template/header.template.html'
		};
	}

	/*
	 * Dependency injection
	 */
	HeaderDirective.$inject = [];

	/*
	 * Angular module definition and it's components
	 */
	angular.module('PetShopApp')
	  .directive('header', HeaderDirective);

})();