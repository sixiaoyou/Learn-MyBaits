package com.jike.mybatis.jikebook;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestUpdate {
    // TODO Auto-generated method stub
    public static void main(String[] args) {
//        updateOperation();
        deleteOperation();
    }
    
    public static SqlSession initEnvironment(){
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
        session = sqlMapper.openSession();
        return session;
    } 
    
    public static void insertOperation(){
        SqlSession session  =  initEnvironment();
        JiKeUser jku = new JiKeUser();
        jku.setUserName("jike001");
        jku.setPassword("123456");
        session.insert("insertUser", jku);
        session.commit();
    }
    
    public static void updateOperation(){
        SqlSession session  =  initEnvironment();
        JiKeUser jku = new JiKeUser();
        jku.setUserName("jike001");
        jku.setPassword("666666");
        jku.setId(2);
        session.update("updateUser", jku);
        session.commit();
        session.close();
    }
    public static void deleteOperation(){
        SqlSession session  =  initEnvironment();
        InterfaceJiKeUserMap jku = session.getMapper(InterfaceJiKeUserMap.class);
        jku.deleteUser(1);
        session.commit();
        session.close();
    }
    
}
