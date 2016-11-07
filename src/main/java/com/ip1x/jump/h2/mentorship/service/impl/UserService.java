package com.ip1x.jump.h2.mentorship.service.impl;

import com.ip1x.jump.h2.mentorship.dao.UserRepository;
import com.ip1x.jump.h2.mentorship.model.User;
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

    public List<User> findMentorsWithMoreThan2Mentees() { return  userRepository.findMentorsWithMoreThan2Mentees(); }

    public List<User> findUsersWithoutMentor() { return  userRepository.findUsersWithoutMentor();}

    public List<User> findMentors() { return  userRepository.findMentors();}

    public void deleteById(Long id){ userRepository.delete(id);}
}
