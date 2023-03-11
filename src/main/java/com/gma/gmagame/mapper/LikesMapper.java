package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Likes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikesMapper {
    public void plusLike(Likes likes);

    public int likeCheck(Integer bno, String userId);

    public Integer getLike(Integer bno);

    public int updateLike(Integer bno);
}
