(function () {
    'use strict';
    
	function category(products, category) {
		
		if(!angular.isUndefined(category) && category > 0){
			
			var output = [];
			
			angular.forEach(products, function(product){
				if(product.category != null){
			        if(product.category.id === category){
			        	output.push(product);
			        }
				}
		    });
			
			return output;
		}
		return products;	
	};
	
	angular.module('PetShopApp')
		.filter('category', function () {
			return category;
		});
})();