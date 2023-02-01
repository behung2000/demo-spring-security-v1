package com.demospringsecurityv1.springsecurity.services;

import com.demospringsecurityv1.springsecurity.Utils.EntityMapper;
import com.demospringsecurityv1.springsecurity.models.User;
import com.demospringsecurityv1.springsecurity.repositories.UserRepository;
import com.demospringsecurityv1.springsecurity.requests.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<UserInfo> getAll() {
        List<User> users = repository.findAll();
        EntityMapper entityMapper = new EntityMapper();
        return entityMapper.toUserInfos(users);
    }
}
