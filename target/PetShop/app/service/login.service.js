(function() {
	'use strict';

	function LoginService( $http, $cookies, $location, AdminService) {

		var vm = this;
		this.loginAuthentication = function(user){
    		return $http.post('http://localhost:8080/PetShop/rest/login', user).success(function(response, $rootScope){
    			AdminService.checkAdmin();
    			$cookies.put('login', user.email);
    			return response;
    		}).catch(function (response) {
    			return $q.reject(response.data);
    	    });
    	}
    	
    	this.logOut = function(){

    		$http.get('rest/login/logout').success(function(data) {
    			AdminService.isAdmin = false;
    			vm.secretData = data;
    			console.log("logged out");
    			$cookies.remove('login');
    		}).error(function (data, status){
    	        console.log("Error status : " + status);
    	    });
    	}
    	
    	this.loggedIn = function(){
    		return angular.isDefined($cookies.get('login'));
    	}
	}

	LoginService.$inject = [ '$http' , '$cookies' , '$location', 'AdminService'];

	angular.module('PetShopApp').service('LoginService', LoginService);
})();
