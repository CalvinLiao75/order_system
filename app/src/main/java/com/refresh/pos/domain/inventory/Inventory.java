package com.refresh.pos.domain.inventory;

import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.techicalservices.inventory.InventoryDao;

/**
 *       商品目錄和存貨
 */
public class Inventory {

	private Stock stock;
	private ProductCatalog productCatalog;
	private static Inventory instance = null;
	private static InventoryDao inventoryDao = null;

	/**
	 *建構清單的數據訪問物件。

	 */
	private Inventory() throws NoDaoSetException {
		if (!isDaoSet()) {
			throw new NoDaoSetException();
		}
		stock = new Stock(inventoryDao);
		productCatalog = new ProductCatalog(inventoryDao);
	}

	/**
	 *確定 DAO 是否已設置。

	 */
	public static boolean isDaoSet() {
		return inventoryDao != null;
	}

	/**
	 * 設置資料庫連接器。

	 */
	public static void setInventoryDao(InventoryDao dao) {
		inventoryDao = dao;
	}

	/**
	 * Return       產品種類
	 */
	public ProductCatalog getProductCatalog() {
		return productCatalog;
	}

	/**
	 * 回傳庫存

	 */
	public Stock getStock() {
		return stock;
	}


	public static Inventory getInstance() throws NoDaoSetException {
		if (instance == null)
			instance = new Inventory();
		return instance;
	}

}
