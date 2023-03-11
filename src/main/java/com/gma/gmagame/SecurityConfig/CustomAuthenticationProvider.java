package com.gma.gmagame.SecurityConfig;
import com.gma.gmagame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomLoadUserByUsername customLoadUserByUsername;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = (User) customLoadUserByUsername.loadUserByUsername(authentication.getName().toString());

        String reqPassword = authentication.getCredentials().toString();

        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}