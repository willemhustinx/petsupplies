(function(){
	'use strict';
	
	function AlertService() {
		
		var vm = this;

    	//alert
    	vm.alerts = [
    		{type: 'success', msg: "Uw bestelling is geplaatst!", show: false},
    		{type: 'success', msg: "Uw account is gemaakt!", show: false},
    		{type: 'warning', msg: "U bent inactief, u wordt over een paar seconden uitgelogt.", show: false},
    		{type: 'danger', msg: "U bent uitgelogt, omdat u inactief was.", show: false}
    	];

    	vm.closeAlert = function(index) {
    		vm.alerts[index].show = false;
    	};
	}
	
	AlertService.$inject = [ '$cookies'];

	angular.module('PetShopApp').service('AlertService', AlertService);
})();