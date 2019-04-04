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
                .success(function(d) {
                    $scope.message = "Upload Successful!";
                    $scope.successmessagebox = true;
                    console.log(d);
                })
        }
    }
])