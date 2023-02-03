package com.microsservice.userHouse.db;

import com.microsservice.userHouse.models.BaseUser;
import com.microsservice.userHouse.models.UserCustomer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserCustomer, String> {

    Optional<UserCustomer> findById(String id);
    Optional<UserCustomer> findByUsername(String username);
    Optional<UserCustomer> findByEmail(String email);
}
