/**
 * Created by Iraj on 03/20/19.
 */


let REPORTING = 'reporting';

let DATE_TIME_FORMAT_DAY_DD_MMM_YYYY_HH_MM_SS_AM_PM = 'ddd, DD-MMM-YYYY hh:mm:ss A';
let DATE_TIME_FORMAT_DD_MM_YYYY_HH_MM_AM_PM = 'DD-MM-YYYY hh:mm A';
let DATE_TIME_FORMAT = DATE_TIME_FORMAT_DD_MM_YYYY_HH_MM_AM_PM;

let DATE_FORMAT_MM_DD_YYYY_SLASH = 'MM/DD/YYYY';
let DATE_FORMAT = 'DD-MMM-YYYY';
let TIME_FORMAT = 'hh:mm A';

var SC_EMPTY = '';
var SC_SPACE = ' ';
var SC_DOT = '.';
var SC_DASH = '-';
var SC_COMMA = ',';
var SC_UNDER_SCORE = '_';

var NUMBER_ZERO = 0;
var NUMBER_ONE = 1;
var NUMBER_TWO = 2;
var NUMBER_THREE = 3;
var NUMBER_FOUR = 4;
var NUMBER_FIVE = 5;
var NUMBER_SIX = 6;
var NUMBER_SEVEN = 7;
var NUMBER_EIGHT = 8;
var NUMBER_NINE = 9;
var NUMBER_TEN = 10;
var NUMBER_ELEVEN = 11;
var NUMBER_TWELVE = 12;
var NUMBER_THIRTEEN = 13;
var NUMBER_FOURTEEN = 14;
var NUMBER_FIFTEEN = 15;


function isNumeric(_element, _event)
{
    var _char = String.fromCharCode(_event.charCode);
    var containsDecimalPoint = /\./.test(_element.value);
    var containsMinusSign = /\-/.test(_element.value);

    return (_event.charCode === 0 || /\d/.test(_char)) || (!containsDecimalPoint && /\./.test(_char)) || (!containsMinusSign && /\-/.test(_char));
}

function showDateAndClock()
{
    return moment(new Date().time).format(DATE_TIME_FORMAT_DAY_DD_MMM_YYYY_HH_MM_SS_AM_PM);
}



function getNthDate(nthDate)
{
    let currentDate = new Date();
    currentDate.setDate(currentDate.getDate() + nthDate);

    return currentDate;
}