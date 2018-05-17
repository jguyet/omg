package com.omg.controllers;

import com.omg.models.Account;
import com.omg.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") String id) {
        return accountService.getAccount(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAccount(@RequestBody Account account, HttpServletResponse response) {
        if (accountService.addAccount(account) == true) {
            response.setStatus(HttpServletResponse.SC_CREATED);
            return ;
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}
