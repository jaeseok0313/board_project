package com.gma.gmagame.mapper;

import com.gma.gmagame.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //List<User> getUsers(@Param("text")String text);

    User getMypage(String user_id);
    //유저 정보 수정
    public void updateUser(User user);
    //restapi 구현
    //전체 유저 리스트 조회
    public List<User> getAllUsers();
    //유저 id의 정보 조회
    User getUserAccount(String user_id);
    //유저 회원가입
    public void registerUser(User user);
    //유저 정보 수정
    public void userUpdate(User user);
    //유저 정보 삭제
    public void deleteUser(String userId);


}
