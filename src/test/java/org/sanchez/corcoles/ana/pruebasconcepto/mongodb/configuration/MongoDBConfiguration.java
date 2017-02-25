package org.sanchez.corcoles.ana.pruebasconcepto.mongodb.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("org.sanchez.corcoles.ana.pruebasconcepto.mongodb.repository")
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    @Override
    public MongoMappingContext mongoMappingContext()
            throws ClassNotFoundException {
        return super.mongoMappingContext();
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost" + ":" + "27017");
    }
    @Override
    protected String getDatabaseName() {
        return "test";
    }
}


