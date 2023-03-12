package com.gma.gmagame.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class Board {


//        private Integer boardIdx;//글번호
//        private String title;//제목
//        private String contents;//내용
//        private int hitCnt; //조회수
//        private String creatorId; //작성자
//        private String createdDatetime; //작성시간
//        private String updaterId; //수정자
//        private String updatedDatetime; //수정시간
        private List<BoardFile> fileList;
        private Integer user_idx;
        private String title;
        private String contents;
        private String name;
        private Integer viewCnt;
        private Date datetime;
        private Integer likes;
        private String deleteYn;


        public Board(Integer user_idx,String title,String contents,
                     Integer viewCnt,Date datetime,String name,
                     Integer likes,String deleteYn)
        {
            this.user_idx=user_idx;
            this.title=title;
            this.contents=contents;
            this.viewCnt=viewCnt;
            this.datetime=datetime;
            this.name=name;
            this.likes=likes;
            this.deleteYn=deleteYn;
        }

    public void setFileList(List<BoardFile> fileList) {
        this.fileList = fileList;
    }
    public List<BoardFile> getFileList() {
        return fileList;
    }
}

