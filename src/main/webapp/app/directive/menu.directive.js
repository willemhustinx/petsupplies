(function() {
	'use strict';

	function MenuDirective() {
		return {
			templateUrl : 'app/template/menu.template.html',		
		};
	}

	/*
	 * Dependency injection
	 */
	MenuDirective.$inject = [];

	/*
	 * Angular module definition and it's components
	 */
	angular.module('PetShopApp')
	  .directive('mainmenu', MenuDirective);

})();