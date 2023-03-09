package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.BoardFile;
import com.gma.gmagame.model.Paging;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    List<BoardFile> selectBoardFileList(int boardIdx) throws Exception;
    BoardFile selectBoardFileInformation(@Param("idx") Integer idx, @Param("boardIdx") Integer boardIdx);
    public List<Board> selectBest();

    public List<Board> selectAll();

    public Optional<Board> selectOne(Integer user_idx);

    public void updateViewCnt(Integer user_idx);

    public void insertOne(Board board);

    public void insertBoardFileList(List<BoardFile> list) throws Exception;
    public void deleteOne(Integer user_idx);

    public void updateOne(Board board);

    public int updateLike(Board board);

    public int countBoard();
    public int searchCountBoard(String keyword);
    // 페이징 처리 게시글 조회
    public List<Board> selectBoard(Paging vo);

    public List<Board> selectBoardKeyWord(Paging vo);




}
