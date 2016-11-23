package test.dao;

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
    user.setUsername("ลํูป");
    user.setPassword("197728");
    userdao.add(user);
  }
  
  @Test
  public void testfindByUsername()
  {
    UserDao userdao = new UserDao();
    User user = userdao.findByUsername("ลํูป");
    System.out.println(user);
  }
}