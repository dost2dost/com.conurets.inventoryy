package com.conurets.inventory.dao.impl;

import com.conurets.inventory.dao.LoginUserDAO;
import com.conurets.inventory.entity.LoginUser;
import com.conurets.inventory.exception.EntityNotFoundException;
import com.conurets.inventory.exception.InvalidDataException;
import com.conurets.inventory.exception.InventoryException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 */

@Repository
public class LoginUserDAOImpl extends BaseDAOImpl<LoginUser> implements LoginUserDAO {

    private static final Logger logger = LoggerFactory.getLogger(LoginUserDAOImpl.class);


    public LoginUser findByEmail(String emailId) throws InventoryException {


        if(emailId.equals(null)){

            throw new EntityNotFoundException(101,"Email cannot be empty. Please enter Email Id");

        }

        Criteria createCriteria = createEntityCriteria();
        createCriteria.add(Restrictions.eq("emailId",emailId));

        LoginUser loginUser = (LoginUser) createCriteria.uniqueResult();

        if(loginUser==null){

            throw new InvalidDataException(120,"Invalid Email. Please enter correct Email");

        }
        return loginUser;

    }


    public LoginUser login(LoginUser loginUser) throws InventoryException {

        LoginUser emailExist = findByEmail(loginUser.getEmail());

         if(loginUser.getPassword().equals(null)){

            throw new EntityNotFoundException(101,"Password cannot be empty. Please enter Password");

        }else if(!emailExist.getPassword().equals(loginUser.getPassword())){

             throw new InvalidDataException(120,"Password Mismatch. Please enter correct Password");

         }

        return emailExist;
    }

}