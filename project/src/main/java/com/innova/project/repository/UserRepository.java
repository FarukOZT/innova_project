package com.innova.project.repository;

import com.innova.project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository <User, Long> {
    User getByTckn(Long tckn);
    User getByTcknAndPassword(Long tckn, String password);
}
