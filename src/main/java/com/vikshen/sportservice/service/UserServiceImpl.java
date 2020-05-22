package com.vikshen.sportservice.service;

import com.vikshen.sportservice.entity.Role;
import com.vikshen.sportservice.entity.User;
import com.vikshen.sportservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authorization(String username, String password) {
        return userRepository.authority(username, password);
    }

    @Override
    @Transactional
    public User addUser(User user) {
        user.setId(0);
        user.getRoles().get(0).setId(1);
        userRepository.save(user);
        return user;
    }
}
