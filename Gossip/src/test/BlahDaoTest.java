package test;

import java.util.List;

import org.junit.Test;

import cn.elle.Model.dao.BlahDao;
import cn.elle.Model.domain.Blah;

public class BlahDaoTest {
	@Test
public void testaddBlabla(){
	Blah blah = new Blah();
	blah.setUsername("彭倩");
	blah.setDate("2016/11/24 10:00:00");
	blah.setBlabla("好晚了，少年，打完码就去睡吧");
	BlahDao blahdao = new BlahDao();
	blahdao.addBlabla(blah);
}
	@Test
	public void testdeleteBlabla(){
		BlahDao blahdao = new BlahDao();
		blahdao.deleteBlabla("2016/11/24 10:00:00");
	}
	@Test
	public void testfindBlahByUsername(){
		BlahDao blahdao = new  BlahDao();
		List<Blah> blahs = blahdao.findBlahByUsername("彭倩");
		for(Blah blah : blahs){
			System.out.println(blah);
		}
	}
}
