package com.gma.gmagame.SecurityConfig;

import com.gma.gmagame.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()	//로그인 창
                .authorizeRequests()
                .antMatchers( "/login", "/singUp", "/access_denied", "/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                // USER, ADMIN 접근 허용
                //.antMatchers("/userAccess").hasRole("USER")
                //.antMatchers("/userAccess").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/account/login")
                .usernameParameter("user_id")
                .passwordParameter("user_pwd")
                //.loginProcessingUrl("/")
                //.defaultSuccessUrl("/account/user_access")
                //.failureUrl("/account/access_denied") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
                .and()
                .logout().permitAll();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}