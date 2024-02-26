import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author hyh
 * @date 2024/2/4
 */
public class SelectMapperTest {
  @Test
  public void testGetUserById() {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    User user = mapper.getUserById(1);
    System.out.println(user);
  }
  @Test
  public void testGetAllUser() {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    List<User> allUser = mapper.getAllUser();
    allUser.forEach(System.out :: println);
  }
  @Test
  public void testGetCount() {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    Integer count = mapper.getCount();
    System.out.println(count);
  }

  @Test
  public void testGetUserByIdToMap() {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    Map<String, Object> map = mapper.getUserByIdToMap(1);
    System.out.println(map);
  }

  @Test
  public void testGetAllUserToMap() {
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//    List<Map<String, Object>> list = mapper.getALlUserToMap();
//    list.forEach(System.out::println);
    Map<String, Object> map = mapper.getALlUserToMap();
    System.out.println(map);
  }


}
