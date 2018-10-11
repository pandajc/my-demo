package com.ljc.mydemo.common.datasource;

public class DBContextHolder {
	
	private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
	
	public static final String DB_TYPE_RW = "dataSourceKeyRW";
    public static final String DB_TYPE_R = "dataSourceKeyR";
    
    public static String getDbType(){
    	String db = contextHolder.get();
    	return db == null ? DB_TYPE_R : db;
    }

    public static void setDbType(String db){
    	contextHolder.set(db);
    }
    
    public static void clearDbType(){
    	contextHolder.remove();
    }
}
