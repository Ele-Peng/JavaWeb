package cn.elle.Model.dao;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.elle.Model.domain.Blah;


public class BlahDao {
private String path = "../Webapps/Gossip/Blahs.xml"; 
public void addBlabla(Blah blah){
	SAXReader reader = new SAXReader();
	try {
		Document doc = reader.read(this.path);
		Element root = doc.getRootElement();
		Element _user = root.addElement("user");
		Element _username = _user.addElement("username");
		Element _date = _user.addElement("date");
		Element _blabla = _user.addElement("blabla");
		_username.setText(blah.getUsername());
		_date.setText(blah.getDate());
		_blabla.setText(blah.getBlabla());
		//回写XML
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(this.path),format);
		writer.write(doc);
		writer.close();

	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}
public List<Blah> findBlahByUsername(String username){
	SAXReader reader = new SAXReader();
	List<Blah> blahs = new ArrayList<Blah>();
	try {
		Document doc = reader.read(this.path);
		List<Node> list = doc.selectNodes("//username");
		for(Node node : list){
			Blah _blah = new Blah();
			String _username = node.getText();
			if(username.equals(_username)){
				Element _user = node.getParent();
				String _date = _user.element("date").getText();
				String _blabla = _user.element("blabla").getText();
				_blah.setUsername(_username);
				_blah.setDate(_date);
				_blah.setBlabla(_blabla);
				blahs.add(_blah);
			}
		}
		//回写XML
				OutputFormat format = OutputFormat.createPrettyPrint();
				XMLWriter writer = new XMLWriter(new FileOutputStream(this.path),format);
				writer.write(doc);
				writer.close();
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	return blahs;
}
public void deleteBlabla(String date){
	//创建解析器
	SAXReader reader = new SAXReader();
	//得到document
	try {
		Document doc = reader.read(path);
		//获取所有date xpath://date
		List<Node> list = doc.selectNodes("//date");
		//遍历list集合
		for(Node node : list){
			//得到date的值
			String _date = node.getText();
			if(_date.equals(date)){
				//得到_bla节点
				Element _bla = node.getParent();
				//获取_bla的父节点
				Element _user = _bla.getParent();
				//删除_bla
				_user.remove(_bla);
			}
		}
		//回写XML
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(this.path),format);
		writer.write(doc);
		writer.close();
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	
	
}
}
