package com.gma.gmagame.model;

import lombok.*;

import java.util.Date;

@Data
public class Admin {

        private Integer reqNo;
        private String userId;
        private String reqReason;
        private Date reqDate;
        private Date confirmDate;
        private String reqResult;


        public Admin(Integer reqNo, String userId, String reqReason, Date reqDate, Date confirmDate, String reqResult)
        {
            this.reqNo=reqNo;
            this.userId=userId;
            this.reqReason=reqReason;
            this.reqDate=reqDate;
            this.confirmDate=confirmDate;
            this.reqResult=reqResult;
        }


}

