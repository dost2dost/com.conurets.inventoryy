/**
 * Created by Dost M. Soomro on 4/24/2019.
 */
//var app = angular.module("CIMS",[]);
app.factory('Excel',function($window){
    var uri='data:application/vnd.ms-excel;base64,',
        template='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
        base64=function(s){return $window.btoa(unescape(encodeURIComponent(s)));},
        format=function(s,c){return s.replace(/{(\w+)}/g,function(m,p){return c[p];})};
    return {
        tableToExcel:function(tableId,worksheetName){
            var table=$(tableId),
                ctx={worksheet:worksheetName,table:table.html()},
                href=uri+base64(format(template,ctx));
            return href;
        }
    };
    $scope.currentPage = 1;
    $scope.pageSize = 5;
    var meals = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];

    function getPage(currentPage, pageSize, arr, reverse) {
        var beginIndex, endIndex, noOfPages;

        if(reverse) {
            beginIndex = arr.length - currentPage * pageSize;
        } else {
            beginIndex = currentPage * pageSize - pageSize;
        }

        endIndex = beginIndex + pageSize;
        beginIndex = beginIndex < 0 ? 0 : beginIndex;
        return arr.slice(beginIndex, endIndex)};
    //This will return the 5 elements in page 1 of meals array which will be meals 11 to 15 since the array is bound to the pagination directive in the reverse (desc) order
    $scope.firstFiveArrRev = getPage($scope.currentPage, $scope.pageSize, meals, true);

    //This will return the 5 elements in page 1 of meals array which will be meals 1 to 5 since the array is bound to the pagination directive in ascending order
    $scope.firstFiveArr = getPage($scope.currentPage, $scope.pageSize, meals, false);
})



//
app.controller('reportCtrl', function ($scope, ReportService,Excel,$timeout) {

    $scope.fetchReport=function () {

        ReportService.fetchInfoRpDAO(2019-4-24-2019-4-25);
    }
    $scope.exportToExcel=function(tableId){ // ex: '#my-table'
        var exportHref=Excel.tableToExcel(tableId,'SimpleDataExport');
        $timeout(function(){location.href=exportHref;},100); // trigger download
    }
    //for pdf
    $scope.Export = function () {
        html2canvas(document.getElementById('reportTable'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500
                    }]
                };
                pdfMake.createPdf(docDefinition).download("Table.pdf");
            }
        });
    }

    $scope.addMeal = function(meal) {
        if (meal) {
            if ($scope.page.length === $scope.pageSize + 1) {
                $scope.page = [];
            }
            $scope.page.push(meal);
        }
    }

    $scope.sendEmail=function () {

        //emailTo  emailFrom emailSubject emailContent
        $scope.mail={};
        $scope.mail.emailTo="dost.soomro@conurets.com";
        $scope.mail.emailFrom="from@conure.com";
        $scope.mail.emailFrom="Subject Test";
        $scope.mail.emailContent="Content Body";
        //console.log(JSON.stringify($scope.mail));

       ReportService.sendEmailDAO(JSON.stringify($scope.mail));
        alert("send email");
    }
    $scope.daterangePicker=function () {
        $('input[name="daterange"]').daterangepicker({
            opens: 'left'
        }, function(start, end, label) {
            console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
        });
        
    }
        /*
        Paging start
         */


        /*
        Paging endt
         */

});