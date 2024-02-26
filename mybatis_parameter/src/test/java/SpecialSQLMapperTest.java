import com.atguigu.mybatis.mapper.SpecialSQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author hyh
 * @date 2024/2/4
 */
public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }

    public void testJDBC() {
        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("","","");
            String sql = "select * from t_user where username like '%?%'";
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, "a");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("7,8");
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> list = mapper.getUserList("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "kkk", "kkkkk", 22,"女", "jjjj@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
    public void testJDBCInsertUser() {
        try {
            Class.forName("");
            Connection connection = DriverManager.getConnection("","","");
            String sql = "insert into t_user values()";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            ps.getGeneratedKeys()
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
