package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.BoardMapper;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> BoardBestList(){
        return boardMapper.selectBest();
    }

    public List<Board> BoardList(){
        return boardMapper.selectAll();
    }

    public Optional<Board> BoardOne(Integer uid){
        return boardMapper.selectOne(uid);
    }
    public void ViewCntUpdate(Integer uid){
       boardMapper.updateViewCnt(uid);
    }

    public void BoardAdd(Board board) throws Exception{
        boardMapper.insertOne(board);
    }
    public void BoardDelete(Integer uid)
    {
        boardMapper.deleteOne(uid);
    }
    public void BoardUpdate(Board board) {
        boardMapper.updateOne(board);
    }

    public int updateLike(Board board){
        return boardMapper.updateLike(board);
    }

    public int countBoard() {
        return boardMapper.countBoard();
    }
    public int searchCountBoard(String keyword) {
        return boardMapper.searchCountBoard(keyword);
    }

    public List<Board> selectBoard(Paging vo) {
        return boardMapper.selectBoard(vo);
    }

    public List<Board> selectBoardKeyWord(Paging vo) {
        return boardMapper.selectBoardKeyWord(vo);
    }

}
