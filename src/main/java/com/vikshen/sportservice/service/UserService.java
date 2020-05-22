package com.vikshen.sportservice.service;


import com.vikshen.sportservice.entity.User;

public interface UserService {

    User authorization(String username, String password);

    User addUser (User user);
}
