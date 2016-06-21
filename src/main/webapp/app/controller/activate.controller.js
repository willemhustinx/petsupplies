(function () {
    'use strict';
    
    function ActivateController( $routeParams , $http ) {	
		var vm = this;
		
		vm.test = "lalal";
		
		$http.post('http://localhost:8080/PetShop/rest/account/activate/', $routeParams.activationString).success(function(response) {
			vm.response = response;
		}).error(function(status) {
			console.log("Account creation error, oh noes D:");
		});
	}
    
    ActivateController.$inject = [ '$routeParams' , '$http' ];
    
    angular.module('PetShopApp')
        .controller('ActivateController', ActivateController);
})();