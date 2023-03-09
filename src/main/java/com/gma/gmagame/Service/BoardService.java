package com.gma.gmagame.Service;

import com.gma.gmagame.Utils.FileUtils;
import com.gma.gmagame.mapper.BoardMapper;
import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.BoardFile;
import com.gma.gmagame.model.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.io.File;
import java.security.Principal;
import java.util.*;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    @Autowired
    private FileUtils fileUtils;

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

    public void BoardAdd(Board board, MultipartHttpServletRequest multipartHttpServletRequest,BoardFile boardFile) throws Exception{
        boardMapper.insertOne(board);

        List<BoardFile> list = fileUtils.parseFileInfo(board.getUser_idx(),boardFile,multipartHttpServletRequest);
        if(CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }


    }
    public BoardFile selectBoardFileInformation(Integer idx, Integer boardIdx) throws Exception {

        return boardMapper.selectBoardFileInformation(idx, boardIdx);
    }
    public Board selectBoardDetail(Integer boardIdx) throws Exception {
        Optional<Board> result = boardMapper.selectOne(boardIdx);
        Board board = result.get();
        System.out.println(boardIdx);
        List<BoardFile> fileList = boardMapper.selectBoardFileList(boardIdx);
        board.setFileList(fileList);
        System.out.println(board);
        System.out.println(fileList);
        System.out.println(board.getFileList());
        return board;
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
