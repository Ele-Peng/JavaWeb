package cn.elle.Controlller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.elle.Model.dao.BlahDao;
import cn.elle.Model.domain.Blah;
import cn.elle.Model.service.BlahService;

public class BlaBla extends HttpServlet {


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    PrintWriter out = response.getWriter();
		    //依赖blahservice
		    BlahService blahservice = new BlahService();
		    Blah form = new Blah();
		    String username = (String) request.getSession().getAttribute("sessionUser");
		    form.setUsername(username);
		    Date _date = new Date(); 
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    String date = dateFormat.format(_date);
		    form.setDate(date);
		    String blabla = request.getParameter("blabla");
		    form.setBlabla(blabla);
		    /*List<Blah> blahs = blahservice.getBlahs(username);
		    request.setAttribute("blahs",blahs);*/
		    System.out.println(form);
		    try
		    {		      
		      
		      /*
		       * 表单校验
		       * 1、创建一个Map，用来装载所有的表单错误信息
		       * 		在校验过程中，如果失败，向Map中添加错误信息，其中errors为表单字段名称
		       * 2、校验过后，查看map长度是否大于0，如果大于0.转发到Regist.jsp
		       * 3、如果Map为空，向下执行
		       */
		      Map<String, String> blablaerrors = new HashMap();
		      if ((blabla == null) || (blabla.trim().isEmpty())) {
		        blablaerrors.put("blabla", "内容为空");
		      } else if (blabla.length() > 140 ) {
		        blablaerrors.put("username", "内容长度应不超过140个字~·");
		      }
		    
		      if ((blablaerrors != null) && (blablaerrors.size() > 0))
		      {
		        //保存error到request域
		        request.setAttribute("blablaerrors", blablaerrors);
		        //保存form到request，为了回显
		        request.setAttribute("blah", form);
		        //转发到Regist.jsp
		        request.getRequestDispatcher("/user/blabla.jsp").forward(request, response);
		        return;
		      }
		     blahservice.send(form);
		      out.print("<h1>发送成功</h1><a href='" + request.getContextPath() + "/user/blabla.jsp" + "'>点击这里去看看吧</a>");
		    }
		    catch (Exception e)
		    {
		      request.setAttribute("msg", e.getMessage());
		      request.getRequestDispatcher("/user/blabla.jsp").forward(request, response);
		    }
		  
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        String message = request.getParameter("message"); 
	        Blah blah = new Blah();
	        String date = message;
	        BlahDao blahdao = new BlahDao();
	        blahdao.deleteBlabla(date);
		
	}

}
