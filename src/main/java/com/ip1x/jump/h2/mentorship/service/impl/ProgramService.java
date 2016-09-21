package com.ip1x.jump.h2.mentorship.service.impl;

import com.ip1x.jump.h2.mentorship.dao.ProgramRepository;
import com.ip1x.jump.h2.mentorship.entity.Program;
import com.ip1x.jump.h2.mentorship.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService implements GeneralService<Program, Long> {
    @Autowired
    private ProgramRepository programRepository;

    public Program save(Program entity) {
        return programRepository.save(entity);
    }

    public void delete(Program entity) {
        programRepository.delete(entity);
    }

    public Program findById(Long entityId) {
        return programRepository.findOne(entityId);
    }

    public Program findOneByName(String name){
        return programRepository.findOneByName(name);
    }

    public List<Program> findAll() {
        return programRepository.findAll();
    }
}
