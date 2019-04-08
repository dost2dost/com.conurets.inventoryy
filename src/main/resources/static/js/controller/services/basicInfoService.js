/**
 * Created by Iraj on 03/20/19.
 */

app.service('BasicInfoService', ['$rootScope', '$http', function($rootScope, $http)
{


    return {

        validateInfoDAO: function (_dataObject) {

            var isDataValidated = true;

            /*   if (_dataObject.entryDate.$valid ==true) {

             alert("Please Select Date.");
             isDataValidated = false;


             }else if (_dataObject.locationId.$valid ==true ) {

             alert("Please Select Location.");
             isDataValidated = false;

             }else if (_dataObject.itemId.$valid ==true) {

             alert("Please Select Item.");
             isDataValidated = false;

             }else if (_dataObject.serialNo.$valid ==true) {

             alert("Please Enter Serial No.");
             isDataValidated = false;

             }else if (_dataObject.qty.$valid ==true) {
             alert("Please Enter Qty.");
             isDataValidated = false;
             }*/

            return isDataValidated;
        },

        saveInfoDAO: function (_dataObject) {

            // var _isDataValidated = this.validateInfoDAO(_dataObject);


            /*if (_isDataValidated)
             {} */
            $http({
                method: 'POST',
                url: '/inventory-management/saveBasicInfo',
                data: JSON.stringify(_dataObject),
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json',
                    'Authorization': 'Bearer '+ localStorage.getItem("INV_USER_TOKEN")
                },
            }).then(function (response) {

                if (response.data.code == 0) {

                    alert('Basic Information Saved Successfully!');

                } else if (response.data.code == 101) {

                    alert('Basic Information Already Exists!');
                }


            }, function (err) {
                console.log(err);
                alert("Error In Saving Basic Information.");
            });
        },

        fetchInfoRpDAO: function (_basicInfoFrmToDt ) {


            $rootScope.basicInfoRp = [];

            var dt = $('#daterange2').val();

            $http({
                method: 'GET',
                url: '/inventory-management/fetchBasicInfoReport/?fromDate=2019-03-21&toDate=2019-03-22', //+$scope.toDt ,
                dataType: 'json',
                headers : {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json',
                    'Authorization': 'Bearer '+ localStorage.getItem("INV_USER_TOKEN")
                },
            }).then(function (rsp) {

                console.log(rsp);

                $rootScope.basicInfoRp = rsp.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });


        }

    }

}]);