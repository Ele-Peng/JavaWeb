package cn.elle.Controlller.servlet;
import cn.elle.Model.domain.User;
import cn.elle.Model.service.UserException;
import cn.elle.Model.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

public class LoginServlet
  extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.setCharacterEncoding("utf-8");//请求编码post
    response.setContentType("text/html;charset=utf-8");//响应编码
    PrintWriter out = response.getWriter();
    UserService userservice = new UserService(); //依赖UserService
    try
    {
      //封装表单到User form中，
      User form = (User)User.class.newInstance();
      BeanUtils.populate(form, request.getParameterMap());
      try
      {
    	//调用service中的login()方法，得到返回的User form
        User user = userservice.login(form);
        //如果没有异常，保存信息到session中，重定向到welcome.jsp
        request.getSession().setAttribute("sessionUser", user.getUsername());
        response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
      }
      catch (UserException e1)
      {
         //如果抛出异常，获取异常信息，保存到request域中，再保存form，转发到Login.jsp
        request.setAttribute("msg", e1.getMessage());
        request.setAttribute("user", form);
        request.getRequestDispatcher("/user/Login.jsp").forward(request, response);
      }
      return;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
