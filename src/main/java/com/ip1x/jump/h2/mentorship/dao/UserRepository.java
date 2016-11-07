package com.ip1x.jump.h2.mentorship.dao;

import com.ip1x.jump.h2.mentorship.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);
 
    User findOneByEmail(String email);

    @Query("select u from User u where u.mentees.size >= 2")
    List<User> findMentorsWithMoreThan2Mentees();

    @Query("select u from User u where u.mentor is null")
    List<User> findUsersWithoutMentor();

    @Query("select u from User u where u.isMentor = true")
    List<User> findMentors();
}
