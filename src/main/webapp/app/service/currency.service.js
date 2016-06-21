(function(){
	'use strict';
	
	function CurrencyService($cookies) {
		
		var vm = this;

		vm.currencies = [
		    	         { name: 'Euro', value: 'EUR' },
		    	         { name: 'Dollar', value: 'USD' },
		    	         { name: 'Yen', value: 'JPY' }
		    	       ];
		    	
    	if($cookies.getObject('currency')){
    		vm.selectedCurrency = $cookies.getObject('currency');  	
    	}else{
    		vm.selectedCurrency = vm.currencies[0];
    	}
    	
    	vm.setCurrency = function(currency){
    		vm.selectedCurrency = currency;
    		$cookies.putObject('currency', vm.selectedCurrency);
    	}
		
	}
	
	CurrencyService.$inject = [ '$cookies'];

	angular.module('PetShopApp').service('CurrencyService', CurrencyService);
})();