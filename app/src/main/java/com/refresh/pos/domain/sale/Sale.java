package com.refresh.pos.domain.sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.refresh.pos.domain.inventory.LineItem;
import com.refresh.pos.domain.inventory.Product;

/**
 * 銷售訂單操作
 */
public class Sale {
	
	private final int id;
	private String startTime;
	private String endTime;
	private String status;
	private List<LineItem> items;
	

	public Sale(int id, String startTime) {
		this(id, startTime, startTime, "", new ArrayList<LineItem>());
	}
	
	/**
	 * 建構新訂單
	 */
	public Sale(int id, String startTime, String endTime, String status, List<LineItem> items) {
		this.id = id;
		this.startTime = startTime;
		this.status = status;
		this.endTime = endTime;
		this.items = items;
	}
	
	/**
	 * 回傳訂單內容
	 */
	public List<LineItem> getAllLineItem(){
		return items;
	}
	
	/**
	 *新增商品到訂單

	 */
	public LineItem addLineItem(Product product, int quantity) {
		
		for (LineItem lineItem : items) {
			if (lineItem.getProduct().getId() == product.getId()) {
				lineItem.addQuantity(quantity);
				return lineItem;
			}
		}
		
		LineItem lineItem = new LineItem(product, quantity);
		items.add(lineItem);
		return lineItem;
	}
	
	public int size() {
		return items.size();
	}
	

	public LineItem getLineItemAt(int index) {
		if (index >= 0 && index < items.size())
			return items.get(index);
		return null;
	}

	/**
	 * 回傳訂單總價
	 **/
	public double getTotal() {
		double amount = 0;
		for(LineItem lineItem : items) {
			amount += lineItem.getTotalPriceAtSale();
		}
		return amount;
	}

	public int getId() {
		return id;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getStatus() {
		return status;
	}
	
	/**
	 *回傳總數量
	 */
	public int getOrders() {
		int orderCount = 0;
		for (LineItem lineItem : items) {
			orderCount += lineItem.getQuantity();
		}
		return orderCount;
	}

	/**
	 *回傳訂單細節
	 */
	public Map<String, String> toMap() {	
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",id + "");
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("status", getStatus());
		map.put("total", getTotal() + "");
		map.put("orders", getOrders() + "");
		
		return map;
	}

	/**
	 * 刪除訂單裡的項目
	 * */
	public void removeItem(LineItem lineItem) {
		items.remove(lineItem);
	}

}