package com.refresh.pos.domain.inventory;

import java.util.List;

import com.refresh.pos.techicalservices.inventory.InventoryDao;

/**
 * 更新庫存
 */
public class Stock {

	private InventoryDao inventoryDao;

	/**

	 建構ProductCatalog 中庫存的資料訪問對象。
	 */
	public Stock(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	

	public boolean addProductLot(String dateAdded, int quantity, Product product, double cost) {
		ProductLot productLot = new ProductLot(ProductLot. UNDEFINED_ID, dateAdded, quantity, product, cost);
		int id = inventoryDao.addProductLot(productLot);
		return id != -1;
	}


	public List<ProductLot> getProductLotByProductId(int id) {
		return inventoryDao.getProductLotByProductId(id);
	}

	/**
	 *回傳所有商品

	 */
	public List<ProductLot> getAllProductLot() {
		return inventoryDao.getAllProductLot();
	}

	/**
	 * 透過ID回傳庫存

	 */
	public int getStockSumById(int id) {
		return inventoryDao.getStockSumById(id);
	}

	/**
	 * 新增數量

	 */
	public void updateStockSum(int productId, int quantity) {
		inventoryDao.updateStockSum(productId,quantity);
		
	}

	/**
	 * 清除庫存
	 */
	public void clearStock() {
		inventoryDao.clearStock();
		
	}
	

}
