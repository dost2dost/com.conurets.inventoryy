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
app.controller('ctrl', ['$scope', '$http',
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
            $http.post('http://localhost:6080/inventory-management/uploadf', fd, {
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


        $scope.jtest=function (_data) {
            $scope.bulkimport=_data;
            // [
            //     [
            //         "Atlanta", "Marta", "Remote Unit", "1", "High Power Remote Unit", "ABS001DECFG", "JMA", "1/5/2019", "Jorge Luengo", "Conure", "1", "Yes", "6/30/2020","Garnett Headend","Yes","3 / A","No","3","Yes","Need minimum of 2 persons to lift","50 lbs","Yes","11/15/2018","18 months","5/28/2020","No","Yes","No","JMA","John Fletcher","4043561254","JohnFletcher@Jma.com","1/20/2019","F2347652345","1/20/2019","Power was shutting down abruptly","Refer to the location and determine if trolley is required to transport the unit",
            //     ],
            //     [
            //         "Atlanta", "Marta", "Remote Unit", "1", "High Power Remote Unit", "ABS001DECFG", "JMA", "1/5/2019", "Jorge Luengo", "Conure", "1", "Yes", "6/30/2020","Garnett Headend","Yes","3 / A","No","3","Yes","Need minimum of 2 persons to lift","50 lbs","Yes","11/15/2018","18 months","5/28/2020","No","Yes","No","JMA","John Fletcher","4043561254","JohnFletcher@Jma.com","1/20/2019","F2347652345","1/20/2019","Power was shutting down abruptly","Refer to the location and determine if trolley is required to transport the unit",
            //     ]];
        }

    }



]);