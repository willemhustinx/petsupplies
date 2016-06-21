(function () {
    'use strict';
    
	function AdminController(ProductService, CategoryService, AdminService) {				
	    var vm = this;
	    
	    vm.layout = 'product';
	    vm.categoryFilter = '';
	    
	    vm.productservice = ProductService;
	    vm.categoryservice = CategoryService;
	    vm.adminservice = AdminService;

	    vm.getUserAccount = function(){
	    	vm.adminservice.getUserAccount(vm.userAccount)
			.then(function (response) {
				vm.form = response.data;
			})
			.catch(function (error) {
				console.log(error);
			});
		}
	    
	    vm.editAccount = function(){
    		AdminService.editAccount(vm.form);
    	}
	    
	    vm.getUserOrder = function(){
	    	vm.adminservice.getUserOrder(vm.userAccount)
			.then(function (response) {
				console.log(response.data);
				vm.productsInOrder = response.data;
			})
			.catch(function (error) {
				console.log(error);
			});
	    }
	}
    
    AdminController.$inject = ['ProductService', 'CategoryService', 'AdminService'];

    angular.module('PetShopApp')
        .controller('AdminController', AdminController);
})();