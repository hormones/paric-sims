package com.paric.asset.dao.impl;

import org.springframework.stereotype.Repository;

import com.paric.asset.dao.AnnouncementDao;
import com.paric.asset.model.Announcement;

@Repository("announcementDao")
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement> implements AnnouncementDao{

}
