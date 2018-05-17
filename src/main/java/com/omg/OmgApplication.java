package com.omg;

import com.omg.database.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import javax.swing.*;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class OmgApplication {

    public static Database database;

    public static void main(String ... args) {

        database = new Database("ds227570.mlab.com", 27570, "omgdb");
        database.buildCredential("root", "123");
        database.buildDatabaseOptions();
        database.buildDatabaseConnection();
        database.buildCollections();

        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(OmgApplication.class, args);
    }
}
