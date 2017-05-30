package factory;

public class InvestmentFactory {
	
	public static Investment addInvestment(String symbol){
		
		if (symbol.length() > 4) {
			
			return new MutualFund(symbol, 0, 0, 0);
		}
		else {
			
			return new Stock(symbol, 0, 0, 0);
		}
	}
}
