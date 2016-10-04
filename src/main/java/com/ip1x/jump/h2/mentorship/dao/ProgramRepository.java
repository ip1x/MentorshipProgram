package com.ip1x.jump.h2.mentorship.dao;

import com.ip1x.jump.h2.mentorship.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    Program findOneByName(String name);
}
