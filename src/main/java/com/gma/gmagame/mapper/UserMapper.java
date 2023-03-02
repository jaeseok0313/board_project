package com.gma.gmagame.mapper;

import com.gma.gmagame.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //List<User> getUsers(@Param("text")String text);

    public void saveUser(User user);

    User getUserAccount(String user_id);

    public User getInfo(String user_id);

}
