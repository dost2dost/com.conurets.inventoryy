/**
 * Created by Dost M. Soomro on 4/4/2019.
 */


app.directive('fileInput', ['$parse', function($parse) {
    return {
        restrict: 'A',
        link: function(scope, elm, attrs) {
            elm.bind('change', function() {
                $parse(attrs.fileInput)
                    .assign(scope, elm[0].files)
                scope.$apply()
            });
        }
    }
}]);
app.controller("ctrl", ['$scope', '$http',
    function($scope, $http) {
        $scope.filesChanged = function(elm) {
            $scope.files = elm.files
            $scope.$apply();
        }
        $scope.upload = function() {
            var fd = new FormData()
            angular.forEach($scope.files, function(file) {
                fd.append('file', file)
            })
            $http.post('/inventory-management/uploadf', fd, {
                transformRequest: angular.identity,
                headers: {
                    'Content-Type': undefined
                }
            })
                .then(function(d) {
                   // $scope.message = "Upload Successful!";
                    //$scope.successmessagebox = true;
                    //myJsonData = d;
                    $scope.bulkimport=d.data.data;
                    $scope.jtest($scope.bulkimport);

                    console.log(d);
                })
        }


        $scope.saveBulk=function () {
                var basicinfodata=JSON.stringify($scope.bulkimport);
                $http({
                    method: 'POST',
                    url: '/inventory-management/saveBulk',
                    data: basicinfodata,
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

            alert("test for bulk");
        }
        $scope.jtest=function (_data) {
            $scope.bulkimport=_data;

        }

    }



]);