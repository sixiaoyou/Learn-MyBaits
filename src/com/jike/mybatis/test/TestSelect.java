package com.jike.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jike.mybatis.jikebook.JiKeUser;

public class TestSelect {

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
            // HashMap<String, String> hm = new HashMap();
            // hm.put("userName", "jike001");
            // hm.put("password", "666666");
            // JiKeUser temp = session.selectOne("loginSelect", hm);
            // if (temp != null) {
            // System.out.println("登陆成功！");
            // }
//            JiKeUser jku = new JiKeUser();
//            jku.setUserName("jike001");
//            jku.setPassword("666666");
//            JiKeUser temp = session.selectOne("login2",jku);
//             if (temp != null) {
//             System.out.println("登陆成功！");
//             }
//            List<JiKeUser> ap = session.selectList("selectUsers");
            List<JiKeUser> ap = session.selectList("selectUsers");
            for(JiKeUser temp:ap){
                System.out.println("用户名=" + temp.getUserName());
            }
 
        } catch (Exception e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }

    }
}
