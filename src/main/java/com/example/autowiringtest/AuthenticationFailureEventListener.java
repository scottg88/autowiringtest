package com.example.autowiringtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    private final Logger log = LoggerFactory.getLogger(AuthenticationFailureEventListener.class);

    private final HttpServletRequest request;

    @Autowired
    public AuthenticationFailureEventListener(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        log.info("Failed login attempt");
    }
}
