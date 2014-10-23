package com.brt.studentapp.datastore.dao;

import java.util.HashMap;

public interface DataStoreDao {
	public void saveItem(String kind, String name, String enKind, HashMap<String,String> mapData);
}
