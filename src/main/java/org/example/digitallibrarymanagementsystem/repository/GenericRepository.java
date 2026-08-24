package org.example.digitallibrarymanagementsystem.repository;

import java.util.Optional;

public interface GenericRepository<T, ID> {
    T save(T t);

    Optional<T> findById(T t,ID id);

    void update(T t, ID id);

    void delete(ID id);
}
