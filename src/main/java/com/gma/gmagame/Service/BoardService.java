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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.*;


@Service
@RequiredArgsConstructor
public class BoardService {
    @Autowired
    private final BoardMapper boardMapper;
    @Autowired
    private FileUtils fileUtils;

    //게시글 수 조회
    public int countBoard() {
        return boardMapper.countBoard();
    }
    //인기글 10개 조회-------------------------------------------------------
    public List<Board> BoardBestList(){
        return boardMapper.selectBest();
    }
    //게시글 조회
    public List<Board> BoardList(){
        return boardMapper.selectAll();
    }
    //페이징 처리 게시글 조회
    public List<Board> selectBoard(Paging vo) {
        return boardMapper.selectBoard(vo);
    }
    //상세 게시글 파일 조회
    public BoardFile selectBoardFileInformation(Integer idx, Integer boardIdx) throws Exception {
        return boardMapper.selectBoardFileInformation(idx, boardIdx);
    }
    //게시글 검색어 조회
    public int searchCountBoard(String keyword) {
        return boardMapper.searchCountBoard(keyword);
    }

    //게시글 작성------------------------------------------------------------------
    public void BoardAdd(Board board, MultipartHttpServletRequest multipartHttpServletRequest,BoardFile boardFile) throws Exception{
        boardMapper.insertOne(board);
        List<BoardFile> list = fileUtils.parseFileInfo(board.getUser_idx(),boardFile,multipartHttpServletRequest);
        if(CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }
    }
    //??
    public Board selectBoardDetail(Integer boardIdx) throws Exception {
        Optional<Board> result = boardMapper.selectOne(boardIdx);
        Board board = result.get();
        List<BoardFile> fileList = boardMapper.selectBoardFileList(boardIdx);
        board.setFileList(fileList);
        return board;
    }
    //게시글 수정
    public void BoardUpdate(Board board) {
        boardMapper.updateOne(board);
    }
    //게시글 업데이트
    public int updateLike(Board board){
        return boardMapper.updateLike(board);
    }
    //게시글 조회수 증가
    public void ViewCntUpdate(Integer uid){
        boardMapper.updateViewCnt(uid);
    }
    //게시글 삭제
    public void BoardDelete(Integer uid)
    {
        boardMapper.deleteOne(uid);
    }
}
