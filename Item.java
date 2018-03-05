package com.invenrtory;

public class Item {
	private String itemName;
	private int qty;
	private double sellPrice;
	private double buyPrice;
	private double buyValue;

	public Item(String itemName, double sellPrice, double buyPrice) {
		this.itemName = itemName;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getBuyValue() {
		return buyValue;
	}

	public void setBuyValue(double buyValue) {
		this.buyValue = buyValue;
	}

	@Override
	public String toString() {
		return this.itemName + "\t\t" + this.buyPrice + "\t\t" + this.sellPrice + "\t\t" + this.qty + "\t  "
				+ this.buyValue;
	}

}
