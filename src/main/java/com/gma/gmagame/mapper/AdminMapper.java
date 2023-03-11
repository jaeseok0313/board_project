package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Admin;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {
    public int countReq();

    public List<Admin> selectReq(Paging vo);

    public Optional<Admin> selectReqPop(Integer reqNo);

    public int searchCountReq(String keyword);

    public void approveAdmin(Integer reqNo);

    public void userAuthApprove(String userId);

    public void rejectAdmin(Integer reqNo);

    public void userAuthReject(String userId);

    public int reqUserCheck(String userId);

    public void authReq(Admin admin);

}
