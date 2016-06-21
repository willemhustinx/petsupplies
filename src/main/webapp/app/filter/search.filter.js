(function() {
	'use strict';

	function SearchFilter(LanguageService) {

		return function(products, search) {
			
			search = angular.lowercase(search);
			
			if(!angular.isUndefined(search) && search.length > 0){
				var output = [];
				
				angular.forEach(products, function(product){
					
					if((angular.lowercase(product.name[LanguageService.language]).search(search) != -1) ||
			           (angular.lowercase(product.description[LanguageService.language]).search(search) != -1) ){
			        	output.push(product);
					}
			    });
				return output;
			}
			
			return products;	
		};
	}

	SearchFilter.$inject = [ 'LanguageService' ];

	angular.module('PetShopApp').filter('search', SearchFilter);
})();