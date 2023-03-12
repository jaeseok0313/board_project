package com.gma.gmagame.contorller;


import com.gma.gmagame.Service.BoardService;
import com.gma.gmagame.Service.LikesService;
import com.gma.gmagame.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardService boardService;

    @GetMapping
    public String index(Model model) {
        List<Board> list=boardService.BoardBestList();
        List<Board> list2=boardService.BoardList();
        model.addAttribute("boa",list);
        model.addAttribute("boar",list2);

        return "board/lits";
    }
}
