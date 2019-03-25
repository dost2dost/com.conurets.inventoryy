package com.conurets.inventory.util;

/**
 * @author MSA
 */

public interface InventoryConstants {
    public static final String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";
    public static final String JDBC_URL = "jdbc.url";
    public static final String JDBC_USER_NAME = "jdbc.username";
    public static final String JDBC_PASSWORD = "jdbc.password";
    public static final String JDBC_MIN_IDLE = "jdbc.minIdle";
    public static final String JDBC_MAX_IDLE = "jdbc.maxIdle";
    public static final String JDBC_INITIAL_SIZE = "jdbc.initialSize";
    public static final String JDBC_VALIDATION_QUERY = "jdbc.validationQuery";
    public static final String JDBC_DEFAULT_AUTO_COMMIT = "jdbc.defaultAutoCommit";

    public static final String HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    public static final String HIBERNATE_GLOBAL_QUOTED_IDENTIFIERS = "hibernate.globally_quoted_identifiers";

    public static final String ENTITY_PACKAGE = "com.conurets.inventory.entity";

    public static final int INT_ZERO = 0;
    public static final int INT_ONE = 1;
    public static final int INT_TWO = 2;
    public static final int INT_THREE = 3;
    public static final int INT_FOUR = 4;
    public static final int INT_FIVE = 5;
    public static final int INT_SIX = 6;
    public static final int INT_SEVEN = 7;
    public static final int INT_EIGHT = 8;
    public static final int INT_NINE = 9;
    public static final int INT_TEN = 10;
    public static final int INT_ELEVEN = 11;
    public static final int INT_TWELVE = 12;
    public static final int INT_THIRTEEN = 13;
    public static final int INT_FOURTEEN = 14;
    public static final int INT_FIFTEEN = 15;
    public static final int INT_SIXTEEN = 16;
    public static final int INT_SEVENTEEN = 17;
    public static final int INT_EIGHTEEN = 18;
    public static final int INT_NINETEEN = 19;
    public static final int INT_TWENTY = 20;
    public static final int INT_TWENTY_ONE = 21;
    public static final int INT_TWENTY_TWO = 22;
    public static final int INT_TWENTY_THREE = 23;
    public static final int INT_TWENTY_FOUR = 24;
    public static final int INT_TWENTY_FIVE = 25;
    public static final int INT_TWENTY_SIX = 26;
    public static final int INT_TWENTY_SEVEN = 27;
    public static final int INT_TWENTY_EIGHT = 28;

    public static final long LONG_ZERO = 0L;
    public static final long LONG_ONE = 1L;
    public static final long LONG_TWO = 2L;
    public static final long LONG_THREE = 3L;
    public static final long LONG_FOUR = 4L;
    public static final long LONG_FIVE = 5L;
    public static final long LONG_SIX = 6L;
    public static final long LONG_SEVEN = 7L;
    public static final long LONG_EIGHT = 8L;
    public static final long LONG_NINE = 9L;

    public static final String JAN_SHORT_CODE = "Jan";
    public static final String FEB_SHORT_CODE = "Feb";
    public static final String MAR_SHORT_CODE = "Mar";
    public static final String APR_SHORT_CODE = "Apr";
    public static final String MAY_SHORT_CODE = "May";
    public static final String JUN_SHORT_CODE = "Jun";
    public static final String JUL_SHORT_CODE = "Jul";
    public static final String AUG_SHORT_CODE = "Aug";
    public static final String SEP_SHORT_CODE = "Sep";
    public static final String OCT_SHORT_CODE = "Oct";
    public static final String NOV_SHORT_CODE = "Nov";
    public static final String DEC_SHORT_CODE = "Dec";

    public static final String STRING_ZERO = "0";
    public static final String STRING_ZERO_ONE = "01";
    public static final String STRING_ZERO_TWO = "02";
    public static final String STRING_ZERO_THREE = "03";
    public static final String STRING_ZERO_FOUR = "04";
    public static final String STRING_ZERO_FIVE = "05";
    public static final String STRING_ZERO_SIX = "06";
    public static final String STRING_ZERO_SEVEN = "07";
    public static final String STRING_ZERO_EIGHT = "08";
    public static final String STRING_ZERO_NINE = "09";
    public static final String START_DAY_TIME = " 12.00.00 AM";
    public static final String END_DAY_TIME = " 11.59.59 PM";

    public static final String SC_EMPTY = "";
    public static final String SC_SPACE = " ";
    public static final String SC_DASH = "-";
    public static final String SC_DOT = ".";
    public static final String SC_COLON = ":";
    public static final String SC_COLON_SPACE = ": ";
    public static final String SC_UNDER_SCORE = "_";
    public static final String SC_BACK_SLASH = "\\";
    public static final String SC_FORWARD_SLASH = "/";
    public static final String SC_DOUBLE_FORWARD_SLASH = "//";
    public static final String SC_AT_THE_RATE = "@";
    public static final String SC_GREATER_THAN = ">";
    public static final String SC_LESS_THAN = "<";
    public static final String SC_NULL = "null";

    public static final String AUTHORIZATION = "Authorization";
    public static final String AUTHORIZATION_BEARER = "Bearer";
    public static final String AUTHORIZATION_BEARER_SPACE = "Bearer ";

    public static final int STATUS_INACTIVE = 0;
    public static final int STATUS_ACTIVE = 1;

    public static final long DEFAULT_CREATED_BY = 1;

    // Status and error codes

    public static final int STATUS_CODE_SUCCESS = 0;
    public static final String STATUS_MSG_SUCCESS = "success";

    public static final int STATUS_CODE_FAIL = 1;
    public static final String STATUS_MSG_FAIL = "fail";

    public static final int STATUS_CODE_USER_ALREADY_EXISTS = 101;
    public static final String STATUS_MSG_USER_ALREADY_EXISTS = "Username already exists";
    public static final String STATUS_MSG_BASIC_INFO_ALREADY_EXISTS = "Basic Information already exists";

    public static final int STATUS_CODE_INVALID_INPUT_DATA = 120;
    public static final String STATUS_MSG_INVALID_INPUT_DATA = "Invalid input data";

    public static final int STATUS_CODE_INVALID_DATA = 121;
    public static final String STATUS_MSG_INVALID_DATA = "Invalid data";

    public static final int STATUS_CODE_UNKONWN = 9995;
    public static final String STATUS_MSG_UNKONWN = "Unknown error";
}