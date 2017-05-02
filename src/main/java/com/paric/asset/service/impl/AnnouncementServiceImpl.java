package com.paric.asset.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.paric.asset.model.Announcement;
import com.paric.asset.service.AnnouncementService;

@Service("announcementService")
@Transactional
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement> implements AnnouncementService{

}
