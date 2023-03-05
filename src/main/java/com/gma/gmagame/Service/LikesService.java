package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.LikesMapper;
import com.gma.gmagame.model.Likes;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    @Autowired
    private LikesMapper likesMapper;

    public void LikesPlus(Integer boardId, String userId, Likes likes){
       likes.setBno(boardId);
       likes.setUserId(userId);
       likesMapper.plusLike(likes);
    }

    public int likeCheck(Integer bno,String memberId){
        return likesMapper.likeCheck(bno, memberId);
    }

}
