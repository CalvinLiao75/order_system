package com.refresh.pos.techicalservices;

import java.util.List;

/**
 * CRUD 介面

 */
public interface Database {
	

	public List<Object> select(String queryString);
	

	public int insert(String tableName, Object content);
	

	boolean update(String tableName, Object content);

	boolean delete(String tableName, int id);
	
	/**
	 * 直接執行到資料庫

	 */
	boolean execute(String queryString);
}
