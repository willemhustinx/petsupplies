(function() {
	'use strict';

	function AdminService($http, ProductService, $location, CategoryService, $q) {

		var vm = this;
		vm.product = undefined;
		vm.category = undefined;
		
		vm.isAdmin = false;
		

		vm.getUserAccount = function(email){
    		if(email){
	    		//Cant send @ sign in get request
	    		email = email.replace(/@/g, '-');
	    	}
    		
    		return $http.get('rest/admin/info/' + email).success(function(response) {
				if(response != null){
			    	delete response.password;
			    	return response;
			    }
			}).catch(function (response) {
    			return $q.reject(response.data);
    	    });
		}
		
		vm.editAccount = function(account){
			return $http.post('rest/admin/edit', account).success(function(response) {
				return response;
			}).catch(function (response) {
				return $q.reject(response.data);
			});
		}
		
		vm.getUserOrder = function(email){
    		if(email){
	    		//Cant send @ sign in get request
	    		email = email.replace(/@/g, '-');
	    	}
    		
    		return $http.get('rest/admin/order/' + email).success(function(response) {
				if(response != null){
			    	return response;
			    }
			}).catch(function (response) {
    			return $q.reject(response.data);
    	    });
		}
		
		vm.checkAdmin = function(){
			$http({
				method: 'GET',
				url: 'rest/login/isAdmin'
			}).then(function(response){
				if(response.data){
					//user is an admin
					vm.isAdmin = true;
				}else{
					vm.isAdmin = false;
				}
			})
		};
			
        vm.removeProduct = function (id) {
			$http({
				method: 'DELETE',
				url: 'rest/admin/removeProduct/' + id
			}).then(function(data){
            	if(data){
            		angular.forEach(ProductService.products, function(item){
        			    if(item.id === id){
        			    	ProductService.products.splice(ProductService.products.indexOf(item), 1);
        			    }   
        			})
            	}
            });
        }

        vm.addProduct = function(product) {
			$http({
				method: 'POST',
				url: 'rest/admin/addProduct',
				data: product
			}).then(function(){
				ProductService.fetch();
				$location.path("/admin");
			});
        }
        
        vm.editProduct = function(product){
        	vm.product = product;
        	$location.path("/product");
        }
        
        vm.removeCategory = function (id) {
			$http({
				method: 'DELETE',
				url: 'rest/admin/removeCategory/' + id
			}).then(function(data){
            	if(data){
            		angular.forEach(CategoryService.categories, function(item){
        			    if(item.id === id){
        			    	CategoryService.categories.splice(CategoryService.categories.indexOf(item), 1);
        			    }   
        			})
            	}
            });
        }
        
        vm.editCategory = function(category){
        	vm.category = category;
        	$location.path("/category");
        }
        
        vm.addCategory = function(category) {
			$http({
				method: 'POST',
				url: 'rest/admin/addCategory',
				data: category
			}).then(function(){
				CategoryService.fetch();
				$location.path("/admin");
			});
        }
	}

	AdminService.$inject = [ '$http', 'ProductService', '$location', 'CategoryService', '$q'];

	angular.module('PetShopApp').service('AdminService', AdminService);
})();