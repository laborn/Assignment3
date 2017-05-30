package abstractfactory;

import factory.InvestmentFactory;
import singleton.Logger;

public class AggressiveFactory extends PortfolioAbstractFactory {

	public AggressiveFactory() {};
		
		public static Portfolio createPortfolio(){
			
			Portfolio portfolio = new Portfolio(null, null, null, null);
			
			String comment = "An aggressive portfolio has a 90:10 blend of stocks to mutual funds.\n";
			
			System.out.println(comment);
				
			Logger.append(comment);

			portfolio.i1 = InvestmentFactory.addInvestment("MSFT");
			portfolio.i2 = InvestmentFactory.addInvestment("SBUX");
			portfolio.i3 = InvestmentFactory.addInvestment("IBM");
			portfolio.i4 = InvestmentFactory.addInvestment("TPINX");
			return portfolio;
	
		}
}
