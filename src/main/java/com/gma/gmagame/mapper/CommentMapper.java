package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public List<Comment> selectCommentList(Integer boardId);
}
