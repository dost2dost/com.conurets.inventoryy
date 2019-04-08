/**
 * Created by Iraj on 03/18/19.
 */

app.service('LoginService', ['$rootScope', '$http', function($rootScope, $http) {
    return {
        verifyLogin: function (login) {
            $http({
                method: 'POST',
                url: '/inventory-management/api/login',
                dataType: 'json',
                data: JSON.stringify(login),
                contentType: "application/json"
            }).then(function (response) {
                if (response.data) {
                    if (response.data.code === 0) {
                        let loginObject = response.data.data;
                        let authorities = loginObject.authorities;

                        localStorage.setItem("INV_USER_TOKEN", loginObject.token);

                        $(location).attr('href', '/inventory-management/form');
                    } else {
                        alert(response.data.value)
                    }
                } else {
                    alert("Internal server error");
                }
            }, function (err) {
                alert("ERROR: " + err.data.error);
            });
        },
    };
}]);