package com.microsservice.userHouse.db;

import com.microsservice.userHouse.models.UserCustomer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserCustomer, String> {

    Optional<UserCustomer> findByUsername(String username);
    Optional<UserCustomer> findByEmail(String email);
}
