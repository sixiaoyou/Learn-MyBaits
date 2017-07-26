package com.jike.mybatis.jikebook;

public class Author {

    private Integer id;
    private JiKeUser  jiKeUser;
    private String realname;
    private String  IDCard;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public JiKeUser getJiKeUser() {
        return jiKeUser;
    }
    public void setJiKeUser(JiKeUser jiKeUser) {
        this.jiKeUser = jiKeUser;
    }
    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getIDCard() {
        return IDCard;
    }
    public void setIDCard(String iDCard) {
        IDCard = iDCard;
    }
    
    
}
