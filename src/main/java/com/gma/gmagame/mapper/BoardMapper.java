package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.BoardFile;
import com.gma.gmagame.model.Paging;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    //게시글 수 조회
    public int countBoard();
    //인기글 10개 조회
    public List<Board> selectBest();
    //게시글 조회
    public List<Board> selectAll();
    //상세 게시글 조회
    public Optional<Board> selectOne(Integer user_idx);
    // 페이징 처리 게시글 조회
    public List<Board> selectBoard(Paging vo);
    //게시글 파일 테이블 조회
    List<BoardFile> selectBoardFileList(int boardIdx) throws Exception;
    //상세 게시글 파일 조회
    BoardFile selectBoardFileInformation(@Param("idx") Integer idx, @Param("boardIdx") Integer boardIdx);
    //게시글 검색어 조회
    public int searchCountBoard(String keyword);
    //게시글 작성
    public void insertOne(Board board);

    public void insertBoardFileList(List<BoardFile> list) throws Exception;
    //게시글 수정
    public void updateOne(Board board);
    //추천 조회
    public int updateLike(Board board);
    //게시글 조회수
    public void updateViewCnt(Integer user_idx);
    //게시글 삭제
    public void deleteOne(Integer user_idx);





}
