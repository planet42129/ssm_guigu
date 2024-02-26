package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hyh
 * @date 2024/2/4
 */
public interface SpecialSQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteMoreUser(@Param("ids")String ids);

    /**
     * 动态设置表名，查询当前用户信息
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户信息并获取自增的主键
     * @param user
     */
    void insertUser(User user);
}
