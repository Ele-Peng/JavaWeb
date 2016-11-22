package cn.elle.Controller.servlet;

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
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    UserService userservice = new UserService();
    try
    {
      User form = (User)User.class.newInstance();
      
      BeanUtils.populate(form, request.getParameterMap());
      try
      {
        User user = userservice.login(form);
        
        request.getSession().setAttribute("sessionUser", user.getUsername());
        response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
      }
      catch (UserException e1)
      {
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
