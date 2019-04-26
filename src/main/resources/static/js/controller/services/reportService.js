/**
 * Created by Iraj on 03/18/19.
 */

app.service('ReportService', ['$rootScope', '$http', function($rootScope, $http) {
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
        fetchInfoRpDAO: function (_basicInfoFrmToDt ) {



            $rootScope.basicInfoRp = [];

            var dt = $('#daterange2').val();

            $http({
                method: 'GET',
                url: '/inventory-management/fetchBasicInfoReport/?fromDate=2019-04-24&toDate=2019-04-25', //+$scope.toDt ,
                dataType: 'json',
                contentType: "application/json"
            }).then(function (rsp) {

                console.log(rsp);

                $rootScope.basicInfoRp = rsp.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });


        },
        sendEmailDAO: function (_basicInfoFrmToDt ) {

        //@RequestParam("file") MultipartFile file

            $rootScope.basicInfoRp = [];

            //var dt = $('#daterange2').val();

            $http({
                method: 'POST',
                //url: '/inventory-management/fetchBasicInfoReport/?fromDate=2019-10-10&toDate=2019-10-22', //+$scope.toDt ,
                url: '/inventory-management/sendEmails', //+$scope.toDt ,
                dataType: 'json',
                data:_basicInfoFrmToDt,
                contentType: "application/json"
            }).then(function (rsp) {

                console.log(rsp);

                $rootScope.gMessage = rsp.data.data;

            }, function (err) {
                alert("ERROR: " + err.data.error);
            });


        }
    };

}]);