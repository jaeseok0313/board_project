package com.gma.gmagame.apiController;

import com.gma.gmagame.Service.BoardService;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.BoardFile;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/board")

public class BoardApiController {
    @Autowired
    private BoardService boardService;

    //게시판 조회
    @GetMapping("")
    public List<Board> apiBoardList(Model model) {
        return boardService.BoardList();
    }

    //게시판 상세 조회
    @GetMapping("/{boardId}")
    public Optional<Board> apiBoardIdList(@PathVariable Integer boardId) {
        return boardService.BoardOne(boardId);
    }

    //게시글 생성
    @PostMapping("/create")
    public void apiAddBoard(@RequestBody Board board, BoardFile boardFile, Principal principal, MultipartHttpServletRequest multipartHttpServletRequest)throws Exception {
        board.setName(principal.getName());
        boardService.BoardAdd(board,multipartHttpServletRequest,boardFile);
    }

    //게시판 수정
    @PutMapping("/{boardId}")
    public void apiUpdateBoard(@PathVariable Integer boardId, @RequestBody Board board, Principal principal) {
        Optional<Board> result =boardService.BoardOne(boardId);
        Board board2 = result.get();
        //받아온 게시판 정보의 작성자이름과 로그인 이름 비교
        if(board2.getName().equals(principal.getName())) {
            board2.setTitle(board.getTitle());
            board2.setContents(board.getContents());
            boardService.BoardUpdate(board2);
        }
        else {
            System.out.println("이름다름");
        }
    }
    //삭제
    @DeleteMapping("/delete/{boardId}")
    public void apiRemoveBoard(@PathVariable Integer boardId,Principal principal) {
        Optional<Board> result =boardService.BoardOne(boardId);
        Board board = result.get();
        if(board.getName().equals(principal.getName()))
        {
            boardService.BoardDelete(boardId);
        }
        else{
            System.out.println("이름다름");
        }

    }






}






















