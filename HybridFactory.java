package abstractfactory;

import factory.InvestmentFactory;
import singleton.Logger;

public class HybridFactory extends PortfolioAbstractFactory {

	public HybridFactory() {};
		
		public static Portfolio createPortfolio(){
			
			Portfolio portfolio = new Portfolio(null, null, null, null);
			
			String comment = "An hybrid portfolio has a 40:60 blend of stocks to mutual funds.\n";
			
			System.out.println(comment);
				
			Logger.append(comment);

			portfolio.i1 = InvestmentFactory.addInvestment("DODFX");
			portfolio.i2 = InvestmentFactory.addInvestment("SBUX");
			portfolio.i3 = InvestmentFactory.addInvestment("IBM");
			portfolio.i4 = InvestmentFactory.addInvestment("TPINX");
			return portfolio;
	
		}
}