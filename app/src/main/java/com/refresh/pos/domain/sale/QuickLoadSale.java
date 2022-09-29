package com.refresh.pos.domain.sale;

/**
 * 中間   訂單頁面    顯示  總共 和  餐點
 *
 */
public class QuickLoadSale extends Sale {
	
	private Double total;
	private Integer orders;
	

	public QuickLoadSale(int id, String startTime, String endTime, String status, Double total, Integer orders) {
		super(id, startTime, endTime, status, null);
		this.total = total;
		this.orders = orders;
	}
	
	@Override
	public int getOrders() {
		return orders;
	}
	
	@Override
	public double getTotal() {
		return total;
	}

}
