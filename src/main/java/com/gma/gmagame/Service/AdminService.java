package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.AdminMapper;
import com.gma.gmagame.mapper.BoardMapper;
import com.gma.gmagame.model.Admin;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Paging;
import com.gma.gmagame.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;

    public Optional<Admin> ReqOne(Integer rno){
        return adminMapper.selectReqPop(rno);
    }

    public int countReq() {
        return adminMapper.countReq();
    }
    public int searchCountReq(String keyword) {
        return adminMapper.searchCountReq(keyword);
    }

    public List<Admin> selectReq(Paging vo) {
        return adminMapper.selectReq(vo);
    }

    public void approveAdmin(Integer rno) {
        adminMapper.approveAdmin(rno);
    }

    public void userAuthApprove(String uid) {
        adminMapper.userAuthApprove(uid);
    }

    public void rejectAdmin(Integer rno) {
        adminMapper.rejectAdmin(rno);
    }

    public void userAuthReject(String uid) {
        adminMapper.userAuthReject(uid);
    }

    public int reqUserCheck(String uid) {
        return adminMapper.reqUserCheck(uid);
    }

    public void authReq(Admin admin) {
        adminMapper.authReq(admin);
    }
}
