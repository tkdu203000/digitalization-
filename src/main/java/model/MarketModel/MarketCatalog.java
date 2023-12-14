/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Random;

import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {
    ArrayList<Market> markets;
  
    public MarketCatalog() {
        markets = new ArrayList<Market>();
    }

    // public Market newMarket(String s) {
    //     Market market = new Market(s);
    //     markets.add(market);
    //     return market;

    // }

    public Market newMarket(int ra, String rg, String rc, String rj, int ri   ) {
        Market market = new Market(ra, rg, rc, rj, ri);
        markets.add(market);
        return market;
    }

    public Market newMarket(String name, int age, String country, double income) {
        Market market = new Market(name, age, country, income);
        markets.add(market);
        return market;
    }
    public Market newMarket(int age, String country, double income) {
        Market market = new Market(age, country, income );
        markets.add(market);
        return market;
    }
    public Market newMarket(int age, String country, double income, String customerType) {
        Market market = new Market(age, country, income );
        markets.add(market);
        return market;
    }





    // public Market newMarket(String name, int age, String country, double income, String customerType) {
    //     Market market;
        
    //     if ("Young Trend Setter".equals(customerType)) {
    //         // Configure market for young trend setters
    //         // You can customize the configuration based on your specific requirements
    //         market = new Market(name, age, country, income);
    //         market.setMarketgroup("Young Trend Setter Configuration");
    //     } else {
    //         // Configure market for other customer types
    //         // You can customize the configuration based on your specific requirements
    //         market = new Market(name, age, country, income);
    //         market.setMarketgroup("Other Customer Type Configuration");
    //     }

    //     markets.add(market);
    //     return market;
    // }

    

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(ArrayList<Market> markets) {
        this.markets = markets;
    }

    public Market getRandomMarket() {
        Random random = new Random();
        int randomIndex = random.nextInt(markets.size());
        return markets.get(randomIndex);
    }
    
    // Add a method to check if the catalog contains a specific market
    public boolean containsMarket(Market market) {
        return markets.contains(market);
    }

    

    
    




    
    
}
