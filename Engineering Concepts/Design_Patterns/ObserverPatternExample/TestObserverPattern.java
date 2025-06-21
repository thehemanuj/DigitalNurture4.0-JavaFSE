package ObserverPatternExample;

public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile1 = new MobileApp("MobileApp1");
        Observer web1 = new WebApp("WebApp1");

        market.register(mobile1);
        market.register(web1);

        market.setStock("TCS", 3500.75);
        market.setStock("INFY", 1470.50);

        market.deregister(mobile1);
        market.setStock("WIPRO", 610.25);
    }
}
