package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Mapper
public interface CommentMapper {

    public void insertComment(Comment comment)throws Exception;

    public List<Comment> selectCommentList(Integer boardId);

    public void updateComment(Comment comment);

    public void deleteComment(Integer commentId);

}
