package test;

import cn.elle.Model.dao.UserDao;
import cn.elle.Model.domain.User;
import java.io.PrintStream;
import org.junit.Test;

public class UserDaoTest
{
  @Test
  public void testadd()
  {
    UserDao userdao = new UserDao();
    User user = new User();
    user.setUsername("彭倩");
    user.setPassword("197728");
    user.setEmail("123123@qq.com");
    userdao.add(user);
  }
  
  @Test
  public void testfindByUsername()
  {
    UserDao userdao = new UserDao();
    User user = userdao.findByUsername("彭倩");
    System.out.println(user);
  }
}