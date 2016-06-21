(function () {
    'use strict';
    
    function MenuController( LanguageService , LoginService) {	
		var vm = this;
		vm.service = LanguageService;
	
	    vm.setLanguage = function(language)
	    {
	    	LanguageService.setLanguage(language);
	    }
	    
	    vm.logOut = function(){
    		LoginService.logOut();
    	}
	    
    	vm.loggedIn = function(){
    		return LoginService.loggedIn();
    	}
	}
    
    MenuController.$inject = [ 'LanguageService' , 'LoginService' ];
    
    angular.module('PetShopApp')
        .controller('MenuController', MenuController);
})();