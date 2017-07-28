package com.jike.mybatis.jikebook;

import java.util.Date;

public class Visit {
    private Integer visitID;
    private JiKeUser jiKeUser;
    private Date visitDate;
    private String visitIP;
    public Integer getVisitID() {
        return visitID;
    }
    public void setVisitID(Integer visitID) {
        this.visitID = visitID;
    }
    public JiKeUser getJiKeUser() {
        return jiKeUser;
    }
    public void setJiKeUser(JiKeUser jiKeUser) {
        this.jiKeUser = jiKeUser;
    }
    public Date getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    public String getVisitIP() {
        return visitIP;
    }
    public void setVisitIP(String visitIP) {
        this.visitIP = visitIP;
    }
    
    
    
    
    
    
}
