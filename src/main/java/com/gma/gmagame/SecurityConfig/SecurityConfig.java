package com.gma.gmagame.SecurityConfig;

import com.gma.gmagame.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    @Autowired
    private customAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private customAuthenticationFailureHandler customAuthenticationFailureHandler;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and()
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/","/account/login", "/singUp", "/index", "/resources/**","/login_proc","/board/boards").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                //api 사용 제한
                .antMatchers("/api/**").hasAnyRole("Y").anyRequest().permitAll()
                //api 유저 조회는 관리자만 가능하게 바꿔야함 보드랑 분리해야함
                // USER, ADMIN 접근 허용
                .and()
                .formLogin()
                    .usernameParameter("user_id")
                    .passwordParameter("user_pwd")
                    .loginPage("/account/login").permitAll()
                .loginProcessingUrl("/account/login")
                    .successHandler(customAuthenticationSuccessHandler)
                    .failureHandler(customAuthenticationFailureHandler);
                http.sessionManagement()
                    .maximumSessions(3)
                    .maxSessionsPreventsLogin(true);


        //로그인 창
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}