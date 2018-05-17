package com.omg.controllers;

import com.omg.OmgApplication;
import com.omg.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/sso")
public class SingleSignOnController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public void singleSignOnRequest(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) throws IOException {

        if (accountService.accountExists(username, password) == false) {
            response.sendRedirect("https://www.google.fr/search?q=failed");
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return ;
        }
        response.sendRedirect("https://www.google.fr/search?q=logged");
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
}
