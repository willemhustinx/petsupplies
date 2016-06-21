(function () {
    'use strict';
    
    function ProductListController( CartService , ProductService , CategoryService ) {	
		var vm = this;
	
    	vm.layout = 'list';
    	vm.categoryFilter = '';
    	
    	vm.productservice = ProductService;
        vm.categoryservice = CategoryService;
        
		// Adding a product to the cart
    	vm.addToCart = function(productId) {
    		CartService.addToCart(productId);
    	}
	}
    
    ProductListController.$inject = [ 'CartService' , 'ProductService', 'CategoryService' ];
    
    angular.module('PetShopApp')
        .controller('ProductListController', ProductListController);
})();