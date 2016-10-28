var app = angular.module('application', []);
app.component('signUpForm', {
    templateUrl: 'app/views/sign-up-form.html',
    controller: function($http) {
        var self = this;
        self.signUp = function(user) {
            $http.post('api/users', user).then(function(result) {
                self.result = result.data.message;
            });
        }
    },
    controllerAs: 'vm'
});

app.component('userDetails', {
    templateUrl: 'app/views/user-details.html',
    controller: function($http) {
        var self = this;
        $http.get('api/users/current')
        .then(function(result) {
            self.username = result.data.name;
        });
    },
    controllerAs: 'vm'
})

app.component('loginForm', {
    template: '<a ng-if="!vm.logged" href="access">Login</a><button ng-if="vm.logged" ng-click="vm.logout()">Logout</button>',
    controller: function($http, $location) {
        var self = this;
        $http.get('api/users/current')
        .then(function(result) {
            self.logged = true;
            debugger;
        });

        self.logout = function() {
            $http.post("/logout").then(function() {
                window.location.reload();
            });
        }
    },
    controllerAs: 'vm'
})

app.config(function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})