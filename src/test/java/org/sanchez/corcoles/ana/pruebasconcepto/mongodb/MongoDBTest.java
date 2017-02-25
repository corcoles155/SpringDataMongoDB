package org.sanchez.corcoles.ana.pruebasconcepto.mongodb;

import com.mongodb.Mongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sanchez.corcoles.ana.pruebasconcepto.mongodb.configuration.MongoDBConfiguration;
import org.sanchez.corcoles.ana.pruebasconcepto.mongodb.entity.User;
import org.sanchez.corcoles.ana.pruebasconcepto.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MongoDBConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class MongoDBTest {

    @Autowired
    private Mongo mongo;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldBeNotNullObjectMongo(){
        assertNotNull(mongo);
        assertNotNull(userRepository);
    }

    @Test
    public void shouldPrintDatabaseNames(){
        mongo.getDatabaseNames().forEach(databaseName -> {
            System.out.println(databaseName);
        });
    }

    @Test
    public void shouldCreateUserAndReadIt(){
        userRepository.save(new User("ana", "ana", Arrays.asList("USER", "ADMIN", "SUPERADMIN")));
        userRepository.save(new User("jorge", "jorge", Arrays.asList("USER")));
        userRepository.findAll().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void shouldReadOneUser(){
        System.out.println(userRepository.findOne("ana"));
        System.out.println(userRepository.findByPassword("ana"));
    }
}
