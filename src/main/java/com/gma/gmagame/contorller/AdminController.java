package com.gma.gmagame.contorller;

import com.gma.gmagame.Service.AdminService;
import com.gma.gmagame.Service.BoardService;
import com.gma.gmagame.Service.LikesService;
import com.gma.gmagame.model.Admin;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Paging;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @RequestMapping(value = "adminList", method = RequestMethod.GET)
    public String reqList(Paging vo, Model model
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
            int total = adminService.countReq();
            vo = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
            model.addAttribute("paging", vo);
            model.addAttribute("admins", adminService.selectReq(vo));
        }else if(keyword != null){
            int total2 = adminService.searchCountReq(keyword);
            vo = new Paging(total2, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage),keyword);
            model.addAttribute("paging", vo);
            model.addAttribute("admins", adminService.selectReq(vo));
        }
        System.out.println(adminService.selectReq(vo));
        return "admin/adminList";
    }
    @RequestMapping(value = "{reqNo}", method = RequestMethod.GET)
    public String admin(@PathVariable("reqNo") Integer reqNo, Model model){
        Optional<Admin> result = adminService.ReqOne(reqNo);
        Admin admin = result.get();
        model.addAttribute("admin", admin);

        return "admin/admin";
    }

    @RequestMapping(value = "/{reqNo}/approve", method=RequestMethod.GET)
    public String approveAdmin(@PathVariable Integer reqNo, String userId) {

        if (adminService.reqUserCheck(userId) > 0){
            adminService.approveAdmin(reqNo);
            adminService.userAuthApprove(userId);

            return "redirect:/admin/adminList";
        } else {
            return "redirect:/admin/{reqNo}";
        }
    }

    @RequestMapping(value = "/{reqNo}/reject",method = RequestMethod.GET)
    public String rejectAdmin(@PathVariable Integer reqNo, String userId) {

        if (adminService.reqUserCheck(userId) > 0){
            adminService.rejectAdmin(reqNo);
            adminService.userAuthReject(userId);

            return "redirect:/admin/adminList";
        } else {
            return "redirect:/admin/{reqNo}";
        }
    }
    @RequestMapping(value = "adminReq", method = RequestMethod.GET)
    public String addForm(Model model ,@ModelAttribute Admin admin){
        model.addAttribute("admin",admin);
        return "admin/adminReq";
    }
    @RequestMapping(value = "adminReq", method = RequestMethod.POST)
    public String authReq(@ModelAttribute Admin admin, RedirectAttributes redirectAttributes ,Authentication authentication){
        String name = authentication.getName();
        adminService.authReq(admin);
        return "redirect:/";
    }
}