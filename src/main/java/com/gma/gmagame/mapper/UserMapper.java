package com.gma.gmagame.mapper;

import com.gma.gmagame.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import java.util.List;

@Mapper
public interface UserMapper {
    //List<User> getUsers(@Param("text")String text);
    public List<User> selectList();
    public void saveUser(User user);

}
