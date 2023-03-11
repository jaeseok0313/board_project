package com.gma.gmagame.mapper;

import com.gma.gmagame.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //List<User> getUsers(@Param("text")String text);

    public void saveUser(User user);

    User getUserAccount(String user_id);

    User getMypage(String user_id);

    public void updateUser(User user);

    User getAdmin(String user_id);
}
