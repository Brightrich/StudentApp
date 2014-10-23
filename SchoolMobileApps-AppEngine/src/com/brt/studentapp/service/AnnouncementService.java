package com.brt.studentapp.service;

import com.brt.studentapp.model.Announcement;

public interface AnnouncementService {
	public void saveAnnouncement(Announcement a);
    public Object getAnnouncement(int id);
}
