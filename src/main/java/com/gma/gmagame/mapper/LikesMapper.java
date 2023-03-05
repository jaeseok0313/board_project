package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Likes;
import com.gma.gmagame.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LikesMapper {
    public void plusLike(Likes likes);

    public int likeCheck(Integer bno, String userId);
}
