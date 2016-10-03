package com.ip1x.jump.h2.mentorship.aspect;

import com.ip1x.jump.h2.mentorship.entity.User;
import com.ip1x.jump.h2.mentorship.service.impl.UserService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Component
@Aspect
public class TrackingAspect {

    static final Logger logger = Logger.getLogger(TrackingAspect.class);

    @Autowired
    UserService userService;

    @Pointcut("execution(* com.ip1x.jump.h2.mentorship.controller.UserController.addUser(..))")
    public void saveModel() {}

    @Pointcut("execution(* com.ip1x.jump.h2.mentorship.controller.UserController.editUser(..))")
    public void editModel() {}

    @Before("saveModel()")
    public void addCreateDate(JoinPoint joinPoint) {
        User user = (User)joinPoint.getArgs()[0];
        user.setCreateDate(LocalDate.now());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        user.setCreatedByUserWithIp(request.getRemoteAddr());
    }

    @Before("editModel()")
    public void addModifyDate(JoinPoint joinPoint) {
        User user = (User)joinPoint.getArgs()[0];
        User dbUser = userService.findById(user.getId());
        setCreateSystemDataFromFirstUserToSecond(dbUser, user);
        user.setModifyDate(LocalDate.now());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        user.setModifiedByUserWithIp(request.getRemoteAddr());
    }

    private void setCreateSystemDataFromFirstUserToSecond(User first, User second){
        second.setCreateDate(first.getCreateDate());
        second.setCreatedByUserWithIp(first.getCreatedByUserWithIp());
    }
}
