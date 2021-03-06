(function () {
    'use strict';

    function ShoppingCartController($http, $cookies, $location, LanguageService, CurrencyService, CartService, AlertService) {	
		
    	var vm = this;
        vm.language = LanguageService;
        vm.currency = CurrencyService;

	
		vm.productsInCart = $cookies.getObject('shoppingCart');

		vm.cartservice = CartService;
        
		vm.removeProduct = function(index) {
	    	CartService.removeProduct(index);
	    }
	    
	    vm.addToAmount = function(index) {
	    	CartService.addToAmount(index);
	    }
	    
	    vm.substractFromAmount = function(index) {
	    	CartService.substractFromAmount(index);
	    }
	    
		vm.currency = CurrencyService;
		
		vm.alert = AlertService;
		
	    vm.totalPrice = function() {
	        var total = 0;
	        
	        angular.forEach(vm.cartservice.productsInCart, function(productInCart) {
	            total += productInCart.product.price[vm.currency.selectedCurrency.value] * productInCart.amount;
	        })
	
	        return total;
	    }
	    
	    vm.order = function() {
	    	
	    	var temporder = vm.orderForm;
	    	
            //add the current curreny of the order to the database
	    	temporder.currency = vm.currency.selectedCurrency.value;
            
	    	temporder.orderProducts = [];
	    	
	    	angular.forEach(vm.productsInCart, function(productFromCart) {
	            temporder.orderProducts.push({
	            	name: productFromCart.product.name[LanguageService.language],
	                price: productFromCart.product.price[vm.currency.selectedCurrency.value],
	                amount: productFromCart.amount 
	            });
	        })
	        
	        $http.post('rest/order/create', temporder).success(function(data, status) {
	    		
	        	CartService.emptyCart();
	        	
	        	vm.alert.alerts[0].show = true;
	    		$location.path("/");
	    	})
	    }
	    
		//get the data from the database if the use is logged in
		//check if user is logged in
		if(angular.isDefined($cookies.get('login'))) {
			$http.get('rest/account/info').success(function(data) {
				//if user is logged in
			    if(data != null){
			    	//set data in fields
			    	delete data.password;
			    	delete data.activated;
			    	delete data.roles;
			    	vm.orderForm = data;
			    }
			}).error(function (data, status){
		        console.log("Error status : " + status);
		    });
		}
	    
	}
    

    ShoppingCartController.$inject = [ '$http' , '$cookies' , '$location' , 'LanguageService', 'CurrencyService' , 'CartService', 'AlertService' ];

    angular.module('PetShopApp')
        .controller('ShoppingCartController', ShoppingCartController);
})();