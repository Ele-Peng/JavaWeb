package cn.elle.Model.service;

import java.util.ArrayList;
import java.util.List;

import cn.elle.Model.dao.BlahDao;
import cn.elle.Model.domain.Blah;

public class BlahService {

	public void send(Blah blah) {
		BlahDao blahdao = new BlahDao();
		blahdao.addBlabla(blah);
	}
	public void delete(String date){
		BlahDao blahdao = new BlahDao();
		blahdao.deleteBlabla(date);
	}
	public List<Blah> getBlahs(String username){
		BlahDao blahdao = new BlahDao();
		return blahdao.findBlahByUsername(username);
	}

}
