package ObserverPatternExample;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }

    public void setStock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
