package com.jike.mybatis.jikebook;

import org.apache.ibatis.annotations.Delete;

public interface InterfaceJiKeUserMap {
    @Delete("delete from JiKeUser where id = #{id}")
    public void deleteUser(Integer id);

}
