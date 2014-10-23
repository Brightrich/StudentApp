package com.brt.studentapp.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.brt.studentapp.dao.TransactionDao;
import com.brt.studentapp.model.Announcement;
import com.brt.studentapp.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService {
	
	private TransactionDao transactionDao;
		
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveAnnouncement(Announcement a) {
		transactionDao.saveItem(a);
		
	}

	@Override
	public Announcement getAnnouncement(int id) {
		Announcement a = (Announcement) transactionDao.getItem(id);
		return a;
	}

}
