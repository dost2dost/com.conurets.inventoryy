package com.conurets.inventory.util;

import com.conurets.inventory.bean.ErrorResponse;
import com.conurets.inventory.entity.Role;
import com.conurets.inventory.exception.InvalidSessionException;
import com.conurets.inventory.model.CustomUserDetails;
import com.conurets.inventory.vo.BaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MSA
 */

public class InventoryUtil {
    private static final Logger logger = LoggerFactory.getLogger(InventoryUtil.class);

    /**
     * Create date time
     * @return timestamp
     */

    public static Timestamp currentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Convert string to integer
     * @param input
     * @return integer
     */

    public static int stringToInteger(String input) {
        int parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = Integer.parseInt(input);
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Convert string to long
     * @param input
     * @return long
     */

    public static long stringToLong(String input) {
        long parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = Long.parseLong(input);
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Convert string to double
     * @param input
     * @return double
     */

    public static double stringToDouble(String input) {
        double parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = Double.parseDouble(input);
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Convert long to double
     * @param input
     * @return double
     */

    public static double longToDouble(long input) {
        double parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = input;
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Current datetime in long
     * @return millisecond
     */

    public static final long getLongDateTime() {
        return System.currentTimeMillis();
    }

    public static final Timestamp getCurrentTimestamp() {
        return new Timestamp(getLongDateTime());
    }

    public static final Timestamp isObjectNull(Timestamp input) {
        return input == null ? null : input;
    }

    public static final String isObjectNull(String input) {
        return input == null ? InventoryConstants.SC_EMPTY : input;
    }

    public static final String nullObjectZero(String input) {
        return input == null ? InventoryConstants.STRING_ZERO : input;
    }

    public static final long isObjectNull(Long input) {
        return input == null ? InventoryConstants.LONG_ZERO : input;
    }

    public static final String isObjectEmpty(String input) {
        return input == null ? InventoryConstants.SC_EMPTY : input;
    }

    public static final boolean isStringEmpty(String input) {
        return InventoryConstants.SC_EMPTY.equals(input) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static final boolean isStringEmptyOrNull(String input) {
        return (InventoryConstants.SC_EMPTY.equals(input) || input == null) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * Set response bean
     * @param code
     * @param value
     * @return code and value from controller
     */

    public static BaseResponse<Object> setBaseResponse(int code, String value) {
        BaseResponse<Object> baseResponse = new BaseResponse<Object>();
        baseResponse.setCode(code);
        baseResponse.setValue(value);

        return baseResponse;
    }

    /**
     * Set response bean
     * @param code
     * @param value
     * @param data
     * @return code, value and data from controller
     */

    public static BaseResponse<Object> setBaseResponse(int code, String value, Object data) {
        BaseResponse<Object> baseResponse = new BaseResponse<Object>();
        baseResponse.setCode(code);
        baseResponse.setValue(value);
        baseResponse.setData(data);

        return baseResponse;
    }

    /**
     * Exception handling
     * @param code
     * @param value
     * @return exception error
     */

    public static ErrorResponse<Object> setErrorResponse(int code, String value) {
        ErrorResponse<Object> response = new ErrorResponse<Object>();
        response.setCode(code);
        response.setValue(value);

        return response;
    }

    /**
     * Validation error handling
     * @param code
     * @param value
     * @return error messages
     */

    public static ErrorResponse<Object> setErrorResponse(int code, BindingResult value) {
        ErrorResponse<Object> response = new ErrorResponse<Object>();
        response.setCode(code);
        response.setValue(value.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList()));

        return response;
    }

    public static Timestamp convertStringToTimestamp(String date){


        java.util.Date dt = null;
        java.sql.Date sqlTimeIn = null;
        java.sql.Timestamp timeStampDate = null;

        try{

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            dt = df.parse(date);
            sqlTimeIn = new java.sql.Date(dt.getTime());
            timeStampDate = new Timestamp(sqlTimeIn.getTime());

        }catch(ParseException ex){

            ex.printStackTrace();
        }

        return timeStampDate;
    }

    public static Date convertFromStringToDate(String date){

        java.util.Date dt =null;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {

            dt = df.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dt;
    }

    /**
     * Convert json object to string
     * @param object
     * @return json in string
     * @throws JsonProcessingException
     */

    public static String writeValue(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    /**
     * Convert json string to object
     * @param content
     * @param valueType
     * @param <T>
     * @return object
     * @throws IOException
     */

    public static <T> T readValue(String content, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(content, valueType);
    }

    /**
     * Get logged in username
     * @return username
     */

    public static String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = principal.toString();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        return username;
    }

    /**
     * Get logged in user details
     * @return user details
     */

    public static CustomUserDetails getUserDetails() {
        CustomUserDetails customUserDetails = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        }

        InventoryHelper.validateSession(customUserDetails);

        return customUserDetails;
    }

    /**
     * Set granted authority for access
     * @param privileges
     * @return list
     */

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    /**
     * Password hashing
     * @param plainPassword
     * @return encoded password
     */

    public static String generatePassword(final String plainPassword) {
        return new BCryptPasswordEncoder(InventoryConstants.INT_TWELVE).encode(plainPassword);
    }

    /**
     * Match db password with input password
     * @param loggedInPassword
     * @param oldPassword
     * @return boolean
     */

    public static Boolean currentPasswordMatches(String loggedInPassword, String oldPassword) {
        return new BCryptPasswordEncoder().matches(loggedInPassword, oldPassword);
    }

    public static void main(String[] args) {
        System.out.println(generatePassword("superuser"));
    }

    /**
     * Decode string input
     * @param input
     * @return decoded string
     */

    public static String decode(String input) {
        return StringUtils.newStringUtf8(Base64.decodeBase64(input));
    }

    /**
     * Encode string input
     * @param input
     * @return encoded string
     */

    public static String encode(String input) {
        return Base64.encodeBase64String(StringUtils.getBytesUtf8(input));
    }

    /**
     * Set JWT error
     * @param response
     * @param code
     * @param message
     * @throws IOException
     */

    public static void setJwtErrorResponse(HttpServletResponse response, int code, String message) throws IOException {
        ErrorResponse<Object> exceptionBean = InventoryUtil.setErrorResponse(code, message);

        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(InventoryUtil.writeValue(exceptionBean));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * Set user role list
     * @param role
     * @return list
     */

    public static List<String> setUserRole(Role role) {
        List<String> stringList = new ArrayList<>();
        stringList.add(role.getRoleName());

        return stringList;
    }

    /**
     * Get logged in user role by authorityList
     * @param authorityList
     * @return String
     */

    public static String getUserRole(Collection<? extends GrantedAuthority> authorityList) {
        for (GrantedAuthority grantedAuthority : authorityList) {
            return grantedAuthority.getAuthority();
        }

        return null;
    }

    /**
     * Get logged in user role
     * @return String
     */

    public static String getUserRole() {
        for (GrantedAuthority grantedAuthority : getUserDetails().getAuthorities()) {
            return grantedAuthority.getAuthority();
        }
        return null;
    }
}