(function() {
	'use strict';

	function CartService($cookies , $http , ProductService ) {

		var vm = this;
		
		if(!angular.isDefined($cookies.getObject('shoppingCart'))){
    		$cookies.putObject('shoppingCart', []);
    	}
		
		//$cookies.putObject('shoppingCart', []);
		
		this.fillCartFromUser = function() {
			$http.get('rest/cart').success(function(data) {
				
				angular.forEach(data, function(productLoginCart) {
					var inCart = false;
    				
    				angular.forEach(vm.productsInCart, function(productFromCart) {
    					if(productFromCart.product.id == productLoginCart.product.id) {
    						productFromCart.amount += productLoginCart.amount;
    						inCart = true;
    					}
    				});
    				
    				if (!inCart) {
    					var cartProduct = new Object();
    					cartProduct.amount = productLoginCart.amount;
    					cartProduct.product = productLoginCart.product;
    					
    					vm.productsInCart = vm.productsInCart.concat([cartProduct]);
    				}
				});
				
				$cookies.putObject('shoppingCart', vm.productsInCart);
				vm.saveCartFromUser();
    			
    		}).error(function (data, status){
    	        console.log("Error status : " + status);
    	    });
		}
		
		this.saveCartFromUser = function() {
			if(angular.isDefined($cookies.get('login'))) {
				$http.post('rest/cart', vm.productsInCart).success(function(data) {
					
	    		}).error(function (data, status){
	    	        console.log("Error status : " + status);
	    	    });
			}
		}
		
		vm.productsInCart = $cookies.getObject('shoppingCart');
		
    	// Adding a product to the cart
    	this.addToCart = function(productId) {
    		angular.forEach(ProductService.products, function(product) {
    			if (product.id == productId) {
    				
    				var inCart = false;
    				
    				angular.forEach(vm.productsInCart, function(productFromCart) {
    					if(productFromCart.product.id == product.id) {
    						productFromCart.amount++;
    						inCart = true;
    					}
    				});
    				
    				if (!inCart) {
    					var cartProduct = new Object();
    					cartProduct.amount = 1;
    					cartProduct.product = product;
    					
    					vm.productsInCart = vm.productsInCart.concat([cartProduct]);
    				}
    				
    				$cookies.putObject('shoppingCart', vm.productsInCart);
    				vm.saveCartFromUser();
    			}
    		});
    	}
    	
    	this.removeProduct = function(index) {
    		vm.productsInCart.splice(index, 1);
	    	$cookies.putObject('shoppingCart', vm.productsInCart);
	    	vm.saveCartFromUser();
	    }
    	
    	this.emptyCart = function() {
    		vm.productsInCart = [];
	    	$cookies.putObject('shoppingCart', []);
	    	vm.saveCartFromUser();
	    }
	    
	    this.addToAmount = function(index) {
	    	vm.productsInCart[index].amount++;
	    	$cookies.putObject('shoppingCart', vm.productsInCart);
	    	vm.saveCartFromUser();
	    }
	    
	    this.substractFromAmount = function(index) {
	    	if(--vm.productsInCart[index].amount <= 0) {
	    		vm.removeProduct(index);
	    	} else {
	    		$cookies.putObject('shoppingCart', vm.productsInCart);
	    		vm.saveCartFromUser();
	    	}
	    }
	    
	}

	CartService.$inject = [ '$cookies' , '$http' , 'ProductService' ];

	angular.module('PetShopApp').service('CartService', CartService);
})();