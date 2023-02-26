package com.gma.gmagame.model;

import lombok.*;

import java.util.Date;
import java.util.Map;

//@Data
@Getter
@Setter
public class Board {
//        private Integer boardIdx;//글번호
//        private String title;//제목
//        private String contents;//내용
//        private int hitCnt; //조회수
//        private String creatorId; //작성자
//        private String createdDatetime; //작성시간
//        private String updaterId; //수정자
//        private String updatedDatetime; //수정시간
        private Integer user_idx;
        private String title;
        private String contents;
        private String name;
        private Integer viewCnt;
        private Date datetime;
        private Integer selectCnt;

//        public Board(){
//
//        }


    public Integer getSelectCnt() {
        return selectCnt;
    }

    public void setSelectCnt(Integer selectCnt) {
        this.selectCnt = selectCnt;
    }

    public Board(Integer user_idx, String title, String contents, Integer viewCnt, Date datetime)
        {
            this.user_idx=user_idx;
            this.title=title;
            this.contents=contents;
            this.viewCnt=viewCnt;
            this.datetime=datetime;
        }


}

