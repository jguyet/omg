package com.omg.services;

import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.omg.OmgApplication;
import com.omg.models.Account;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountService {

    public Collection<Account> getAllAccounts() {
        QueryResults<Account> accountsResult = OmgApplication.database.getAccountCollection().find();

        return accountsResult.asList();
    }

    public Account getAccount(String id) {
        return OmgApplication.database.getAccountCollection().findOne("id", id);
    }

    public boolean addAccount(Account account) {
        if (OmgApplication.database.getAccountCollection().exists("id", account.getId()))
            return false;
        OmgApplication.database.getAccountCollection().save(account);
        return true;
    }

    public boolean accountExists(String username, String password) {
        Query<Account> query = OmgApplication.database.getAccountCollection().createQuery();
        query.filter("username =", username);
        query.filter("password =", password);
        query.limit(1);
        if (OmgApplication.database.getAccountCollection().find(query).countAll() <= 0)
            return false;
        return true;
    }
}
