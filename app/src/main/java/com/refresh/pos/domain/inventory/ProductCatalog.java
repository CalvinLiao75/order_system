package com.refresh.pos.domain.inventory;

import java.util.List;

import com.refresh.pos.techicalservices.inventory.InventoryDao;

/**
 * 商品種類
 */
public class ProductCatalog {

	private InventoryDao inventoryDao;

	/**
	 * 建構 ProductCatalog 中庫存的資料訪問對象。
	 */
	public ProductCatalog(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	/**
	 * 建構產品並將產品新曾到庫存.

	 */
	public boolean addProduct(String name, String barcode, double salePrice) {
		Product product = new Product(name, barcode, salePrice);		
		int id = inventoryDao.addProduct(product);
		return id != -1;
	}

	/**
	 * 編輯商品

	 */
	public boolean editProduct(Product product) {
		boolean respond = inventoryDao.editProduct(product);
		return respond;
	}
		
	/**
	 * Returns product from inventory finds by barcode.

	 */
	public Product getProductByBarcode(String barcode) {
		return inventoryDao.getProductByBarcode(barcode);
	}
	
	/**
	 * 透過ID回傳商品

	 */
	public Product getProductById(int id) {
		return inventoryDao.getProductById(id);
	}
	
	/**
	 * 回傳所有商品

	 */
	public List<Product> getAllProduct() {
		return inventoryDao.getAllProduct();
	}

	/**
	 * 按名稱回傳商品庫存
	 */
	public List<Product> getProductByName(String name) {
		return inventoryDao.getProductByName(name);
	}

	/**
	 * 搜尋商品

	 */
	public List<Product> searchProduct(String search) {
		return inventoryDao.searchProduct(search);
	}

	/**
	 *
	 * 清除 ProductCatalog。
	 */
	public void clearProductCatalog() {
		inventoryDao.clearProductCatalog();
	}
	
	/**
	 *
	 * 庫存中的隱藏產品。

	 */
	public void suspendProduct(Product product) {
		inventoryDao.suspendProduct(product);
	}

	
}
