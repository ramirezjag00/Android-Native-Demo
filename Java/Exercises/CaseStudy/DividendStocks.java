public class DividendStocks extends Stocks {
  private double dividends;

  public DividendStocks(String symbol, double currentPrice) {
    super(symbol, currentPrice);
    dividends = 0.0;
  }

  @Override
  public double getMarketValue() {
    return super.getMarketValue() + dividends;
  }

  public void payDividend(double amountPerShare) {
    dividends += amountPerShare * getTotalShares();
  }
}