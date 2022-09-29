package com.refresh.pos.techicalservices;

/**
 * 資料庫中表名稱的 Enum。
 *
 *
 */
public enum DatabaseContents {
	
	DATABASE("com.refresh.db1"),
	TABLE_PRODUCT_CATALOG("product_catalog"),
	TABLE_STOCK("stock"),
	TABLE_SALE("sale"),
	TABLE_SALE_LINEITEM("sale_lineitem"),
	TABLE_STOCK_SUM("stock_sum"),
	LANGUAGE("language");
	
	private String name;
	
	/**
	 * 建構資料庫內容
	 *
	 * */
	private DatabaseContents(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString() {
		return name;
	}
}
