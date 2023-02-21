package com.gma.gmagame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Data
public class User implements UserDetails {

    private Integer user_no;
    private String user_id;//
    private String user_pwd;//
    private String user_name;//
    private String admin_yn;
    private String phone_number;//
    private String address;//
    private String status;
    private Date create_date;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.admin_yn));
    }

    @Override
    public String getPassword() {
        return this.user_pwd;
    }

    @Override
    public String getUsername() {
        return this.user_id;
    }

    public String getUserName() {
        return this.user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
