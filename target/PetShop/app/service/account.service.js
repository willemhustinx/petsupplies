(function() {
	'use strict';

	function AccountService( $http ) {

		var vm = this;
		    	
		this.getAccount = function(){
			return $http.get('rest/account/info').success(function(response) {
				if(response != null){
			    	delete response.password;
			    	return response;
			    }
			}).catch(function (response) {
    			return $q.reject(response.data);
    	    });
		}
		
		this.editAccount = function(account){
			return $http.post('rest/account/edit', account).success(function(response) {
				return response;
			}).catch(function (response) {
				return $q.reject(response.data);
			});
		}
		
		this.changePassword = function(passwords){
			return $http.post('rest/account/changePassword', passwords).success(function(response) {
				return response;
			}).catch(function (response) {
				return $q.reject(response.data);
			});
		}
		

	}

	AccountService.$inject = [ '$http' ];

	angular.module('PetShopApp').service('AccountService', AccountService);
})();
