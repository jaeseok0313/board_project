package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.LikesService;
import com.gma.gmagame.model.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/board/like")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @RequestMapping(value="/likePlus")
    @ResponseBody
    public int likePlus(@RequestParam(name = "boardId", required = false) Integer boardId,
                            Principal principal, Likes likes) { //board_no 받아옴
        if(likesService.likeCheck(boardId, principal.getName())==0) {
            likesService.LikesPlus(boardId, principal.getName(), likes);//플러스해줫음
            likesService.updateLike(boardId); //업데이트해줌
            return likesService.getLike(boardId);//카운트 반환->ajax Like_PLUS로 데이터전달
        }
        else{
            return 0;
        }


    }

}
