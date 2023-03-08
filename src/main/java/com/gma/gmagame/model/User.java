package com.gma.gmagame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Data
@NoArgsConstructor
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

    private String Id;

    public User(Integer user_no, String user_id, String user_pwd, String user_name, String admin_yn, String phone_number, String address, String status, Date create_date){
        this.user_no=user_no;
        this.user_id=user_id;
        this.user_pwd=user_pwd;
        this.user_name=user_name;
        this.admin_yn="ROLE_Y";
        this.phone_number=phone_number;
        this.address=address;
        this.status=status;
        this.create_date=create_date;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_Y"));
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
