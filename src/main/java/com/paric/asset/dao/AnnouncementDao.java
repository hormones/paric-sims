package com.paric.asset.dao;

import java.util.List;

import com.paric.asset.model.Announcement;

public interface AnnouncementDao extends BaseDao<Announcement> {

	public List<Object[]> loadAnnouncementTable(Integer pageNumber, Integer pageSize);

	public int getAnnouncementTableRows();

}
