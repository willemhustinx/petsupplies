(function () {
    'use strict';
    
	function ProductController(CategoryService, AdminService) {				
	    var vm = this;

	    vm.productForm = {
	    		name:{
	    			EN: '',
	    			NL: ''
	    		},
	    		price:{
	    			EUR: 0,
	    			USD: 0,
	    			JPY: 0
	    		},
	    		description:{
	    			EN: '',
	    			NL: ''
	    		},
	    		category:{

	    		}
	    };
	    
	    vm.categoryservice = CategoryService;
	    vm.adminservice = AdminService;
	    
	    vm.addProduct = function(){
	    	vm.adminservice.addProduct(vm.productForm);
	    };
	    	
	    if(vm.adminservice.product){
	    	vm.productForm = vm.adminservice.product;

	    	var elementPos = vm.categoryservice.categories.map(function(x) {return x.id; }).indexOf(vm.adminservice.product.category.id);
	    	var category = vm.categoryservice.categories[elementPos];

	    	vm.productForm.category = category;
	    	//empty the product
	    	vm.adminservice.product = undefined;
	    }
	    
	}
    
	ProductController.$inject = ['CategoryService', 'AdminService'];

    angular.module('PetShopApp')
        .controller('ProductController', ProductController);
})();