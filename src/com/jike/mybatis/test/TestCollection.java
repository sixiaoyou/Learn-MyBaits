package com.jike.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jike.mybatis.jikebook.JiKeUser;
import com.jike.mybatis.jikebook.Visit;

public class TestCollection {
    public static void main(String[] args) {
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
            List<JiKeUser> ap = session.selectList("selectVisit");
            for (JiKeUser temp : ap) {
                System.out.println("用户名=" + temp.getUserName());
                for (Visit oneVisit : temp.getVisitList()) {
                    System.out.println("登录时间=" + oneVisit.getVisitDate() + "登录IP=" + oneVisit.getVisitIP());
                }

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}