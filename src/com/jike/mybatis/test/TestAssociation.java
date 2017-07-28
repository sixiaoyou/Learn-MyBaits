package com.jike.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jike.mybatis.jikebook.Author;

public class TestAssociation {

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
        session = sqlMapper.openSession();
        
        try {
//            List<Author> ap = session.selectList("selectAuthorJoin");
            List<Author> ap = session.selectList("selectAuthor");
            for(Author temp:ap){
                System.out.println("作者真实姓名="+temp.getRealName());
                System.out.println("懒加载应用了");
                System.out.println("用户名="+temp.getJikeUser().getUserName());
            }
        
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            session.close();
        }
        }
    
    
}
