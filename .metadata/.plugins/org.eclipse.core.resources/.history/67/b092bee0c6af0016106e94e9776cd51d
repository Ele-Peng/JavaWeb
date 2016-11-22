package cn.elle.Model.service;

import cn.elle.Model.dao.UserDao;
import cn.elle.Model.domain.User;

public class UserService
{
  private UserDao userdao = new UserDao();
  
  public void regist(User user)
    throws UserException
  {
    User _user = this.userdao.findByUsername(user.getUsername());
    if (_user != null) {
      throw new UserException("用户名：" + user.getUsername() + ",已被注册过了");
    }
    this.userdao.add(user);
  }
  
  public User login(User form)
    throws UserException
  {
    User user = this.userdao.findByUsername(form.getUsername());
    if (user == null) {
      throw new UserException("用户名不存在");
    }
    if (!form.getPassword().equals(user.getPassword())) {
      throw new UserException("密码不符");
    }
    return user;
  }
}
