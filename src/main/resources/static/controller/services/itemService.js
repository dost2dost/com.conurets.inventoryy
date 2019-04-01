/**
 * Created by Iraj on 03/18/19.
 */

app.service('ItemService', ['$rootScope', '$http', function($rootScope, $http) {

    return {
        getAllItems: function () {

            $rootScope.itemDAOs = [];

            $http({
                method: 'GET',
                url: '/inventory-management/findAllItems',
                dataType: 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json',
                    'Authorization': 'Bearer '+ localStorage.getItem("USER_TOKEN")
                },
            }).then(function (response) {

                $rootScope.itemDAOs = response.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });

        },

    };


}]);
