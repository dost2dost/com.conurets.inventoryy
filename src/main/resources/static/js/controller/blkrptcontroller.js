/**
 * Created by Dost M. Soomro on 4/3/2019.
 */

// app.controller('blkrptController', function ($scope, LoginService) {
//     $scope.loginForm = [];
//
//     $scope.login = function () {
//         localStorage.removeItem("USER_TOKEN");
//
//         let loginObject = {
//             username: $scope.loginForm.username,
//             password: $scope.loginForm.password
//         };
//
//         LoginService.verifyLogin(loginObject);
//     };
// });

// app.controller('ctrl3', function ($scope){
//
//     $scope.bulkimport = [
//         [
//             "3/11/2019",
//             "System Architect",
//
//         ],
//         [
//             "3/11/2019",
//             "System Architect",
//
//         ],
//         [
//             "3/11/2019",
//             "System Architect",
//
//         ],
//         [
//             "3/11/2019",
//             "System Architect",
//
//         ],
//         [
//             "3/11/2019",
//             "System Architect",
//
//         ],
//
//
//     ]
//     $scope.upload=function () {
//         var file=$scope.myfile;
//         console.log('file is ' );
//         console.dir(file);
//         $scope.uploadFile(file);
//         //alert("test123"+file.)
//     }
//
//
//     $scope.uploadFile = function(files) {
//         var fd = new FormData();
//         //Take the first selected file
//         fd.append("file", files[0]);
//         var uploadUrl="inventory-management/upload";
//
//         $http.post(uploadUrl, fd, {
//             withCredentials: true,
//             headers: {'Content-Type': undefined },
//             transformRequest: angular.identity
//         }).success( "success").error("error!" );
//
//     };
// });