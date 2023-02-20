package com.gma.gmagame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class User {

    private Integer user_no;
    private String user_id;//
    private String user_pwd;//
    private String user_name;//
    private String admin_yn;
    private String phone_number;//
    private String address;//
    private String status;
    private Date create_date;

}
