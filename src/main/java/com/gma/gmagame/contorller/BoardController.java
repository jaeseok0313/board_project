package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.BoardService;
import com.gma.gmagame.mapper.BoardMapper;
import com.gma.gmagame.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String boards(Model model)
    {
        List<Board> boards = boardService.BoardList();
        model.addAttribute("boards",boards);
        return "board/boards";
    }
    @GetMapping("/{user_idx}")
    public String board(@PathVariable("user_idx") Integer user_idx, Model model)
    {
        boardService.ViewCntUpdate(user_idx);
        Optional<Board> result = boardService.BoardOne(user_idx);
        Board board = result.get();
        model.addAttribute("board",board);
        return "board/board";
    }
    @GetMapping("/add")
    public String addForm(Model model){

        return "board/addForm";
    }
    @PostMapping("/add")
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes){
        boardService.BoardAdd(board);
        return "redirect:/board";
    }

    @RequestMapping("/{user_idx}/delete")
    public String deleteBoard(@PathVariable Integer user_idx)
    {
        boardService.BoardDelete(user_idx);
        return "redirect:/board/boards";
    }
    @GetMapping("/{user_idx}/edit")
     public String editForm(@PathVariable("user_idx") Integer user_idx,Model model){
        Optional<Board> result =boardService.BoardOne(user_idx);
        Board board = result.get();
        model.addAttribute("board",board);

        return "board/editForm";
    }
    @PostMapping("/{user_idx}/edit")
    public String edit(@PathVariable String user_idx, @ModelAttribute Board board){
        boardService.BoardUpdate(board);
        return "redirect:/board/{user_idx}";
    }


}
