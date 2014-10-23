package com.brt.studentapp.datastore.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.brt.studentapp.datastore.dao.DataStoreDao;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class DataStoreDaoImpl implements DataStoreDao{

	@Override
	public void saveItem(String kind, String name, String enKind, HashMap<String,String> mapData) {
		Key key = KeyFactory.createKey(kind,name);
	    Entity en = new Entity(enKind, key);
	   
	    Set mapSet = (Set) mapData.entrySet();
        Iterator mapIterator = mapSet.iterator();
        System.out.println("Display the key/value of HashMap.");
        while (mapIterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) mapIterator.next();
                String keyValue = (String) mapEntry.getKey();
                String value = (String) mapEntry.getValue();                
                en.setProperty(keyValue, value);                
        }

	    
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    datastore.put(en);

	}	

}
