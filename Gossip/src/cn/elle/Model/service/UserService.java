package cn.elle.Model.service;


import cn.elle.Model.dao.UserDao;
import cn.elle.Model.domain.User;

public class UserService
{
  private UserDao userdao = new UserDao();
  
  public void regist(User user)
    throws UserException
  {
	  /*
	   * 如果利用用户名去查询，如果返回空，完成添加
	   * 如果反悔不为空，抛出异常
	   */
    User _user = this.userdao.findByUsername(user.getUsername());
    if (_user != null) {
      throw new UserException("用户名" + user.getUsername() + "已注册");
    }
    this.userdao.add(user);
  }
  
  public User login(User form)
    throws UserException
  {
	//使用form中的username进行查询，得到User user
    User user = this.userdao.findByUsername(form.getUsername());
    if (user == null) {
    	//如果返回空，说明用户名不存在，抛出异常，异常信息为“用户名不存在”
      throw new UserException("用户名不存在");
    }
    if (!form.getPassword().equals(user.getPassword())) {
    	//比较user的password和form的password，如果不同，跑出异常，一场为密码错误
      throw new UserException("密码错误");
    }
    //返回数据中查询到的user，而不是form因为form中只有用户名和密码，而user是所有用户信息~
    return user;
  }
}

