(function () {
    'use strict';
    
	function CategoryController(CategoryService, AdminService) {				
	    var vm = this;
	    
	    vm.adminservice = AdminService;

	    vm.categoryForm = {
	    		name:{
	    			EN: '',
	    			NL: ''
	    		}
	    }
	    
	    vm.addCategory = function(){
	    	vm.adminservice.addCategory(vm.categoryForm);
	    };
	    
	    if(vm.adminservice.category){
	    	vm.categoryForm = vm.adminservice.category;
	    	vm.adminservice.category = undefined;
	    }
	    
	}
    
	CategoryController.$inject = ['CategoryService', 'AdminService'];

    angular.module('PetShopApp')
        .controller('CategoryController', CategoryController);
})();