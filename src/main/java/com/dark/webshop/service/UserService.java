package com.dark.webshop.service;

import com.dark.webshop.service.model.UserModel;

public interface UserService {
    UserModel registerNewUserAccount(UserModel userModel);

    UserModel updateUserAccount(UserModel userModel);

    boolean userPasswordIsValid(UserModel userModel);
}