package com.refresh.pos.techicalservices;

/**
 * 用於直接訪問資料庫。
 *
 *
 */
public class DatabaseExecutor {

	private static Database database;
	private static DatabaseExecutor instance;
	
	private DatabaseExecutor() {
		
	}
	
	/**
	 * 設置用於資料庫執行器的資料庫。
	 */
	public static void setDatabase(Database db) {
		database = db;
	}
	
	public static DatabaseExecutor getInstance() {
		if (instance == null)
			instance = new DatabaseExecutor();
		return instance;
	}
	
	/**
	 * 刪除資料庫中的所有數據。
	 */
	public void dropAllData() {
		execute("DELETE FROM " + DatabaseContents.TABLE_PRODUCT_CATALOG + ";");
		execute("DELETE FROM " + DatabaseContents.TABLE_SALE + ";");
		execute("DELETE FROM " + DatabaseContents.TABLE_SALE_LINEITEM + ";");
		execute("DELETE FROM " + DatabaseContents.TABLE_STOCK + ";");
		execute("DELETE FROM " + DatabaseContents.TABLE_STOCK_SUM + ";");
		execute("VACUUM;");
	}
	
	/**
	 * 直接執行到資料庫。

	 */
	private void execute(String queryString) {
		database.execute(queryString);
	}
	
	
}

