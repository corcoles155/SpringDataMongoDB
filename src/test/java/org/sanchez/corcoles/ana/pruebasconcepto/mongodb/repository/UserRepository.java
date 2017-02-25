package org.sanchez.corcoles.ana.pruebasconcepto.mongodb.repository;

import org.sanchez.corcoles.ana.pruebasconcepto.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByPassword(String password);
}
