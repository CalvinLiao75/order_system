package com.refresh.pos.domain.sale;

import com.refresh.pos.domain.DateTimeStrategy;
import com.refresh.pos.domain.inventory.Inventory;
import com.refresh.pos.domain.inventory.LineItem;
import com.refresh.pos.domain.inventory.Product;
import com.refresh.pos.domain.inventory.Stock;
import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.techicalservices.sale.SaleDao;

/**
 * 處理所有銷售流程
 * 

 *
 */
public class Register {
	private static Register instance = null;
	private static SaleDao saleDao = null;
	private static Stock stock = null;
	
	private Sale currentSale;
	
	private Register() throws NoDaoSetException {
		if (!isDaoSet()) {
			throw new NoDaoSetException();
		}
		stock = Inventory.getInstance().getStock();
		
	}
	
	/**
	 * 確定DAO是否已設置。

	 */
	public static boolean isDaoSet() {
		return saleDao != null;
	}
	
	public static Register getInstance() throws NoDaoSetException {
		if (instance == null) instance = new Register();
		return instance;
	}

	/**
	 * 導入銷售數據

	 */
	public static void setSaleDao(SaleDao dao) {
		saleDao = dao;	
	}
	
	/**
	 * 發起新的銷售。

	 */
	public Sale initiateSale(String startTime) {
		if (currentSale != null) {
			return currentSale;
		}
		currentSale = saleDao.initiateSale(startTime);
		return currentSale;
	}
	
	/**
	 * 將產品添加到銷售。

	 */
	public LineItem addItem(Product product, int quantity) {
		if (currentSale == null)
			initiateSale(DateTimeStrategy.getCurrentTime());
		
		LineItem lineItem = currentSale.addLineItem(product, quantity);
		
		if (lineItem.getId() == LineItem.UNDEFINED) {
			int lineId = saleDao.addLineItem(currentSale.getId(), lineItem);
			lineItem.setId(lineId);
		} else {
			saleDao.updateLineItem(currentSale.getId(), lineItem);
		}
		
		return lineItem;
	}
	
	/**
	 * 回傳總價
	 */
	public double getTotal() {
		if (currentSale == null) return 0;
		return currentSale.getTotal();
	}

	/**
	 * 結束銷售

	 */
	public void endSale(String endTime) {
		if (currentSale != null) {
			saleDao.endSale(currentSale, endTime);
			for(LineItem line : currentSale.getAllLineItem()){
				stock.updateStockSum(line.getProduct().getId(), line.getQuantity());
			}
			currentSale = null;
		}
	}
	
	/**
	 * 回傳當前銷售.

	 */
	public Sale getCurrentSale() {
		if (currentSale == null)
			initiateSale(DateTimeStrategy.getCurrentTime());
		return currentSale;
	}


	public boolean setCurrentSale(int id) {
		currentSale = saleDao.getSaleById(id);
		return false;
	}

	/**
	 * 確認是否有銷售
	 */
	public boolean hasSale(){
		if(currentSale == null)return false;
		return true;
	}
	
	/**
	 * Cancels the current Sale.
	 */
	public void cancleSale() {
		if (currentSale != null){
			saleDao.cancelSale(currentSale,DateTimeStrategy.getCurrentTime());
			currentSale = null;
		}
	}

	/**
	 * 編輯特頂品項

	 */
	public void updateItem(int saleId, LineItem lineItem, int quantity, double priceAtSale) {
		lineItem.setUnitPriceAtSale(priceAtSale);
		lineItem.setQuantity(quantity);
		saleDao.updateLineItem(saleId, lineItem);
	}

	/**
	 * 移除 某樣 從當前訂單

	 */
	public void removeItem(LineItem lineItem) {
		saleDao.removeLineItem(lineItem.getId());
		currentSale.removeItem(lineItem);
		if (currentSale.getAllLineItem().isEmpty()) {
			cancleSale();
		}
	}
	
}