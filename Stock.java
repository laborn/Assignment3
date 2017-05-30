package factory;

import singleton.Logger;

public class Stock extends Investment {
	
	public Stock(String symbol, double shares, double purchasePrice, double currentPrice) {
		super(symbol, shares, purchasePrice, currentPrice);
		
		String content = "Added stock " + symbol + "\n";
		
		System.out.println(content);
		Logger.append(content);
	}

	public void printStats(){
		System.out.println("This is the stocks printout");
	}
}
