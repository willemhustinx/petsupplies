(function () {
    'use strict';

    function AccountController( $http , $cookies , AccountService ) {

    	var vm = this;
    	
    	AccountService.getAccount()
			.then(function (response) {
				vm.form = response.data;
			})
			.catch(function (error) {
				console.log(error);
			}
		);
    	
    	this.editAccount = function(){
    		AccountService.editAccount(vm.form);
    		vm.accountChanged = true;
    	}
    	
    	this.changePassword = function(){
    		if(this.pass.newpassword != this.pass.newpasswordrepeat){
    			alert("passwords don't match");
    		} else {
    			var send = new Object();
    			send.newPassword = vm.pass.newpassword;
    			send.oldPassword = vm.pass.oldpassword;
    			AccountService.changePassword(send)
    				.then(function (response) {
    					vm.passwordChanged = response.data;
    				});
    			delete(vm.pass);
    		} 		
    	}
    }

    AccountController.$inject = [ '$http' , '$cookies' , 'AccountService' ];


    angular.module('PetShopApp')
        .controller('AccountController', AccountController);
})();
