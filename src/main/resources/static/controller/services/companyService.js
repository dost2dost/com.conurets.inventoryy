/**
 * Created by Iraj on 03/19/19.
 */



app.service('CompanyService', ['$rootScope', '$http', function($rootScope, $http) {

    return {


        getAllCompanies: function ()
        {

            $rootScope.companyDAOs = [];

            $http({
                method: 'GET',
                url: '/inventory-management/findAllCompanies',
                dataType: 'json',
                contentType: "application/json"
            }).then(function (response) {

                $rootScope.companyDAOs = response.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });

        },

        getCompanyDAO: function (_companyObject , _basicInfo)
        {

            if(_companyObject.companyId!=''){

                $http({
                    method: 'POST',
                    url: '/inventory-management/findByCompanyId',
                    data : JSON.stringify(_companyObject),
                }).then(function (response)
                {

                    var response = response.data.data;

                    _basicInfo.company = response.company ;

                }, function (err)
                {
                    console.log(err);
                    alert("ERROR: " + err.data.error);
                });

            }

        },
    };


}]);
