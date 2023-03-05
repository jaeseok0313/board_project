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

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    public void LikesPlus(Integer boardId, String userId, Integer likeNo, Likes likes){
       likes.setBno(boardId);
       likes.setLikeNo(likeNo);
       likes.setUserId(userId);
       likesMapper.plusLike(likes);
    }

    public int likeCheck(int bno,String memberId) throws Exception{
        return likesMapper.likeCheck(bno, memberId);
    }

}
