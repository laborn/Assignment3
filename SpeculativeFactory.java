package abstractfactory;

import factory.InvestmentFactory;
import singleton.Logger;

public class SpeculativeFactory extends PortfolioAbstractFactory {

	public SpeculativeFactory() {};
		
		public static Portfolio createPortfolio(){
			
			Portfolio portfolio = new Portfolio(null, null, null, null);
			
			String comment = "A speculative portfolio has a 100:0 blend of stocks to mutual funds.\n";
			
			System.out.println(comment);
				
			Logger.append(comment);

			portfolio.i1 = InvestmentFactory.addInvestment("AAPL");
			portfolio.i2 = InvestmentFactory.addInvestment("SBUX");
			portfolio.i3 = InvestmentFactory.addInvestment("IBM");
			portfolio.i4 = InvestmentFactory.addInvestment("GOOG");
			return portfolio;
	
		}
}