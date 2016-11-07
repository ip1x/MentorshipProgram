package com.ip1x.jump.h2.mentorship.util;

import com.ip1x.jump.h2.mentorship.model.User;
import com.ip1x.jump.h2.mentorship.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdToUserConverter implements Converter<String, User> {
    @Autowired
    private UserService userService;

    @Override
    public User convert(String userStrId) {
        try {
            long id = Long.parseLong(userStrId);
            return userService.findById(id);
        }catch (RuntimeException e){
            return null;
        }
    }
}
