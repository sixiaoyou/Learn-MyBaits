package com.jike.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jike.mybatis.jikebook.Author;
import com.jike.mybatis.jikebook.JiKeUser;

public class TestTran {
    public static void main(String[] args){
    String resource = "conf/MyBatisConfig.xml";
    Reader reader = null;
    SqlSession session;
    try {
        reader = Resources.getResourceAsReader(resource);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
    session = sqlMapper.openSession(false);
    try { 
        JiKeUser jku = new JiKeUser();
        jku.setUserName("author001");
        jku.setPassword("123456");
        session.insert("insertUser",jku);
        System.out.println("新加入的user id="+jku.getId());
        
        Author at = new Author();
        at.setJikeUser(jku);
        at.setRealName("test");
        session.insert("insertAuthor",at); 
        session.commit();
    } catch (Exception e) {
        session.rollback();
    } finally {
        session.close(); 
    }
}
}
