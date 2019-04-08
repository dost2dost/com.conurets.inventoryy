/**
 * Created by Iraj on 03/18/19.
 */

app.service('LocationService', ['$rootScope', '$http', function($rootScope, $http) {

    return {
        getAllLocations: function () {

            $rootScope.locationDAOs = [];

            $http({
                method: 'GET',
                url: '/inventory-management/findAllLocations',
                dataType: 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json',
                    'Authorization': 'Bearer '+ localStorage.getItem("INV_USER_TOKEN")
                },
            }).then(function (response) {

                $rootScope.locationDAOs = response.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });

        },

    };


}]);
