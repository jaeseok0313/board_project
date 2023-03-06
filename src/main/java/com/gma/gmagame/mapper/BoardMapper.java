package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Board;
import com.gma.gmagame.model.Paging;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    public List<Board> selectAll();

    public Optional<Board> selectOne(Integer user_idx);

    public void updateViewCnt(Integer user_idx);

    public void insertOne(Board board);

    public void deleteOne(Integer user_idx);

    public void updateOne(Board board);

    public int updateLike(Board board);

    public int countBoard();
    public int searchCountBoard(String keyword);
    // 페이징 처리 게시글 조회
    public List<Board> selectBoard(Paging vo);

    public List<Board> selectBoardKeyWord(Paging vo);



}
