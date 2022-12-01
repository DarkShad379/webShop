package com.dark.webshop.service;

import com.dark.webshop.service.model.UserModel;

public interface UserService {
    UserModel findUserByUsername(String username);

    UserModel registerNewUserAccount(UserModel userModel);

    UserModel updateUserAccount(UserModel userModel);

    boolean userExist(String username);

    boolean userPasswordIsValid(UserModel userModel);
}