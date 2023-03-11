package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.CommentMapper;
import com.gma.gmagame.model.Comment;
import com.gma.gmagame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;

    public void write(Integer boardId, String content, String username,Comment comment) throws Exception {
        User user = userService.loadUserByUsername(username);
        comment.setBno(boardId);
        comment.setCommentContent(content);
        comment.setCreatorID(user.getUser_id());

        commentMapper.insertComment(comment);

    }
    public List<Comment> getCommentList(Integer boardId){

        return commentMapper.selectCommentList(boardId);
    }
    public void update(Integer commentId, String content, Comment comment)  throws Exception{
        comment.setCommentNumber(commentId);
        comment.setCommentContent(content);
        System.out.println(comment);
        commentMapper.updateComment(comment);

    }
    public void delete(Integer commentId) throws Exception {
        commentMapper.deleteComment(commentId);
    }

}
