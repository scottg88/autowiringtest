package com.example.autowiringtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final Logger log = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);

    private final HttpServletRequest request;

    @Autowired
    public AuthenticationSuccessEventListener(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        log.info("Successful login");
    }
}
