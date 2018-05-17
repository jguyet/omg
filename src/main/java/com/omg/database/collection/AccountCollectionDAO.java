package com.omg.database.collection;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import com.omg.models.Account;
import org.bson.types.ObjectId;

public class AccountCollectionDAO extends BasicDAO<Account, ObjectId> {

    public AccountCollectionDAO(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }
}
