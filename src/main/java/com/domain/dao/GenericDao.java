package com.domain.dao;

import java.util.List;

public interface GenericDao<T> {
    void create(T newInstance);

    T read(Long id);

    void update(T transientObject);

    void delete(T persistentObject);

    List<T> getAll();
}
