package com.example.sqc9ex1.processors;

import com.example.sqc9ex1.services.LoggedUserManagementService;
import com.example.sqc9ex1.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;

    private LoggedUserManagementService loggedUserManagementService;
    private LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(){
        loginCountService.increment();
        String username = this.username;
        String password = this.password;
        if("carlos".equals(username) && "password".equals(password)){
            loggedUserManagementService.setUsername(username);
            return true;
        }
        return false;
    }

}
