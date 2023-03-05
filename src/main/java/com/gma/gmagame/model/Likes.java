package com.gma.gmagame.model;

import lombok.Data;

import java.util.Date;

@Data
public class Likes {

    private Integer likeNo;
    private Integer bno;
    private String userId;
    private Integer rno;
    private Integer likeCheck;
    private Date likeDate;

    private Integer likes;

    public Likes(Integer likeNo, Integer bno, String userId, Integer rno, Integer likeCheck, Date likeDate,Integer likes)
    {
        this.likeNo=likeNo;
        this.bno=bno;
        this.userId=userId;
        this.rno=rno;
        this.likeCheck=likeCheck;
        this.likeDate=likeDate;
        this.likes=likes;
    }


}
