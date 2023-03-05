package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.BoardService;
import com.gma.gmagame.Service.LikesService;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Likes;
import com.gma.gmagame.model.Paging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/board/like")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @RequestMapping(value="/likePlus")
    @ResponseBody
    public void likePlus(@RequestParam(name = "boardId", required = false) Integer boardId,
                         @RequestParam(name = "userId",required = false) String userId,
                         @RequestParam(name = "likes",required = false) Integer likes,
                            Principal principal, Likes likses) {
        System.out.println("컨트롤러 연결 성공");
        System.out.println(boardId);
        System.out.println(likes);
        System.out.println(principal.getName());

        if(likesService.likeCheck(boardId,principal.getName())==0) {
            likesService.LikesPlus(boardId, principal.getName(), likses);
        }
    }
//    @PostMapping
//    public String updateLike(int bno, String userId,String creatorId)throws Exception {
//
//        this.likesService.LikesPlus(userId);
//        System.out.println(likesService.LikesPlus(userId));
//        return "board/board";
//    }

    /*
    @ResponseBody
    @RequestMapping(value = "/board/updateLike" , method = RequestMethod.POST)
    public int updateLike(int bno, String userId,String creatorId)throws Exception{

        int likeCheck = likesService.likeCheck(bno, userId);
        if(likeCheck == 0) {
            //좋아요 처음누름
            //likesService.insertLike(bno, memberId); //like테이블 삽입
            //likesService.updateLike(bno);	//게시판테이블 +1
            //likesService.updateLikeCheck(bno, memberId);//like테이블 구분자 1
            //likesService.memberPointPlus(writerId); //회원포인트 +
        }else if(likeCheck == 1) {
            //likesService.updateLikeCheckCancel(bno, memberId); //like테이블 구분자0
            //likesService.updateLikeCancel(bno); //게시판테이블 - 1
            //likesService.deleteLike(bno, memberId); //like테이블 삭제
            //likesService.memberPointDown(writerId); //회원포인트 -
        }
        return likeCheck;
    }
    */
}
