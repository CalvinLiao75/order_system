package com.refresh.pos.domain.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * 新增商品。
 */
public class Product {

	private int id;
	private String name;
	private String barcode;
	private double unitPrice;
	
	/**
	 * 未建立商品ID為-1
	 */
	public static final int UNDEFINED_ID = -1;

	/**
	 * 產品細項結構
	 */
	public Product(int id, String name, String barcode, double salePrice) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
		this.unitPrice = salePrice;
	}
	
	/**
	 * 建立新商品
	 *
	 */
	public Product(String name, String barcode, double salePrice) {
		this(UNDEFINED_ID, name, barcode, salePrice);
	}

	/**
	 * 回傳商品名

	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 為商品設置      名稱

	 */
	public void setName(String name) {
		this.name = name;
	}


	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * 為商品設定單價

	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 回傳商品 id

	 */
	public int getId() {
		return id;
	}
	

	public String getBarcode() {
		return barcode;
	}
	
	/**
	 * 回傳商品價格

	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * 回傳商品描述
	 */
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id + "");
		map.put("name", name);
		map.put("barcode", barcode);
		map.put("unitPrice", unitPrice + "");
		return map;
		
	}
	
}
