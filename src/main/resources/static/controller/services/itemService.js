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
                contentType: "application/json"
            }).then(function (response) {

                $rootScope.itemDAOs = response.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });

        },

    };


}]);
