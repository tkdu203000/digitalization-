/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.List;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.SolutionOrder.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    ArrayList<Order> orders;
    ArrayList<Market> markets;
    ArrayList<SolutionOrder> solutionOrders;
    private MarketChannelAssignment marketChannelAssignment;
    ArrayList<Channel> channels;
    Person person;

    public CustomerProfile(Person p) {
        person = p;
        orders = new ArrayList<Order>();
    }

    public CustomerProfile(Person p, int age, String country, String job, double income ) {
         person = p;
         age = age;
         country = country;
         job = job;
         income = income;
         orders = new ArrayList<Order>();
    }

    public CustomerProfile(String name, int age, String country, String job, double income ) {
         name = name;
         age = age;
         country = country;
         job = job;
         income = income;
         orders = new ArrayList<Order>();
    }
    public CustomerProfile (Market m , Channel c ) {
        //markets = new ArrayList<Market>();
        markets.add(m);
        channels.add(c);
    }

    

    public int getTotalPricePerformance() {
        // for each order in the customer orderlist
        // calculate order price performance and add it to the sum

        return 0;
    }

    public int getNumberOfOrdersAboveTotalTarget() {
        // for each order in the customer order list
        // calculate if order is positive (actual order total is greater than sum of
        // item targets
        // if yes then add 1 to total
        int sum = 0;
        for (Order o : orders) {
            if (o.isOrderAboveTotalTarget() == true)
                sum = sum + 1;
        }

        return sum;
    }

    public int getNumberOfOrdersBelowTotalTarget() {
        return 0;
    }
    // for each order in the customer order list
    // calculate if order is negative
    // if yes then add 1 to total

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public void addCustomerOrder(Order o) {
        orders.add(o);
    }
    public void addCustomerSolutionOrder(SolutionOrder so){
        solutionOrders.add(so);
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }

    public String getCustomerId() {
        return person.getPersonId();
    }

    
    
   
    public Person getPerson() {
        return person;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }
    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setMarkets(List<Market> markets2) {
    }

    public void setCustomerId(String customerId) {
        this.person.getPersonId();
    }

    public void setMarketChannelAssignment(MarketChannelAssignment randomAssignment) {
        marketChannelAssignment = randomAssignment;
    }
    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelAssignment;
    }
   

    

    

   
}
