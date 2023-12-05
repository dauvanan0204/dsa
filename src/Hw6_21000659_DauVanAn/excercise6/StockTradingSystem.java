package Hw6_21000659_DauVanAn.excercise6;

import Hw6_21000659_DauVanAn.excercise2.MaxHeapPriorityQueue;
import Hw6_21000659_DauVanAn.excercise2.MinHeapPriorityQueue;

public class StockTradingSystem {
    private MinHeapPriorityQueue<Double, Order> buyQueue;
    private MaxHeapPriorityQueue<Double, Order> sellQueue;

    public StockTradingSystem() {
        buyQueue = new MinHeapPriorityQueue<>();
        sellQueue = new MaxHeapPriorityQueue<>();
    }

    public void placeBuyOrder(int quantity, double price) {
        buyQueue.insert(price, new Order(quantity, price));
        processOrders();
    }

    public void placeSellOrder(int quantity, double price) {
        sellQueue.insert(price, new Order(quantity, price));
        processOrders();
    }

    private void processOrders() {
        while (!buyQueue.isEmpty() && !sellQueue.isEmpty()) {
            Order buyOrder = (Order) buyQueue.min().getValue();
            Order sellOrder = (Order) sellQueue.min().getValue();

            // Check if the orders can be matched
            if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                // Process the trade
                int tradeShares = Math.min(buyOrder.quantity, sellOrder.quantity);
                System.out.println("Trade: Buy " + tradeShares + " shares at $" + sellOrder.getPrice() + " each.");

                // Update remaining shares in the orders
                buyOrder.quantity -= tradeShares;
                sellOrder.quantity -= tradeShares;

                // Remove orders with zero remaining shares
                if (buyOrder.quantity == 0) {
                    buyQueue.removeMin();
                }
                if (sellOrder.quantity == 0) {
                    sellQueue.removeMin();
                }
            } else {
                // No more matches, stop processing
                break;
            }
        }
    }

    public static void main(String[] args) {
        StockTradingSystem tradingSystem = new StockTradingSystem();

        // Example: Place buy and sell orders
        tradingSystem.placeBuyOrder(100, 50.0);
        tradingSystem.placeSellOrder(100, 50.0);
        tradingSystem.placeSellOrder(75, 60.0);
        tradingSystem.placeBuyOrder(30, 55.0);
    }
}
