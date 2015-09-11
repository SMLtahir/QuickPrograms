package objectOrientedPrograms;

import java.util.HashMap;
import java.util.Map;

/**
 * I have designed this entirely by myself without any reference.
 * Please refer to other material to verify the presence of all required info.
 * @author Tahir
 *
 */
public class VendingMachine {

	public static void main(String[] args) {

		VendingMachine machine = new VendingMachine(10, 5);
		Item cola = new Item(45, "Coca-Cola", 1.20);
		Item pepsi = new Item(46, "Pepsi", 1.15);
		Item fanta = new Item(47, "Fanta", 1.00);
		Item sprite = new Item(48, "Sprite", 1.80);
		boolean isSuccess = machine.addMultipleItems(cola, 5);
		isSuccess = machine.addMultipleItems(cola, 5);
		isSuccess = machine.addMultipleItems(pepsi, 0);
		isSuccess = machine.addMultipleItems(fanta, 3);
		isSuccess = machine.addMultipleItems(sprite, 1);
		isSuccess = machine.addItem(pepsi);
		Item removedItem = machine.removeItem(pepsi);
		Item boughtItem = machine.buyItem(cola, 5);		
	}
	
	int maxItems;
	int nrOfItems;
	int itemCapacity;
	Map<Integer, Integer> availableItems;
	
	public VendingMachine(int maxItems, int itemCap) {
		this.maxItems = maxItems;
		this.itemCapacity = itemCap;
		this.nrOfItems = 0;
		this.availableItems = new HashMap<Integer, Integer>();
	}
	
	public boolean addMultipleItems(Item item, int qty) {
		boolean isSuccess = false;
		while(qty > 0) {
			if(availableItems.containsKey(item.itemId)) {
				isSuccess = addItem(item);
			} else {
				if(nrOfItems < maxItems) {
					availableItems.put(item.itemId, 0);
					nrOfItems++;
					isSuccess = addItem(item); 
				}
			}
			qty--;
		}
		
		if(!isSuccess) { System.out.println("The machine has hit maximum capacity!");}
		return isSuccess;
	}
	
	public boolean addItem(Item item) {
		if(!availableItems.containsKey(item.itemId)) { availableItems.put(item.itemId, 0);}
		int qty = availableItems.get(item.itemId);
		if(qty < itemCapacity) {
			availableItems.put(item.itemId, qty + 1);
			System.out.println("1 "+ item.name+ " added to machine.");
			return true;
		}
		System.out.println("The machine has hit maximum capacity!");
		return false;
	}

	public Item removeItem(Item item) {
		if(!availableItems.containsKey(item.itemId)) { return null;}
		int qty = availableItems.get(item.itemId);
		if(qty > 1) {
			availableItems.put(item.itemId, qty - 1);
			System.out.println("1 "+ item.name+ " removed.");
			return item;
		} else if(qty == 1) {
			availableItems.remove(item.itemId);
			System.out.println("1 "+ item.name+ " removed.");
			nrOfItems--;
			return item;
		}
		return null;
	}
	
	public Item buyItem(Item item, double money) {
		if(!availableItems.containsKey(item.itemId)) { return null;}
		double price = item.price;
		if(money >= price) {
			returnChange(money - price);
			System.out.println("1 "+ item.name+ " bought.");
			return removeItem(item);
		}
		return null;
	}
	
	private double returnChange(double balance) {
		return balance;
	}
}

class Item {
	
	int itemId;
	String name;
	double price;
	
	public Item(int id, String name, double price) {
		this.itemId = id;
		this.name = name;
		this.price = price;
	}
	
}
