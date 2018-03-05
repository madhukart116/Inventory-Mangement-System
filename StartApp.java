package com.invenrtory;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StartApp {

	static TreeMap<String, Item> inventoryMap = new TreeMap<String, Item>();
	static double previousProfit = 0;
	static double profit = 0;

	public static Item setItem(String itemName, String buyPrice, String sellPrice) {
		Item item = new Item(itemName, Double.parseDouble(sellPrice), Double.parseDouble(buyPrice));
		return item;
	}

	public static void insertItem(Item item) {
		inventoryMap.put(item.getItemName(), item);
	}

	public static void updateItem(Item item, String qty, String type) {
		int quantity;
		if (type.equals("buy")) {
			quantity = item.getQty() + Integer.parseInt(qty);

		} else {
			quantity = item.getQty() - Integer.parseInt(qty);
			profit += Integer.parseInt(qty) * (item.getSellPrice() - item.getBuyPrice());
		}
		item.setBuyValue(item.getBuyPrice() * quantity);
		item.setQty(quantity);

		inventoryMap.put(item.getItemName(), item);
	}

	public static void deleteItem(String itemName) {
		inventoryMap.remove(itemName);
	}

	public static void report() {
		System.out.println("INVENTORY REPORT");
		System.out.println("Item Name \tBought At \tSold At\t   AvailableQty\t   Value");
		System.out.println("--------- \t--------- \t-------\t   ------------\t   -----");
		double totalValue = 0;
		for (Map.Entry<String, Item> entry : inventoryMap.entrySet()) {
			System.out.println(entry.getValue());
			totalValue += entry.getValue().getBuyValue();
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Total value               " + totalValue);
		profit = profit - previousProfit;
		previousProfit = profit;
		System.out.println("Profit since previous report " + profit);
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		while (true) {
			System.out.println("Ready for a new command sir.");

			String input = userInput.nextLine();
			String inputArray[] = input.trim().split("\\s+");
			String command = inputArray[0];
			switch (command) {
			case "create":
				Item item = setItem(inputArray[1], inputArray[2], inputArray[3]);
				insertItem(item);
				break;
			case "updateBuy":
				updateItem(inventoryMap.get(inputArray[1]), inputArray[2], "buy");
				break;
			case "updateSell":
				updateItem(inventoryMap.get(inputArray[1]), inputArray[2], "sell");
				break;
			case "delete":
				deleteItem(inputArray[1]);
				break;
			case "report":
				report();
				break;
			default:
				System.out.println("please enter correct command");
				break;

			}
			if (!input.isEmpty()) {
				// Handle input
			}
		}
	}

}
