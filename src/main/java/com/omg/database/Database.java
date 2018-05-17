package com.omg.database;

import com.google.code.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.omg.database.collection.AccountCollectionDAO;
import com.omg.models.Account;

public class Database {

    //##############################
    //@PRIVATE VARIABLES SECTION -->
    //##############################

    //HOST
    private String 						hostname;
    private int							port;

    //USER CREDENTIAL
    private String						userName;
    private String						password;

    //DATABASE NAME
    private String						databaseName;

    //MONGO
    private MongoCredential             mongoCredential;
    private MongoClientOptions          mongoOptions;
    private MongoClient 				mongoClient;
    private MongoDatabase				mongoDB;

    //Collections
    private AccountCollectionDAO        accountCollection;

    //##############################################################################
    //@CONTRUCTOR SECTION --------------------------------------------------------->
    //##############################################################################

    public Database(String hostname, int port, String databaseName) {
        this.hostname = hostname;
        this.port = port;
        this.databaseName = databaseName;
    }

    //##############################################################################
    //@BUILD METHODS SECTION ------------------------------------------------------>
    //##############################################################################

    public void buildDatabaseOptions() {
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();

        this.mongoOptions = optionsBuilder.build();
        //logger.info("MongoClientOptions builded");
    }

    public void buildCredential(String username, String password) {
        this.userName = username;
        this.password = password;

        // Automatically detect SCRAM-SHA-1 or Challenge Response protocol
        this.mongoCredential = MongoCredential.createCredential(this.userName, this.databaseName, this.password.toCharArray());
        //logger.info("MongoCredential builded");
    }

    public void buildDatabaseConnection() {
        this.mongoClient = new MongoClient(new ServerAddress(hostname, port), mongoCredential, mongoOptions);
        this.mongoDB = mongoClient.getDatabase(databaseName);
        //logger.info("Database connection estabilised on database \"{}\" on address {}:{}", databaseName, hostname, port);
    }

    public void buildCollections() {
        //Set morphia logging OFF
        //MorphiaLoggerFactory.registerLogger(MorphiaSilentLoggerFactory.class);
        Morphia morphia = new Morphia();

        morphia.map(Account.class);
        accountCollection = new AccountCollectionDAO(this.mongoClient, morphia, this.databaseName);

        //logger.info("MongoCollections builded");
        System.out.println("MongoCollections builded");
    }

    public void closeDatabaseConnection() {
        this.mongoClient.close();
       // logger.info("Database connection closed on address {}:{}", hostname, port);
    }

    //##############################################################################
    //@GETTER SETTER SECTION ------------------------------------------------------>
    //##############################################################################

    public MongoDatabase Mongo() {
        return mongoDB;
    }

    public AccountCollectionDAO getAccountCollection() {
        return this.accountCollection;
    }
}
