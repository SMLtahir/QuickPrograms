package objectOrientedPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockMarketPortfolio {

	Map<String, Integer> stocks;
	Map<String, String> records;
	
	public StockMarketPortfolio() {
		stocks = new HashMap<String, Integer>();
		records = new HashMap<String, String>();
	}
	
	public boolean buyStock(String id, int number) {
		String oldRecs = "";
		if(stocks.containsKey(id)) { 
			int quantity = stocks.get(id);
			stocks.put(id, quantity+number);
			oldRecs = records.get(id);
		} else {
			stocks.put(id, number);
		}
		String newRec = "Bought "+ id+ ": "+ number;
		records.put(id, oldRecs+"\n"+ newRec);
		return true;
		// The above part can be put in a try-catch block where the central stock system is 
		// queried for available stocks. If the central system does not have that quantity
		// of stocks, it will return an exception and this method will return a false.
	}
	
	public boolean sellStock(String id, int number) {
		if(!stocks.containsKey(id) || stocks.get(id) < number) { return false;}
		int quantity = stocks.get(id);
		if(quantity == number) { stocks.remove(id);}
		else { stocks.put(id, quantity-number);}
		String oldRecs = records.get(id);
		String newRec = oldRecs+"\n"+"Sold "+ id+ ": "+ number;
		records.put(id, newRec);
		return true;
	}
	
	public boolean sellAll(String id) {
		if(!stocks.containsKey(id)) { return false;}
		int quantity = stocks.get(id);
		stocks.remove(id);
		String oldRecs = records.get(id);
		String newRec = oldRecs+"\n"+"Sold "+ id+ ": "+ quantity;
		records.put(id, newRec);
		return true;
	}
	
	public boolean sellAllStocks() {
		for(String id : stocks.keySet()) {
			sellAll(id);
		}
		return true;
	}
	
	public String getRecord(String id) {
		return records.get(id);
	}
	
	public List<String> getAllRecords() {
		List<String> allRecs = new ArrayList<String>();
		for(String stockId : records.keySet()) {
			allRecs.add(records.get(stockId));
		}
		return allRecs;
	}
	
	public void clearRecords(String id) {
		if(records.containsKey(id)) { 
			records.put(id, "All previous records cleared");
		}
	}
	
	public void clearAllRecords() {
		for(String id : records.keySet()) {
			clearRecords(id);
		}
	}
}

class Stock {
	
	public String name;
	public double price;
	public String uniqueId;
	
	// Other properties
	public String industry;
	public double gain;
	
	public Stock(String name, double price, String id, String industry) {
		this.name = name;
		this.price = price;
		this.uniqueId = id;
		this.industry = industry;
		this.gain = 0;
	}
	
	public Stock(String id) {
		this.uniqueId = id;
		// Using the id, get all other parameters from querying the central system
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getGain() {
		double gain = 0.0;
		// Get gain from stock stats
		return gain;
	}
	
	// Instead of String, this could be a Stats object that contains specific values like
	// day-high and low, 52-week high and low, day gain/loss, etc.
	public String getStats() {
		// Retrieve from database
		return "";
	}
	
	// Instead of String, this could be a News object that contains different news articles
	// about the stock. This should actually be part of the StockMarket class
	public String getNews() {
		// Retrieve from database
		return "";
	}
	
	public String toString() {
		return name.toUpperCase()+ ": "+ price+ " | "+ industry;
	}
}
