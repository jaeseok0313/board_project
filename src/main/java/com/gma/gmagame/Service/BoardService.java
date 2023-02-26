package com.gma.gmagame.Service;

import com.gma.gmagame.mapper.BoardMapper;
import com.gma.gmagame.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;


    public List<Board> BoardList(){
        return boardMapper.selectAll();
    }

    public Optional<Board> BoardOne(Integer uid){
        return boardMapper.selectOne(uid);
    }
    public void ViewCntUpdate(Integer uid){
       boardMapper.updateViewCnt(uid);
    }

    public void BoardAdd(Board board) {
        boardMapper.insertOne(board);
    }
    public void BoardDelete(Integer uid)
    {
        boardMapper.deleteOne(uid);
    }
    public void BoardUpdate(Board board)
    {
        boardMapper.updateOne(board);
    }

    public void selectCnt(Integer uid) {
        boardMapper.getSelectCnt(uid);
    }
}
