package DynamicProgramming;

/**
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author Tahir
 *
 */
public class StockTransactions {
	public int maxProfit(int[] prices) {
        
        //Trivial cases
        if(prices.length <= 1) { return 0;}
        
        int maxProfit = 0;
        int minStock = prices[0];
        for(int currentPrice : prices) {
            if(currentPrice < minStock) { minStock = currentPrice;}
            if(currentPrice - minStock > maxProfit) { maxProfit = currentPrice - minStock;}
        }
        return maxProfit;
    }
}
