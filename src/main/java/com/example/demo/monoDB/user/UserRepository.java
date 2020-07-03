package com.example.demo.monoDB.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserInfo,Object> {


    List<UserInfo> findByUsernameLike(String username);

}
