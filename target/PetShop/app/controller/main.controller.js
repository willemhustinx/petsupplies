(function () {
    'use strict';

    function MainController($scope, $cookies, LanguageService, CurrencyService, ProductService, CategoryService, LoginService, AlertService, AdminService, Idle, Keepalive) {

    	var vm = this;
    	
    	vm.language = LanguageService;
    	vm.currency = CurrencyService;
    	
    	vm.alert = AlertService;
 
    	//INIT SERVICES
        ProductService.fetch();
        CategoryService.fetch();
        
    	vm.language = LanguageService;
    	vm.currency = CurrencyService;  	
    	vm.admin = AdminService;
    	
    	if($cookies.get('login')){
    		vm.admin.checkAdmin();
    	}

    	$scope.activeIdle = function(){
	        $scope.$on('IdleStart', function() {
	            console.log("You're idle, do something");
	            vm.alert.alerts[2].show = true;
	          });
	        $scope.$on('IdleTimeout', function() {
	        	console.log("You've been timed out!");
	        	LoginService.logOut();
	        	vm.alert.alerts[3].show = true;
	        });
	    }
    }

    MainController.$inject = ['$scope', '$cookies', 'LanguageService' , 'CurrencyService' , 'ProductService' , 'CategoryService' , 'LoginService', 'AlertService', 'AdminService', 'Idle', 'Keepalive' ];


    angular.module('PetShopApp')
        .controller('MainController', MainController);
})();
