package com.jike.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jike.mybatis.jikebook.JiKeUser;

public class TestSQL {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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

        try {
            // JiKeReader oneReader = new JiKeReader();
            //// oneReader.setMoney(200);
            // List<JiKeReader> ap =
            // session.selectList("selectReaderMoney",oneReader);
            // for(JiKeReader temp:ap){
            // System.out.println("用户ID="+temp.getReaderID());
            // }
            // JiKeUser oneUser = new JiKeUser();
            //// oneUser.setUserName("%j%");
            // oneUser.setId(7);
            // oneUser.setUserName("test");
            // oneUser.setPassword("8899");
            //// session.update("updateJiKeUserSet",oneUser);
            // session.update("updateUserTrim",oneUser);
            // session.commit();
            // List<JiKeUser> ap = session.selectList("selectJiKeUserChoose",
            // oneUser);
            // List<JiKeUser> ap = session.selectList("selectJiKeUserWhere",
            // oneUser);
//            ArrayList<Integer> ideas = new ArrayList();
//            ideas.add(2);
//            ideas.add(7);
//            ideas.add(16);
//            List<JiKeUser> ap = session.selectList("selectJiKeUserForeach", ideas);
//            for (JiKeUser temp : ap) {
//                System.out.println("用户ID=" + temp.getId() + "用户名=" + temp.getUserName());
//            }
            ArrayList<JiKeUser> jkuList = new ArrayList();
             JiKeUser one = new JiKeUser("jt1","8866");
             JiKeUser two = new JiKeUser("jt2","8866");
             jkuList.add(one);
             jkuList.add(two);
             session.insert("insertJiKeUserForeach",jkuList);
             session.commit();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
