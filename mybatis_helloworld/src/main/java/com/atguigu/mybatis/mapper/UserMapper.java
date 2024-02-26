package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @author hyh
 * @date 2024/2/3
 */
public interface UserMapper {
   /**
    * 添加用户信息
    * @return
    */
   int insertUser();

   /**
    * 修改用户信息
    * @return
    */
   void updateUser();

   /**
    * 删除用户信息
    */
   void deleteUser();

   /**
    * 根据id查询用户信息
    * @return
    */
   User getUserById();

   /**
    * 查询所有用户信息
    * @return
    */
   List<User> getAllUser();
}
