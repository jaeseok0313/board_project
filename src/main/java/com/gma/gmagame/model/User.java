package com.gma.gmagame.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.*;


@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Integer user_no;
    @NotBlank(message="id는 필수 입력")
    private String user_id;//
    @NotBlank(message="password는 필수 입력")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String user_pwd;//
    @NotBlank(message="이름은 필수 입력")
    private String user_name;//
    private String admin_yn;
    private String phone_number;//
    private String address;//
    private String status;
    private Date create_date;
    private String delete_yn;

    private String Id;

    public User(Integer user_no, String user_id, String user_pwd, String user_name, String admin_yn, String phone_number, String address, String status, Date create_date,String delete_yn){
        this.user_no=user_no;
        this.user_id=user_id;
        this.user_pwd=user_pwd;
        this.user_name=user_name;
        this.admin_yn=admin_yn;
        this.phone_number=phone_number;
        this.address=address;
        this.status=status;
        this.create_date=create_date;
        this.delete_yn=delete_yn;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(admin_yn));
    }

    @Override
    public String getPassword() {
        return this.user_pwd;
    }

    @Override
    public String getUsername() {
        return this.user_id;
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
