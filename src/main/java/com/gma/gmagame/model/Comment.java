package com.gma.gmagame.model;

import lombok.*;

import java.util.Date;

@Data
public class Comment {

    private Integer commentNumber;
    private Integer bno;
    private String commentContent;
    private String creatorID;
    private Date commentDate;

    public Comment(Integer commentNumber, Integer bno, String commentContent,String creatorID, Date commentDate)
    {
        this.commentNumber=commentNumber;
        this.bno=bno;
        this.commentContent=commentContent;
        this.creatorID=creatorID;
        this.commentDate=commentDate;
    }


}
