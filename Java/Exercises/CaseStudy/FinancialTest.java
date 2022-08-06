public class FinancialTest {
  public static void main(String[] args) {

    Asset asset = new MutualFunds("AMZ", 300);
    // asset.purchase(2.0, 30.6);
    // System.out.println(asset.getSymbol());
    // System.out.println(asset.getTotalCost());
    // System.out.println(asset.getTotalShares());
    System.out.println(asset.getMarketValue());
  }
}
