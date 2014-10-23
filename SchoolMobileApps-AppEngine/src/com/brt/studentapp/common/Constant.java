package com.brt.studentapp.common;

public class Constant {

	public static class DAOProperties{		
		public static final String ACTION_CREATE = "CREATE";
		public static final String ACTION_RETRIEVE_BY_ID = "RETRIEVE_BY_ID";
		public static final String ACTION_UPDATE = "UPDATE";
		public static final String ACTION_DELETE = "DELETE";
		
		public static final String TABLENAME = "TABLENAME";
		public static final String TABLECOLUMN = "TABLECOLUMN";
		public static final String VALUES = "VALUES";
		
		public static final String SQL_QUERY = "QUERY";
		public static final String SQL_PARAM = "PARAM";
		public static final String SQL_DATA_TYPE = "DATA_TYPE";
		public static final String SQL_ROW_MAPPER = "ROW_MAPPER";
		public static final String PK_ID = "PK_ID";
		
	}
	
	public static class AnnouncementProperties{
		public static final String TABLENAME = "M_ANNOUNCEMENT";
		public static final String PK_ID = "ID";
		public static final String TITLE = "TITLE";
		public static final String CONTENT = "CONTENT";		
		public static final String TABLECOLUMN = PK_ID +", " + TITLE+", " + CONTENT;
		public static final String BINDING_VALUES = "?, ?, ?";
	}
}
