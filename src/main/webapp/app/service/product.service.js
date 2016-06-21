(function() {
	'use strict';

	function ProductService($http, $q) {

		var vm = this;
		vm.products = [];
			
        this.fetch = function fetch() {
            $http.get('rest/product/')
                .then(function (response) {
                    vm.products = response.data;
                });
        }

	}

	ProductService.$inject = [ '$http', '$q' ];

	angular.module('PetShopApp').service('ProductService', ProductService);
})();