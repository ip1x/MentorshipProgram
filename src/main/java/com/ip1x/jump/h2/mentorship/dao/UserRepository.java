package com.ip1x.jump.h2.mentorship.dao;

import com.ip1x.jump.h2.mentorship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);
    User findOneByEmail(String email);
}
