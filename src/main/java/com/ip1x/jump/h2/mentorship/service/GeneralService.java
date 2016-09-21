package com.ip1x.jump.h2.mentorship.service;

import java.io.Serializable;
import java.util.List;

public interface GeneralService<T, ID extends Serializable> {
    T save(T entity);

    void delete(T entity);

    T findById(ID entityId);

    List<T> findAll();

    void deleteById(Long id);

}
