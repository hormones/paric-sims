package com.paric.asset.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paric.asset.dao.AnnouncementDao;
import com.paric.asset.dao.StudentDao;
import com.paric.asset.model.Announcement;
import com.paric.asset.service.AnnouncementService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("announcementService")
@Transactional
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement> implements AnnouncementService{
	
	@Autowired
	private AnnouncementDao announcementDao;
	
	@Override
	public String loadAnnouncementTable(Integer pageNumber, Integer pageSize) {
		List<Object[]> list = announcementDao.loadAnnouncementTable(pageNumber, pageSize);
		int total = announcementDao.getAnnouncementTableRows();
		JSONObject jsonObjects = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (Object[] object : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", object[0]);
			jsonObject.put("name", object[1]);
			jsonObject.put("administratorName", object[2]);
			jsonObject.put("modifyTime", String.valueOf(object[3]));
			jsonArray.add(jsonObject);
		}
		jsonObjects.put("rows", jsonArray);
		jsonObjects.put("total", total);
		return jsonObjects.toString();
	}

}
