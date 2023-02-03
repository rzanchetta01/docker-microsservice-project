package com.microsservice.userHouse.service.impl;

import com.microsservice.userHouse.db.UserRepository;
import com.microsservice.userHouse.models.UserCustomer;
import com.microsservice.userHouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService implements IUserService<UserCustomer> {

    @Autowired
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        //TODO DEPENDENCY INJECTION
        this.repository = repository;
    }

    @Override
    public Collection<UserCustomer> getAll() {
       return repository.findAll();
    }

    @Override
    public Optional<UserCustomer> getById(String id) {
        //TODO GET BY ID LOGIC
        return repository.findById(id);
    }

    @Override
    public void save(UserCustomer obj) {
        //TODO SAVE LOGIC

        if(!existId(obj.getId()) && !existUsername(obj.getUsername()) && !existEmail(obj.getEmail()))
            repository.save(obj);
    }

    @Override
    public void update(UserCustomer obj, String id) {
        //TODO UPDATE LOGIC
        delete(id);
        repository.save(obj);
    }

    @Override
    public void delete(String id) {
        //TODO DELETE LOGIC
        if(existId(id))
            repository.delete(getById(id).get());
    }

    @Override
    public boolean existId(String id) {
       return repository.findById(id).isPresent();
    }

    @Override
    public boolean existEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }

    @Override
    public boolean existUsername(String username) {
        return repository.findByUsername(username).isPresent();
    }
}
