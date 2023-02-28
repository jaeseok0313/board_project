package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.CommentMapper;
import com.gma.gmagame.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getCommentList(Integer boardId){
        return commentMapper.selectCommentList(boardId);
    }

}
