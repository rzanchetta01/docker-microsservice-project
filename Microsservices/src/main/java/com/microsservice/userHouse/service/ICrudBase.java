package com.microsservice.userHouse.service;

import java.util.Collection;
import java.util.Optional;

public interface ICrudBase <T>{
    Collection<T> getAll();
    Optional<T> getById(String id);
    void save(T obj);
    void update(T obj, String id);
    void delete(String id);
    boolean existId(String id);
    boolean existEmail(String email);
    boolean existUsername(String username);
}
