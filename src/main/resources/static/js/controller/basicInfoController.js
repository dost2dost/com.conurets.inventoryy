/**
 * Created by Iraj on 03/18/19.
 */


app.controller('basicInfoCtrl', function($scope,LocationService,CompanyService,ItemService,BasicInfoService)
{
    $scope.basicInfo ={};
    $scope.basicInfo.entryDate ='2019-10-10';
    $scope.basicInfo.userName ='Iraj Khan';
    $scope.basicInfo.userId= 1;
    $scope.basicInfo.location ='';
    $scope.basicInfo.company ='';
    $scope.basicInfo.companyId = 1;
    $scope.basicInfo.itemId ='';
    $scope.basicInfo.serialNo ='';
    $scope.basicInfo.qty ='';
    $scope.basicInfo.warranty ='';
    $scope.basicInfo.manufacturer ='abc123';
    //storage info
    $scope.basicInfo.storageLocation ='';
    $scope.basicInfo.storageOnShelf ='';
    $scope.basicInfo.shelfByNo ='';
    $scope.basicInfo.storedInCabnet ='';
    $scope.basicInfo.cabnetShelfNo ='';
    //SpecialHandling //

    $scope.basicInfo.spcialHandlinReq ='';
    $scope.basicInfo.specialHandlingNotes ='';
    $scope.basicInfo.approxWeight ='';

    //Calibrations
    $scope.basicInfo.calibrationRequired ='';
    $scope.basicInfo.calibratedDate ='';
    $scope.basicInfo.calibrationValidity ='';
    $scope.basicInfo.calibrationDueDate ='';

    $scope.basicInfo.itemNew ='';
    $scope.basicInfo.itemUsed ='';
    $scope.basicInfo.itemReconditioned ='';
    $scope.basicInfo.itemUseable ='';
    $scope.basicInfo.supplierId ='1';
    $scope.basicInfo.supplier_Rep_Id ='2';



    $scope.data = {

        availableOptions: [
            {id: '1', name: 'New'},
            {id: '2', name: 'Used'},
            {id: '3', name: 'Reconditioned'},
            {id: '4', name: 'Useable'}
        ]
    };

    /*
     $scope.cars = [
     {model : "Ford Mustang", color : "red"},
     {model : "Fiat 500", color : "white"},
     {model : "Volvo XC90", color : "black"}
     ];
     */
    //Supplier info
    $scope.basicInfo.supplier ='';
    $scope.basicInfo.supplierRepresentative ='';
    $scope.basicInfo.supplierRepresentativeMobile ='';
    $scope.basicInfo.supplierRepresentativeEmail ='';






    $scope.companyInfo ={};
    $scope.companyInfo.companyId = 1 ;
    $scope.companyInfo.companyName = '';
    $scope.companyInfo.representative ='';
    $scope.companyInfo.repEmail = '';

    $scope.checkboxModel = {
        date: true,
        location: true,
        venue: true,
        userName: true,
        companyName: true,
        itemDescription: true,
        itemID: true,
        serialNum: true,
        qtyUsed: true,

    };

    $scope.initializeBasicInfo = function(){
        LocationService.getAllLocations();

        //$scope.basicInfo.companyId =1;
        CompanyService.getCompanyDAO($scope.companyInfo,$scope.basicInfo);

        ItemService.getAllItems();



    };


    $scope.saveBasicInformation = function(){

       // alert("basicinfo is called ");
        BasicInfoService.saveInfoDAO($scope.basicInfo) ;
    };


    $scope.fetchBasicInfoDate = function() {

        //$scope.basicInfoRp = [];

        $scope.fromToDate = {
            startDate: moment().subtract(1, "days"),
            endDate: moment(),
            locale: {
                format: 'YYYY-M-DD'
            }

        };

        $scope.fetchBasicInfoRp();
    }

    $scope.fetchBasicInfoRp = function(){

        console.log(daterange2);

        BasicInfoService.fetchInfoRpDAO('');

    }

    $scope.testt = function() {
        alert("dtest");
        console.log($scope.basicInfo);

    }

});



