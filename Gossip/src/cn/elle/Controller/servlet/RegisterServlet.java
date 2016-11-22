package cn.elle.Controller.servlet;

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
    UserService userservice = new UserService();
    try
    {
      User form = (User)User.class.newInstance();
      
      BeanUtils.populate(form, request.getParameterMap());
      







      Map<String, String> errors = new HashMap();
      
      String username = form.getUsername();
      if ((username == null) || (username.trim().isEmpty())) {
        errors.put("username", "�û�������Ϊ��");
      } else if ((username.length() < 2) || (username.length() > 15)) {
        errors.put("username", "�û������ȱ�����2~15֮��");
      }
      String password = form.getPassword();
      if ((password == null) || (password.trim().isEmpty())) {
        errors.put("password", "���벻��Ϊ��");
      } else if ((password.length() < 6) || (password.length() > 16)) {
        errors.put("password", "����λ����6~16֮��");
      }
      String confirmedPassword = form.getConfirmedPassword();
      if ((confirmedPassword == null) || (confirmedPassword.trim().isEmpty())) {
        errors.put("confirmedPassword", "�ٴ��������벻��Ϊ��");
      } else if (!form.getPassword().equals(confirmedPassword)) {
        errors.put("confirmedPassword", "�������벻һ��");
      }
      String Email = form.getEmail();
      if ((Email == null) || (Email.trim().isEmpty())) {
        errors.put("email", "���䲻��Ϊ��");
      } else if (!Email.matches("^[a-z0-9-]+([.]0[a-z0-9-]+)*@[a-z0-9]+([.][a-z0-9-]+)*$")) {
        errors.put("email", "�����ʽ����");
      }
      if ((errors != null) && (errors.size() > 0))
      {
        System.out.println("12");
        
        request.setAttribute("errors", errors);
        
        request.setAttribute("user", form);
        
        request.getRequestDispatcher("/user/Regist.jsp").forward(request, response);
        return;
      }
      userservice.regist(form);
      out.print("<h1>ע��ɹ�</h1><a href='" + request.getContextPath() + "/user/Login.jsp" + "'>�������ȥ��¼��</a>");
    }
    catch (Exception e)
    {
      request.setAttribute("msg", e.getMessage());
      request.getRequestDispatcher("/user/Regist.jsp").forward(request, response);
    }
  }
}
