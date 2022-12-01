package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.user.User;
import com.dark.webshop.database.repository.UserRepository;
import com.dark.webshop.exception_handling.EntryAlreadyExistException;
import com.dark.webshop.service.UserService;
import com.dark.webshop.service.mapper.UserServiceMapper;
import com.dark.webshop.service.model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserServiceMapper userServiceMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserModel findUserByUsername(String username) {
        return userServiceMapper.entityToModel(userRepository.findByUsername(username));
    }

    @Override
    public boolean userExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public UserServiceImpl(UserRepository userRepository, UserServiceMapper userServiceMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userServiceMapper = userServiceMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userPasswordIsValid(UserModel userModel) {
        User user = userRepository.findByUsername(userModel.getUsername());
        return passwordEncoder.matches(userModel.getPassword(), user.getPassword());
    }

    @Override
    public UserModel registerNewUserAccount(UserModel userModel) throws EntryAlreadyExistException {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setUsername(userModel.getUsername().toLowerCase(Locale.ROOT));
        if (userExist(userModel.getUsername())) {
            throw new EntryAlreadyExistException("There is an account with that username: "
                    + userModel.getUsername());
        }
        User user = userServiceMapper.modelToEntity(userModel);
        User registeredUser = userRepository.save(user);
        return userServiceMapper.entityToModel(registeredUser);
    }

    @Override
    public UserModel updateUserAccount(UserModel userModel) {
        User user = userServiceMapper.modelToEntity(userModel);
        User registeredUser = userRepository.save(user);
        return userServiceMapper.entityToModel(registeredUser);
    }

}