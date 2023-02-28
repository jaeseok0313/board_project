package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.CommentService;
import com.gma.gmagame.mapper.CommentMapper;
import com.gma.gmagame.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/board/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/getCommentList")
    @ResponseBody
    public List<Comment> getCommentList(@RequestParam(name = "boardId") Integer boardId){

        List<Comment> comments = commentService.getCommentList(boardId);
        System.out.println(comments);
        return comments;
    }
}
