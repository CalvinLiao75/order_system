package com.refresh.pos.domain.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 *銷售訂單項。
 * 
 */
public class LineItem {

	private final Product product;
	private int quantity;
	private int id;
	private double unitPriceAtSale;

	/**
	 * UNDEFINED ID 靜態變數.
	 */
	public static final int UNDEFINED = -1;

	/**
	 * 構造一個新的LineItem。

	 */
	public LineItem(Product product, int quantity) {
		this(UNDEFINED, product, quantity, product.getUnitPrice());
	}

	/**
	 * 建一個新的LineItem。

	 */
	public LineItem(int id, Product product, int quantity,
			double unitPriceAtSale) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.unitPriceAtSale = unitPriceAtSale;
	}

	/**
	 * Return    商品
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Return   商品數量
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 設置產品數量
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 增加產品數量
	 */
	public void addQuantity(int amount) {
		this.quantity += amount;
	}

	/**
	 * Returns    總價

	 */
	public double getTotalPriceAtSale() {
		return unitPriceAtSale * quantity;
	}

	/**
	 * 回傳描述

	 */
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", product.getName());
		map.put("quantity", quantity + "");
		map.put("price", getTotalPriceAtSale() + "");
		return map;

	}

	/**
	 * 回傳  ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 設ID

	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 設置商品單價
	 */
	public void setUnitPriceAtSale(double unitPriceAtSale) {
		this.unitPriceAtSale = unitPriceAtSale;
	}

	/**
	 * Returns 商品單價

	 */
	public Double getPriceAtSale() {
		return unitPriceAtSale;
	}

	/**
	 * 辨別兩項商品是否相等
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (!(object instanceof LineItem))
			return false;
		LineItem lineItem = (LineItem) object;
		return lineItem.getId() == this.getId();
	}
}
