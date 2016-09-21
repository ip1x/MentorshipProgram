package com.ip1x.jump.h2.mentorship.service;

import java.io.Serializable;
import java.util.List;

public interface GeneralService<T, ID extends Serializable> {
    public T save(T entity);

    public void delete(T entity);

    public T findById(ID entityId);

    public List<T> findAll();

}
