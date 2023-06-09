package com.example.exercise_1.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T>fillAll();
    Optional<T>fillById(Long id);
    void save(T t);
    void remove(Long  id);


}
