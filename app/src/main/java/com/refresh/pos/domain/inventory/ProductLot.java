package com.refresh.pos.domain.inventory;

import java.util.HashMap;
import java.util.Map;

import com.refresh.pos.domain.DateTimeStrategy;

/**
 *
 * 新增庫存
 * 
 */
public class ProductLot {
	
	private int id;
	private String dateAdded;
	private int quantity;
	private Product product;
	private double unitCost;
	

	public static final int UNDEFINED_ID = -1;

	/**
	 * 新增庫存紀錄function.
	 */
	public ProductLot(int id, String dateAdded, int quantity, Product product, double unitCost) {
		this.id = id;
		this.dateAdded = dateAdded;
		this.quantity = quantity;
		this.product = product;
		this.unitCost = unitCost;
	}
	
	/**
	 * 回傳      新增日期
	  */
	public String getDateAdded() {
		return dateAdded;
	}
	
	/**
	 * 回傳     數量
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 回傳     成本
	 */
	public double unitCost() {
		return unitCost;
	}

	/**
	 * 回傳       id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 回傳      商品

	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 回傳 細節

	 */
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id + "");
		map.put("dateAdded", DateTimeStrategy.format(dateAdded));
		map.put("quantity", quantity + "");
		map.put("productName", product.getName());
		map.put("cost", unitCost + "");
		return map;
	}
}
