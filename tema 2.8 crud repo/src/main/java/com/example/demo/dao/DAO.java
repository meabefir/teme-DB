package com.example.demo.dao;

import java.util.Optional;

public interface DAO <T>{
    Optional<T> get(Integer id);
    void create(T t);
    void delete(T t);
    void update(T t);
}
