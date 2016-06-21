(function() {
	'use strict';

	function LanguageService($cookies, $http) {

		var vm = this;
		
		if (!angular.isDefined($cookies.getObject('language'))) {
			$cookies.putObject('language', 'NL');
			vm.language = 'NL';
		} else {
			vm.language = $cookies.getObject('language');
		}

		vm.translation = [];


		vm.setLanguage = function(language) {
			vm.language = language;
			$cookies.putObject('language', language);
			vm.setTranslation(language);
		}

		vm.setTranslation = function(language) {
			vm.getTranslation(language).then(function(translation) {
				vm.translation = translation;
			});
		};

		vm.getTranslation = function(language) {
			return $http.get(
					'translations/' + angular.lowercase(language) + '.json')
					.then(function(response) {
						return response.data;
					});
		};
		
		vm.setTranslation(vm.language);
	}

	LanguageService.$inject = [ '$cookies', '$http' ];

	angular.module('PetShopApp').service('LanguageService', LanguageService);
})();
