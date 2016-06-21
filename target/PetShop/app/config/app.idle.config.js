(function () {
    'use strict';
    
    function idleConfig(KeepaliveProvider, IdleProvider) {
    	  IdleProvider.idle(1800);
    	  IdleProvider.timeout(5);
    	  KeepaliveProvider.interval(10);
    };
	
    idleConfig.$inject = [ 'KeepaliveProvider', 'IdleProvider'];

    angular.module('PetShopApp')
        .config(idleConfig)
	    .run(['Idle', function(Idle) {
	  	  Idle.watch();
	  	}]);
})();