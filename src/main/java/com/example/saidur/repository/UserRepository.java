package com.example.saidur.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.saidur.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
