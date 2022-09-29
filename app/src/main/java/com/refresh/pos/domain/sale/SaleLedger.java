package com.refresh.pos.domain.sale;

import java.util.Calendar;
import java.util.List;

import com.refresh.pos.techicalservices.NoDaoSetException;
import com.refresh.pos.techicalservices.sale.SaleDao;

/**
 *訂單紀錄

 */
public class SaleLedger {
	
	private static SaleLedger instance = null;
	private static SaleDao saleDao = null;
	
	private SaleLedger() throws NoDaoSetException {
		if (!isDaoSet()) {
			throw new NoDaoSetException();
		}
	}
	
	/**
	 *確認DAO是否設置
	 */
	public static boolean isDaoSet() {
		return saleDao != null;
	}
	
	public static SaleLedger getInstance() throws NoDaoSetException {
		if (instance == null) instance = new SaleLedger();
		return instance;
	}

	/**
	 * 資料庫連線

	 */
	public static void setSaleDao(SaleDao dao) {
		saleDao = dao;	
	}
	
	/**
	 * 回傳所有訂單紀錄

	 */
	public List<Sale> getAllSale() {
		return saleDao.getAllSale();
	}
	
	/**
	 * 透過ID尋找訂單

	 */
	public Sale getSaleById(int id) {
		return saleDao.getSaleById(id);
	}

	/**
	 * 清除紀錄
	 */
	public void clearSaleLedger() {
		saleDao.clearSaleLedger();
	}

	/**
	 * 回傳時間內訂單

	 */
	public List<Sale> getAllSaleDuring(Calendar start, Calendar end) {
		return saleDao.getAllSaleDuring(start, end);
	}
}
