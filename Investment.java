package factory;

public abstract class Investment {
	
	//Instance variables:
	static String symbol = null;
	static double shares = 0;
	static double purchasePrice = 0;
	static double currentPrice = 0;
	
	public Investment(String symbol, double shares, double purchasePrice, double currentPrice){
		
		Investment.symbol = symbol;
		Investment.shares = shares;
		Investment.purchasePrice = purchasePrice;
		Investment.currentPrice = currentPrice;
	}

	public void setSymbol(String symbol){};
	public void setShares(double shares){};
	public void setPurchasePrice(double purchasePrice){};
	public void setCurrentPrice(double currentPrice){};
	
	
	public String getSymbol(){ return symbol;}
	public double getShares(){ return shares;}
	public double getPurchasePrice(){ return purchasePrice;}
	public double getCurrentPrice(){ return currentPrice;}

	public void printStats(String symbol, double shares, double purchasePrice, double currentPrice){}
}
