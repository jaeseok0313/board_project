package com.gma.gmagame.mapper;

import com.gma.gmagame.model.Board;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository("com.gma.gmagame.mapper.BoardMapper")
public interface BoardMapper {

    public List<Board> selectAll();

    public Optional<Board> selectOne(Integer user_idx);

    public void updateViewCnt(Integer user_idx);

    public void insertOne(Board board);

    public void deleteOne(Integer user_idx);

    public void updateOne(Board board);

    public void getSelectCnt(Integer user_idx);
}
