package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hyh
 * @date 2024/2/4
 */
public interface SelectMapper {
    /**
     * 如果sql语句查询的结果为多条时，一定不能以实体类类型作为接口方法的返回值
     * 否则会抛出异常TooManyResultsException
     * 如果sql语句查询的结果为1条时，此时可以用实体类类型或list集合类型作为方法的返回值
     */
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用信息
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     *
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息，以map返回
     *
     * @param id
     * @return
     */
    //查询结果：{password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=admin}
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息以map返回
     * 如果查询的数据有多条，并且要将查询的每条数据转换为map
     * 此时有两种解决方案：
     * 1、将接口方法的返回值设置为泛型是map的list集合
     * List<Map<String, Object>>
     * 输出结果为：
     * {password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=admin}
     * {password=123456, gender=男, id=2, age=23, email=123456@qq.com, username=root}
     * {password=123456, gender=男, id=4, age=33, email=555@qq.com, username=zs}
     * <p>
     * 2、将每条数据转换成为的map再放到一个大的map集合中，
     * 但是必须要通过@MapKey注解，将查询到的某个字段的值作为大map的键
     * 输出结果为：
     * {1={password=123456, gender=男, id=1, age=23, email=123456@qq.com, username=admin},
     * 2={password=123456, gender=男, id=2, age=23, email=123456@qq.com, username=root},
     * 4={password=123456, gender=男, id=4, age=33, email=555@qq.com, username=zs}}
     *
     * @return
     */
//   List<Map<String, Object>> getALlUserToMap();
    @MapKey("id")
    Map<String, Object> getALlUserToMap();

}
