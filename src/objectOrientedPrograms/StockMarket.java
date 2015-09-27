package objectOrientedPrograms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class StockMarket {
	Set<Stock> stocks;
	PriorityQueue<Stock> topGainers;
	PriorityQueue<Stock> topLosers;
	
	public StockMarket() {
		stocks = new HashSet<Stock>();
		topGainers = new PriorityQueue<Stock>(0, new GainComparator());
		topLosers = new PriorityQueue<Stock>(0, new LossComparator());
	}
	
	public boolean addStock(Stock s) {
		try {
			boolean added = stocks.add(s);
			if(added) {
				topGainers.add(s);
				topLosers.add(s);
			}
			return added;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean removeStock(Stock s) {
		try {
			boolean removed = stocks.remove(s);
			if(removed) {
				topGainers.remove(s);
				topLosers.remove(s);
			}
			return removed;
		} catch(Exception e) {
			return false;
		}
	}
	
	public Stock[] getTopGainers(int topN) {
		Stock[] bestStocks = new Stock[topN]; 
		Iterator<Stock> iter = topGainers.iterator();
		int index = 0;
		while(index < topN && iter.hasNext()) {
			bestStocks[index++] = iter.next();
		}
		return bestStocks;
	}
	
	public Stock[] getTopLosers(int topN) {
		Stock[] worstStocks = new Stock[topN]; 
		Iterator<Stock> iter = topLosers.iterator();
		int index = 0;
		while(index < topN && iter.hasNext()) {
			worstStocks[index++] = iter.next();
		}
		return worstStocks;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Stock s : stocks) {
			sb.append(s.name+ ":\t"+ s.price+ "\n");
		}
		return sb.toString();
	}
}

class GainComparator implements Comparator<Stock> {
	public int compare(Stock s1, Stock s2) {
		// Can't do direct comparisons because of the double type precision problems
		double diff = s2.getGain() - s1.getGain();
		if(diff > 0.0001) { return 1;}
		else if(Math.abs(diff) < 0.0001) { return 0;}
		else { return -1;}
	}
}

class LossComparator implements Comparator<Stock> {
	public int compare(Stock s1, Stock s2) {
		// Can't do direct comparisons because of the double type precision problems
		double diff = s1.getGain() - s2.getGain();
		if(diff > 0.0001) { return 1;}
		else if(Math.abs(diff) < 0.0001) { return 0;}
		else { return -1;}
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
