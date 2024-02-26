package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author hyh
 * @date 2024/2/4
 * MyBatis获取参数值的两种方式：#{}和${}
 * #{}的本质是占位符赋值，${}的本质是字符串拼接
 * 1、如果mapper接口的方法的参数是单个的字面量类型（基本数据类型及其包装类，字符串）
 * 此时可以通过#{}和${}以任意的内容获取参数值，一定要注意${}的单引号问题
 * 2、如果mapper接口的方法的参数是多个的字面量类型
 * 此时MyBatis会将参数放在map集合中，以两种方式存储数据[arg1, arg0, param1, param2]
 * a) 以arg0, agr1, ...为键，以参数为值
 * b) 以param1, param2, ...为键，以参数为值
 * 因此，只需要通过#{}和${}访问map集合的键，就能获取相对应的值，一定要注意${}的单引号问题
 * 3、如果mapper接口的方法的参数是多个的字面量类型
 * 也可以自定义map集合，然后在映射文件中通过自定义的键取对应的值
 * 4、如果mapper接口的方法的参数是实体类类型，
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值，一定要注意${}的单引号问题
 * 5、可以在mapper接口的方法参数上设置@Param注解，以两种方式进行存储
 * a) 以@Param注解的value属性值为键，以参数为值
 * b) 以param1,param2,...为键，以参数为值
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值，一定要注意${}的单引号问题
 */
public interface UserMapper {
    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User getUsrByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);


    /**
     * 验证登录（以map集合作为参数）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);


    /**
     * 验证登录（使用@Param注解）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username")String username, @Param("password") String password);
}
