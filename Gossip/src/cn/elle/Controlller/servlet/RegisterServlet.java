package cn.elle.Controlller.servlet;
import cn.elle.Model.domain.User;
import cn.elle.Model.service.UserService;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

public class RegisterServlet
  extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    //依赖userservice
    UserService userservice = new UserService();
    try
    {
      //创建一个User实例
      User form = (User)User.class.newInstance();
      //表单数据封装到User中
      BeanUtils.populate(form, request.getParameterMap());
      
      /*
       * 调用userservice的regist方法，传递form进去
       * 得到异常，获取异常信息，保存到request域中，转发到Regist.jsp中显示
       * 没有异常，注册成功
       */

      
      
      /*
       * 表单校验
       * 1、创建一个Map，用来装载所有的表单错误信息
       * 		在校验过程中，如果失败，向Map中添加错误信息，其中errors为表单字段名称
       * 2、校验过后，查看map长度是否大于0，如果大于0.转发到Regist.jsp
       * 3、如果Map为空，向下执行
       */
      Map<String, String> errors = new HashMap();
      
      String username = form.getUsername();
      if ((username == null) || (username.trim().isEmpty())) {
        errors.put("username", "用户名不能为空");
      } else if ((username.length() < 2) || (username.length() > 15)) {
        errors.put("username", "用户名长度为2~15之间");
      }
      String password = form.getPassword();
      if ((password == null) || (password.trim().isEmpty())) {
        errors.put("password", "密码不能为空");
      } else if ((password.length() < 6) || (password.length() > 16)) {
        errors.put("password", "密码应为6~16之间");
      }
      String confirmedPassword = form.getConfirmedPassword();
      if ((confirmedPassword == null) || (confirmedPassword.trim().isEmpty())) {
        errors.put("confirmedPassword", "再次输入密码不能为空");
      } else if (!form.getPassword().equals(confirmedPassword)) {
        errors.put("confirmedPassword", "两次输入密码不一致");
      }
      String Email = form.getEmail();
      if ((Email == null) || (Email.trim().isEmpty())) {
        errors.put("email", "邮箱不能为空");
      } else if (!Email.matches("^[a-z0-9-]+([.]0[a-z0-9-]+)*@[a-z0-9]+([.][a-z0-9-]+)*$")) {
        errors.put("email", "邮箱格式不符");
      }
      if ((errors != null) && (errors.size() > 0))
      {
//        System.out.println("12");
        //保存error到request域
        request.setAttribute("errors", errors);
        //保存form到request，为了回显
        request.setAttribute("user", form);
        //转发到Regist.jsp
        request.getRequestDispatcher("/user/Regist.jsp").forward(request, response);
        return;
      }
      userservice.regist(form);
      out.print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/Login.jsp" + "'>点击这里去登录吧</a>");
    }
    catch (Exception e)
    {
      request.setAttribute("msg", e.getMessage());
      request.getRequestDispatcher("/user/Regist.jsp").forward(request, response);
    }
  }
}
