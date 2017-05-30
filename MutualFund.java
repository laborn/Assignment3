package factory;

import singleton.Logger;

public class MutualFund extends Investment {
	
	public MutualFund(String symbol, double shares, double purchasePrice, double currentPrice) {
		super(symbol, shares, purchasePrice, currentPrice);
		
		String content = "Added mutual fund " + symbol + "\n";
		System.out.println(content);
		Logger.append(content);
	}

	public void printStats(){
		System.out.println("This is the mutual funds printout");
	}
}