/**
 * Created by Iraj on 03/18/19.
 */

app.controller('loginController', function ($scope, LoginService) {
    $scope.loginForm = [];

    $scope.login = function () {
        localStorage.removeItem("USER_TOKEN");

        let loginObject = {
            username: $scope.loginForm.username,
            password: $scope.loginForm.password
        };

        LoginService.verifyLogin(loginObject);
    };
});