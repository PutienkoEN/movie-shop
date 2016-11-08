package com.domain.dao;

import java.io.Serializable;

public interface GenericDao<T> {
    void create(T newInstance);

    T read(Long id);

    void update(T transientObject);

    void delete(T persistentObject);
}
