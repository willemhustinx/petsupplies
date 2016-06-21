(function() {
	'use strict';

	function CartService($cookies, ProductService) {

		var vm = this;
		
		if(!angular.isDefined($cookies.getObject('shoppingCart'))){
    		$cookies.putObject('shoppingCart', []);
    	}
			
		vm.productsInCart = $cookies.getObject('shoppingCart');
		
    	// Adding a product to the cart
    	this.addToCart = function(productId) {
    		angular.forEach(ProductService.products, function(product) {
    			if (product.id == productId) {
    				
    				var inCart = false;
    				
    				angular.forEach(vm.productsInCart, function(productFromCart) {
    					if(productFromCart.id == product.id) {
    						productFromCart.amount++;
    						inCart = true;
    					}
    				});
    				
    				if (!inCart) {
    					product.amount = 1;
    					vm.productsInCart = vm.productsInCart.concat(product);
    				}
    				
    				$cookies.putObject('shoppingCart', vm.productsInCart);
    			}
    		});
    	}
    	
    	this.removeProduct = function(index) {
    		vm.productsInCart.splice(index, 1);
	    	$cookies.putObject('shoppingCart', vm.productsInCart);
	    }
	    
	    this.addToAmount = function(index) {
	    	vm.productsInCart[index].amount++;
	    	$cookies.putObject('shoppingCart', vm.productsInCart);
	    }
	    
	    this.substractFromAmount = function(index) {
	    	if(--vm.productsInCart[index].amount <= 0) {
	    		vm.removeProduct(index);
	    	} else {
	    		$cookies.putObject('shoppingCart', vm.productsInCart);
	    	}
	    }
	    
	}

	CartService.$inject = [ '$cookies' , 'ProductService' ];

	angular.module('PetShopApp').service('CartService', CartService);
})();