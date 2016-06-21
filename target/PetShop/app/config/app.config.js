(function () {
    'use strict';
    
    function Config($routeProvider) {
		
    	$routeProvider
	
		// route for the home page
		.when('/', {
			templateUrl : 'app/template/main.template.html',
			controller : 'ProductListController',
	    	controllerAs: 'list',
		})
		
		// route for the shopping cart page
		.when('/cart', {
			templateUrl : 'app/template/shoppingcart.template.html',
			controller : 'ShoppingCartController',
	    	controllerAs: 'cart',
		})
	
		// route for the shopping cart page
		.when('/orderPlaced', {
			templateUrl : 'app/template/orderplaced.template.html'
		})
		
		// route for the shopping account creation page
		.when('/createAccount', {
			templateUrl : 'app/template/createaccount.template.html',
			controller : 'CreateAccountController',
	    	controllerAs: 'account'
		})
		// route for the activation page
		.when('/activate/:activationString', {
			templateUrl : 'app/template/activate.template.html',
			controller : 'ActivateController',
			controllerAs : 'activate'
		})
		
		// route for the user account page
		.when('/account', {
			templateUrl : 'app/template/account.template.html',
			controller : 'AccountController',
			controllerAs : 'account'
		})
		.when('/admin', {
			templateUrl: 'app/template/admin.template.html',
			controller: 'AdminController',
			controllerAs: 'admin'
		})
		
		.when('/admin-p', {
			templateUrl: 'app/template/admin.product.template.html',
			controller: 'AdminController',
			controllerAs: 'admin'
		})
		
		.when('/admin-a', {
			templateUrl: 'app/template/admin.account.template.html',
			controller: 'AdminController',
			controllerAs: 'admin'
		})
		
		.when('/admin-o', {
			templateUrl: 'app/template/admin.order.template.html',
			controller: 'AdminController',
			controllerAs: 'admin'
		})
		
		.when('/product', {
			templateUrl: 'app/template/product.template.html',
			controller: 'ProductController',
			controllerAs: 'product'
		})
		
		.when('/category', {
			templateUrl: 'app/template/category.template.html',
			controller: 'CategoryController',
			controllerAs: 'category'
		})

    };
    
    Config.$inject = [ '$routeProvider' ];

    angular.module('PetShopApp')
        .config(Config)
})();