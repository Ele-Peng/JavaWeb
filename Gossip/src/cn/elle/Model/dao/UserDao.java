package cn.elle.Model.dao;


import cn.elle.Model.domain.User;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class UserDao
{
  private String path = "../Webapps/Gossip/users.xml";
  
  public User findByUsername(String username)
  {
	 //创建解析器
    SAXReader reader = new SAXReader();
    try
    {
      Document doc = reader.read(this.path);
      //通过xpath查询得到Element
      Element ele = (Element)doc.selectSingleNode("//user[@username='" + username + "']");
      //校验ele是否为null，如果为null，返回null
      if (ele == null) {
        return null;
      }
      //把ele的数据对象封装到User对象中
      User user = new User();
      String attrUsername = ele.attributeValue("username");  //获取该元素为username
      String attrPassword = ele.attributeValue("password");  //获取该元素为password
      String attrEmail = ele.attributeValue("email");  //获取该元素为email
      user.setUsername(attrUsername);
      user.setPassword(attrPassword);
      user.setEmail(attrEmail);
      return user;
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public void add(User user)
  {
	 //创建解析器
    SAXReader reader = new SAXReader();
    try
    {
      //得到document
      Document doc = reader.read(this.path);
      //得到根元素
      Element root = doc.getRootElement();
      //通过根元素创建新元素
      Element userEle = root.addElement("user");
      //为ueserEle设置属性
      userEle.addAttribute("username", user.getUsername());
      userEle.addAttribute("password", user.getPassword());
      userEle.addAttribute("email", user.getEmail());
     //保存文档
      //创建格式化输出器
      OutputFormat format = new OutputFormat("\t", true);//缩进使用/t，是否换行，是
      format.setTrimText(true);//清空所有换行和缩进
      try
      {
    	 //回写XML
    	 //创建XMLWriter
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
          new FileOutputStream(this.path), "utf-8"));
        writer.write(doc);//保存document对象
        writer.close();
      }
      catch (Exception e)
      {
        throw new RuntimeException(e);
      }
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
