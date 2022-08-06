public class Stocks extends ShareAsset {
  private int totalShares;

  public Stocks(String symbol, double currentPrice) {
    super(symbol, currentPrice);
    totalShares = 0;
  }

  @Override
  public double getMarketValue() {
    return totalShares * getCurrentPrice();
  }

  public int getTotalShares() {
    return totalShares;
  }

  public void purchase(int shares, double pricePerShare) {
    totalShares += shares;
    addCost(shares * pricePerShare);
  }
}
