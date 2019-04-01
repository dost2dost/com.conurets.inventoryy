package com.conurets.inventory.service.impl;

import com.conurets.inventory.configuration.security.jwt.JwtTokenFactory;
import com.conurets.inventory.converter.LoginConvertor;
import com.conurets.inventory.dao.factory.DAOFactory;
import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.entity.User;
import com.conurets.inventory.entity.UserRole;
import com.conurets.inventory.model.CustomUserDetails;
import com.conurets.inventory.service.CustomUserDetailsService;
import com.conurets.inventory.util.InventoryConstants;
import com.conurets.inventory.util.InventoryHelper;
import com.conurets.inventory.util.InventoryUtil;
import com.conurets.inventory.vo.LoginUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author MSA
 */

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Autowired
    private DAOFactory daoFactory;
    @Autowired
    private JwtTokenFactory jwtTokenFactory;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LoginConvertor loginConvertor;

    /**
     * Checking @Autowired object
     */

    @PostConstruct
    public void checkConfiguration() {
        InventoryHelper.checkConfiguration(daoFactory, "daoFactory");
        InventoryHelper.checkConfiguration(jwtTokenFactory, "jwtTokenFactory");
        InventoryHelper.checkConfiguration(authenticationManager, "authenticationManager");
        InventoryHelper.checkConfiguration(loginConvertor, "loginConvertor");
    }

    /**
     * Verufy username and authorities
     * @param username
     * @return user details
     * @throws UsernameNotFoundException
     */

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = setCustomUserDetails(username, null, Boolean.FALSE);

        return customUserDetails;
    }

    /**
     * Verify user credentials
     * @param username
     * @param password
     * @return token, user id, user name, company id, company name
     */

    public LoginUserVO login(String username, String password) {
        final Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        CustomUserDetails customUserDetails = setCustomUserDetails(username, authentication, Boolean.TRUE);

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

        InventoryHelper.checkNullOrEmpty(authenticationToken, InventoryConstants.STATUS_CODE_INVALID_TOKEN, InventoryConstants.STATUS_MSG_INVALID_TOKEN);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        LoginUserVO loginUserVO = loginConvertor.toController(customUserDetails);

        return loginUserVO;
    }

    /**
     * Verify and set user details
     * @param username
     * @param authentication
     * @param isLoginService
     * @return user details
     */

    private CustomUserDetails setCustomUserDetails(String username, Authentication authentication, boolean isLoginService) {
        CustomUserDetails customUserDetails = null;

        User user = daoFactory.getUserDAO().findByKeyValue("username", username);

        InventoryHelper.checkNullOrEmpty(user, InventoryConstants.STATUS_CODE_NO_USER_FOUND, InventoryConstants.STATUS_MSG_NO_USER_FOUND);

        LoginUser loginUser = daoFactory.getLoginUserDAO().findByUserId(user.getUserId());

        InventoryHelper.checkNullOrEmpty(loginUser, InventoryConstants.STATUS_CODE_NO_CREDENTIAL_FOUND, InventoryConstants.STATUS_MSG_NO_CREDENTIAL_FOUND);

        UserRole userRole = daoFactory.getUserRoleDAO().findUserRoleByUserId(user.getUserId());

        InventoryHelper.checkNullOrEmpty(loginUser, InventoryConstants.STATUS_CODE_NO_CREDENTIAL_FOUND, InventoryConstants.STATUS_MSG_NO_CREDENTIAL_FOUND);

        List<String> strList = InventoryUtil.setUserRole(userRole.getRole());

        //List<String> strList = Arrays.asList(RoleEnum.ROLE_USER.name());

        List<GrantedAuthority> authorities = InventoryUtil.getGrantedAuthorities(strList);

        if (isLoginService) {
            final String token = jwtTokenFactory.createJwtToken(authentication);

            customUserDetails = new CustomUserDetails(username, loginUser.getPassword(), authorities,
                    user.getUserId(), user.getCompany().getCompanyId(), token);
        } else {
            customUserDetails = new CustomUserDetails(username, loginUser.getPassword(), authorities,
                    user.getUserId(), user.getCompany().getCompanyId());
        }

        InventoryHelper.checkNullOrEmpty(customUserDetails, InventoryConstants.STATUS_CODE_INVALID_USER_DETAIL, InventoryConstants.STATUS_MSG_INVALID_USER_DETAIL);

        return customUserDetails;
    }
}