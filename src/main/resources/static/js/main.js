var app = angular.module("CIMS", ['ui.utils']);

app.directive("datepicker", function () {
    return {
        restrict: "A",
        link: function (scope, el, attr) {
            el.datepicker({
                dateFormat: 'yy-mm-dd'
            });
        }
    };
});


app.controller("form", function ($scope) {

});


app.controller('ctrl1', function ($scope) {

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

    $scope.data = [
        [
            "3/11/2019",
            "System Architect",
            "Edinburgh",
            "Ali",
            "Conure Telecom",
            "Lorem Ipsum",
            "61",
            "4324324",
            "34"
        ],
        [
            "3/11/2019",
            "System Architect",
            "Edinburgh",
            "Ali",
            "Conure Telecom",
            "Lorem Ipsum",
            "61",
            "4324324",
            "34"
        ],
        [
            "3/11/2019",
            "System Architect",
            "Edinburgh",
            "Ali",
            "Conure Telecom",
            "Lorem Ipsum",
            "61",
            "4324324",
            "34"
        ],
        [
            "3/11/2019",
            "System Architect",
            "Edinburgh",
            "Ali",
            "Conure Telecom",
            "Lorem Ipsum",
            "61",
            "4324324",
            "34"
        ],
        [
            "3/11/2019",
            "System Architect",
            "Edinburgh",
            "Ali",
            "Conure Telecom",
            "Lorem Ipsum",
            "61",
            "4324324",
            "34"
        ],


    ]


});

app.controller('ctrl2', function ($scope) {

    $scope.data2 = [
        [
            "3/11/2019",
            "System Architect",

        ],
        [
            "3/11/2019",
            "System Architect",

        ],
        [
            "3/11/2019",
            "System Architect",

        ],
        [
            "3/11/2019",
            "System Architect",

        ],
        [
            "3/11/2019",
            "System Architect",

        ],


    ]


});

