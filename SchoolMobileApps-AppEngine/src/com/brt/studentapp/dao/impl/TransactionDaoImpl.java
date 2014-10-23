package com.brt.studentapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.brt.studentapp.common.Constant;
import com.brt.studentapp.dao.TransactionDao;
import com.brt.studentapp.model.Announcement;


public class TransactionDaoImpl implements TransactionDao{

	private JdbcTemplate jdbcTemplate;
	
	/**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	String sql_INSERT = "insert into " + Constant.DAOProperties.TABLENAME + " ("+ Constant.DAOProperties.TABLECOLUMN +") "
            + "values ("+ Constant.DAOProperties.VALUES +")";  
    
    String sql_SELECT_BY_ID = "select " + Constant.DAOProperties.TABLECOLUMN + " from " + Constant.DAOProperties.TABLENAME + " WHERE " + Constant.DAOProperties.PK_ID + " =?" ;
	
    public void saveItem(Object t) {        
    	HashMap<String,Object> map = defineQuery(t, Constant.DAOProperties.ACTION_CREATE);
    	jdbcTemplate.update((String)map.get(Constant.DAOProperties.SQL_QUERY), (Object[])map.get(Constant.DAOProperties.SQL_PARAM), (int[])map.get(Constant.DAOProperties.SQL_DATA_TYPE));        
    }          

    public Object getItem(Object transactionId) {
        
    	HashMap<String,Object> map = defineQuery(transactionId, Constant.DAOProperties.ACTION_RETRIEVE_BY_ID);
    	
    	@SuppressWarnings("unchecked")
		List<Object> list = jdbcTemplate.query((String)map.get(Constant.DAOProperties.SQL_QUERY), (Object[])map.get(Constant.DAOProperties.SQL_PARAM), (RowMapper)map.get(Constant.DAOProperties.SQL_ROW_MAPPER));
        System.out.println("LIST TRX");
        if (list!=null && list.size()>0){
        	System.out.println("LIST TRX " + list);
            return list.get(0);
        }
        System.out.println("LIST NULL");
        return null;
    }  
    
    private HashMap<String, Object> defineQuery(Object o, String action){
    	String sql = "";
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	Object[] obj = null;
    	int[] dataType = null;
    	
    	if(action.equals(Constant.DAOProperties.ACTION_CREATE)){
    		
    		if(o instanceof Announcement){
    			
    			System.out.println("SQL INSERT PURE = " + sql_INSERT);
    			
    			sql = sql_INSERT.replace(Constant.DAOProperties.TABLENAME, Constant.AnnouncementProperties.TABLENAME);
    			System.out.println("SQL INSERT TABLENAME = " + sql);
    			sql = sql.replace(Constant.DAOProperties.TABLECOLUMN, Constant.AnnouncementProperties.TABLECOLUMN);
    			System.out.println("SQL INSERT TABLECOLUMN = " + sql);
    			sql = sql.replace(Constant.DAOProperties.VALUES, Constant.AnnouncementProperties.BINDING_VALUES);
    			
    			System.out.println("SQL INSERT STATEMENT = " + sql);
    			
    			map.put(Constant.DAOProperties.SQL_QUERY, sql);
    			Announcement a = (Announcement)o;
    			obj = new Object[]{a.getId(),a.getTitle(),a.getContent()};
    			dataType = new int[]{Types.INTEGER,Types.VARCHAR,Types.VARCHAR};    			
    		}
    		
    		map.put(Constant.DAOProperties.SQL_QUERY, sql);
        	map.put(Constant.DAOProperties.SQL_PARAM, obj);
        	map.put(Constant.DAOProperties.SQL_DATA_TYPE, dataType);
        	
        	return map;    		
        	
    	} else if(action.equals(Constant.DAOProperties.ACTION_RETRIEVE_BY_ID)){
    		
    		if(o instanceof Announcement){
    			sql = sql_SELECT_BY_ID.replace(Constant.DAOProperties.TABLENAME, Constant.AnnouncementProperties.TABLENAME);    			
    			sql = sql.replace(Constant.DAOProperties.TABLECOLUMN, Constant.AnnouncementProperties.TABLECOLUMN);
    			sql = sql.replace(Constant.DAOProperties.PK_ID, Constant.AnnouncementProperties.PK_ID);
    			
    			map.put(Constant.DAOProperties.SQL_QUERY, sql);
    			    			
    			obj = new Object[]{(Integer)o};
    			map.put(Constant.DAOProperties.SQL_PARAM, obj);
            	map.put(Constant.DAOProperties.SQL_ROW_MAPPER, new AnnouncementRowMapper());
            	
            	return map;    	
    			
    		}
    		
    	}
    	    	    
    	return null;
    }
    
    
    class AnnouncementRowMapper implements RowMapper{

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Announcement a = new Announcement();
        	a.setId(rs.getString(Constant.AnnouncementProperties.PK_ID));
            a.setTitle(rs.getString(Constant.AnnouncementProperties.TITLE));
            a.setContent(rs.getString(Constant.AnnouncementProperties.CONTENT));
            return a;
        }
    }
    
}
