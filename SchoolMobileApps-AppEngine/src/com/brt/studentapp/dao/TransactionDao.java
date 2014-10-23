package com.brt.studentapp.dao;

public interface TransactionDao {
	public void saveItem(Object t);
    public Object getItem(Object transactionId);    
}
