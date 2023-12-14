package model.SolutionOrder;

import java.util.ArrayList;
import java.util.List;

import model.CustomerManagement.CustomerProfile;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.SolutionOffer;
import java.util.Random;
import model.ProductManagement.SolutionOfferCatalog;


public class MasterSolutionOrderList {
    ArrayList<SolutionOrder> solutionorders;

    public MasterSolutionOrderList() {
        solutionorders = new ArrayList<SolutionOrder>();
    }


    public ArrayList<SolutionOrder> getSolutionorders() {
        return solutionorders;
    }

    public SolutionOrder createSolutionOrder(CustomerProfile customer, SolutionOfferCatalog solutionOfferCatalog) {
        SolutionOrder solutionOrder = new SolutionOrder(customer, solutionOfferCatalog);
        solutionorders.add(solutionOrder);
        return solutionOrder;
    }

    

    // public List<SolutionOrder> getSolutionOrders() {
    //     return solutionorders;
    // }

    public SolutionOrder newSolutionOrder(CustomerProfile cp) {
        SolutionOrder so = new SolutionOrder(cp);
        solutionorders.add(so);
        return so;

    }
    public SolutionOrder newSolutionOrder(SolutionOrder so) {
        solutionorders.add(so);
        return so;

    }
    public SolutionOrder createRandomOrderWithBundle(String bundleType, String bundleComposition) {
        // Assuming SolutionOrder has a constructor that takes bundleType and bundleComposition
        SolutionOrder solutionOrder = new SolutionOrder(bundleType, bundleComposition);

        // Add the created solutionOrder to the list
        solutionorders.add(solutionOrder);

        return solutionOrder;
    }



    public SolutionOrder newOrder(CustomerProfile customer, MarketChannelAssignment marketChannelAssignment) {
        SolutionOrder order = new SolutionOrder(customer, marketChannelAssignment);
        solutionorders.add(order);
        return order;
    }
    public void submitOrder(SolutionOrder order) {
        // Perform any additional logic or validation before submitting the order
        order.submit(); // You may need to add a submit method to your SolutionOrder class
    }
    public ArrayList<SolutionOrder> getSolutionOrders() {
        return solutionorders;
    }

    public Iterable<SolutionOrder> getSalesSolutionOfferOrderItemsByMarketAge(MarketCatalog marketCatalog, int age) {
        List<SolutionOrder> orderitems = new ArrayList<>();

        // Iterate over all solution orders and filter based on market age
        for (SolutionOrder solutionOrder : solutionorders) {
            Market market = solutionOrder.getMarket();

            // Check if the market exists in the market catalog and has the specified age
            if (market != null && marketCatalog.containsMarket(market) && market.getAge() == age) {
                // Iterate over sales solution offer order items associated with the solution order
                for (SolutionsOfferOrderItem sooi : solutionOrder.getSolutionOfferOrderitems()) {
                    orderitems.add(solutionOrder);
                }
            }
        }

        return orderitems;
    }

    // New method to get sales solution offer order items by market country
    // public Iterable<SolutionOffer> getSalesSolutionOfferOrderItemsByMarketCountry(MarketCatalog marketCatalog, String country) {
    //     // Similar logic to the method above, but filter by market country
    //     // ...

    //     return orderitems;
    // }

    // // New method to get sales solution offer order items by channel type
    // public Iterable<SalesSolutionOfferOrderItem> getSalesSolutionOfferOrderItemsByChannelType(ChannelCatalog channelCatalog, String channelType) {
    //     // Similar logic to the method above, but filter by channel type
    //     // ...

    //     return salesItems;
    // }







}
