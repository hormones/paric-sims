package com.paric.asset.service;

import com.paric.asset.model.Announcement;

public interface AnnouncementService extends BaseService<Announcement> {

	public String loadAnnouncementTable(Integer pageNumber, Integer pageSize);

}
