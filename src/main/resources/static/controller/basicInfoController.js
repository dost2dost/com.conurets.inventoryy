/**
 * Created by Iraj on 03/18/19.
 */


app.controller('basicInfoCtrl', function($scope,LocationService,CompanyService,ItemService,BasicInfoService)
{
    $scope.basicInfo ={};
    $scope.basicInfo.entryDate ='';
    $scope.basicInfo.userName ='Iraj Khan';
    $scope.basicInfo.userId= 1
    $scope.basicInfo.location ='';
    $scope.basicInfo.company ='';
    $scope.basicInfo.companyId = 1;
    $scope.basicInfo.itemId ='';
    $scope.basicInfo.serialNo ='';
    $scope.basicInfo.qty ='';
    $scope.basicInfo.manufacturer ='abc123';


    $scope.companyInfo ={};
    $scope.companyInfo.companyId = 1 ;
    $scope.companyInfo.companyName = '';
    $scope.companyInfo.representative ='';
    $scope.companyInfo.repEmail = ''

    $scope.initializeBasicInfo = function(){

        LocationService.getAllLocations();

        //$scope.basicInfo.companyId =1;
        CompanyService.getCompanyDAO($scope.companyInfo,$scope.basicInfo);

        ItemService.getAllItems();

    };


    $scope.saveBasicInformation = function(){

        BasicInfoService.saveInfoDAO($scope.basicInfo) ;
    };



});



