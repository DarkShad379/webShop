package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.user.User;
import com.dark.webshop.repository.UserRepository;
import com.dark.webshop.service.model.UserModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class UserMapperResolver {

    UserRepository userRepository;

    public UserMapperResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ObjectFactory
    public User resolve(UserModel userModel, @TargetType Class<User> type) {
        return userModel != null && userModel.getId() != null && userRepository.findById(userModel.getId()).isPresent()
                ? userRepository.findById(userModel.getId()).get() : new User();
    }

}
