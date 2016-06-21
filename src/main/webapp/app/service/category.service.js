(function() {
	'use strict';

	function CategoryService($http, $q) {

		var vm = this;
		vm.categories = [];
			
        this.fetch = function fetch() {
            $http.get('rest/category/')
                .then(function (response) {
                    vm.categories = response.data;
                });
            
        }
	}

	CategoryService.$inject = [ '$http', '$q' ];

	angular.module('PetShopApp').service('CategoryService', CategoryService);
})();