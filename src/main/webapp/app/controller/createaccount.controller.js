(function () {
    'use strict';
    
    function CreateAccountController($scope, $http, AlertService, $location, LoginService) {	

		
    	var vm = this;
    	
    	vm.alert = AlertService;
		
    	vm.loginAuthentication = function(){
			LoginService.loginAuthentication(vm.user)
				.then(function (data) {
					
					if(data.data == true) {
						$location.path( "/" );
						//set idle watcher active
						$scope.activeIdle();
					}
					vm.showLoginError = true;
				})
				.catch(function (error) {
					console.log(error);
				});
    	}
    	
		vm.createAccount = function(){
			vm.account = {
					email: vm.email,
					password: vm.password,
					firstName: vm.firstName,
					insertion: (vm.nameInsertion == "") ? null : vm.nameInsertion,
					lastName: vm.lastName,
					address: vm.adress,
					addressNumber: vm.adressNumber,
					addressInsertion: (vm.adressInsertion == "") ? null : vm.adressInsertion,
					postalCode: vm.postalCode,
					city: vm.city
			};
			
			
			if(vm.form.password != vm.form.repeatPassword){
				alert("passwords dont match");
			}else{
				delete vm.form.repeatPassword;
				$http.post('http://localhost:8080/PetShop/rest/account/create/', vm.form).success(function() {
		    		vm.alert.alerts[1].show = true;
		    		$location.path("/");
					//empty the input fields of the form
		    		
		    		vm.form = []
		    			
				}).error(function(status) {
					console.log("Account creation error, oh noes D:");
				});
			}
		}
	}
    
    CreateAccountController.$inject = ['$scope', '$http', 'AlertService', '$location', 'LoginService' ];


    angular.module('PetShopApp')
        .controller('CreateAccountController', CreateAccountController);
})();