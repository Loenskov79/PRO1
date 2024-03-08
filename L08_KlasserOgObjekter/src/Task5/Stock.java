package Task5;

public class Stock {

    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    Stock(String inputSymbol, String inputName, double inputPreviousClosingPrice, double inputCurrentPrice) {
        symbol = inputSymbol;
        name = inputName;
        previousClosingPrice = inputPreviousClosingPrice;
        currentPrice = inputCurrentPrice;
    }

    public double getChangePercent() {
        double differenceBetweenNumbers = previousClosingPrice - currentPrice;
        double changedPercent = differenceBetweenNumbers / previousClosingPrice * 100;
        return changedPercent;
    }

    public void printStock() {
        System.out.println("The stock symbol is: " + symbol);
        System.out.println("The name of the stock is: " + name);
        System.out.println("The previous closing price was: " + previousClosingPrice);
        System.out.println("The current price of the stock is: " + currentPrice);
        System.out.println("The change in percentage from the previous price to the current ");
        System.out.println("price is: " + getChangePercent() + "%");
    }

}
