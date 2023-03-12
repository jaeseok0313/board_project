package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.CommentService;
import com.gma.gmagame.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/board/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/write" , method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void commentWrite(@RequestParam(name = "boardId", required = false) Integer boardId,
                             @RequestParam(name = "content",required = false) String content,
                             Principal principal,Comment comment) throws Exception {
        String username = principal.getName();
        commentService.write(boardId, content, username,comment);
    }
    @RequestMapping(value = "/getCommentList",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getCommentList(@RequestParam(name = "boardId") Integer boardId){
        List<Comment> comments = commentService.getCommentList(boardId);
        return comments;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public void updateComment(@RequestParam(name = "commentId",required=false) Integer commentId,
                              @RequestParam(name = "content",required=false) String content,Comment comment) throws Exception {
        commentService.update(commentId, content,comment);
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public void deleteComment(@RequestParam(name = "commentId") Integer commentId) throws Exception {
        commentService.delete(commentId);
    }
}
