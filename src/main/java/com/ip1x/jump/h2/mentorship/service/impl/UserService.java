package com.ip1x.jump.h2.mentorship.service.impl;

import com.ip1x.jump.h2.mentorship.dao.UserRepository;
import com.ip1x.jump.h2.mentorship.entity.User;
import com.ip1x.jump.h2.mentorship.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements GeneralService<User, Long> {
    @Autowired
    UserRepository userRepository;

    public User save(User entity) {
        return userRepository.save(entity);
    }

    public void delete(User entity) {
        userRepository.delete(entity);
    }

    public User findById(Long entityId) {
        return userRepository.findOneById(entityId);
    }

    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}