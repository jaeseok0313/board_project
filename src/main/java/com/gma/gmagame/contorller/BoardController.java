package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.BoardService;
import com.gma.gmagame.Service.LikesService;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.BoardFile;
import com.gma.gmagame.model.Paging;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final LikesService likesService;
    @RequestMapping(value = "/boards",method = RequestMethod.GET)
    public String boardList(Paging vo, Model model
            , @RequestParam(value="nowPage", required=false)String nowPage
            , @RequestParam(value="cntPerPage", required=false)String cntPerPage
            , @RequestParam(value="keyword",required = false)String keyword) {
        if (nowPage == null && cntPerPage == null) {
            nowPage = "1";
            cntPerPage = "10";
        } else if (nowPage == null) {
            nowPage = "1";
        } else if (cntPerPage == null) {
            cntPerPage = "2";
        }

        if(keyword==null) {
            int total = boardService.countBoard();
            vo = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
            model.addAttribute("paging", vo);
            model.addAttribute("boards", boardService.selectBoard(vo));
        }else if(keyword != null){
            int total2 = boardService.searchCountBoard(keyword);
            vo = new Paging(total2, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage),keyword);
            model.addAttribute("paging", vo);
            model.addAttribute("boards", boardService.selectBoard(vo));
        }
        return "board/boards";
    }
    @RequestMapping(value = "/{user_idx}",method = RequestMethod.GET)
    public String board(@PathVariable("user_idx") Integer user_idx, Model model) throws Exception
    {
        boardService.ViewCntUpdate(user_idx);
//        Optional<Board> result = boardService.selectBoardDetail(user_idx);
        Board board = boardService.selectBoardDetail(user_idx);
        model.addAttribute("board",board);

        return "board/board";
    }
    @RequestMapping(value = "/lits",method = RequestMethod.GET)
    //인기글
    public String index(Model model) {
        List<Board> list=boardService.BoardBestList();
        List<Board> list2=boardService.BoardList();
        model.addAttribute("boa",list);
        model.addAttribute("boar",list2);

        return "board/lits";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addForm(Model model ,@ModelAttribute Board board){
        model.addAttribute("board",board);
        return "board/addForm2";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes , Authentication authentication,
                           MultipartHttpServletRequest multipartHttpServletRequest
                           , BoardFile boardFile, Principal principal)throws Exception{
        boardService.BoardAdd(board,multipartHttpServletRequest,boardFile,principal.getName());
        System.out.println(boardFile);
        return "redirect:/board/boards";
    }
    @RequestMapping(value = "/{user_idx}/edit",method = RequestMethod.GET)
    public String editForm(@PathVariable("user_idx") Integer user_idx,Model model) throws Exception{
        Board board = boardService.selectBoardDetail(user_idx);
        model.addAttribute("board",board);

        return "board/editForm";
    }
    @RequestMapping(value = "/{user_idx}/edit",method = RequestMethod.POST)
    public String edit(@PathVariable String user_idx, @ModelAttribute Board board)throws Exception{
        boardService.BoardUpdate(board);
        return "redirect:/board/{user_idx}";
    }
    @ResponseBody
    @RequestMapping(value = "/images/{filename}",method = RequestMethod.GET)
    public Resource processImg(@PathVariable String filename,BoardFile boardFile,@RequestParam Integer idx, @RequestParam Integer boardIdx) throws Exception{
        boardFile=boardService.selectBoardFileInformation(idx,boardIdx);
        System.out.println(boardFile.getStoredFilePath());
        return new UrlResource(boardFile.getStoredFilePath());

    }
    @RequestMapping("/downloadBoardFile.do")
    public void downloadBoardFile(@RequestParam Integer idx, @RequestParam Integer boardIdx, HttpServletResponse response,BoardFile boardFile) throws Exception {
        boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
        System.out.println(boardFile);
        if(ObjectUtils.isEmpty(boardFile) == false) {
            String fileName = boardFile.getOriginalFileName();


            byte[] files = FileUtils.readFileToByteArray(new File("src/main/resources/static/css/"+boardFile.getStoredFilePath()));
            response.setContentType("application/octet-stream");
            response.setContentLength(files.length);
            response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8")+"\";");

            response.getOutputStream().write(files);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }
    @RequestMapping("/{user_idx}/delete")
    public String deleteBoard(@PathVariable Integer user_idx)
    {
        boardService.BoardDelete(user_idx);
        return "redirect:/board/boards";
    }


}