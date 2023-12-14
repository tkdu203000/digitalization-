package model.SolutionOrder;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Inventory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;

public class SolutionOrder {
    ArrayList<SolutionsOfferOrderItem> solutionOfferOrderitems;
    SolutionOfferCatalog solutionOfferCatalog;
    CustomerProfile customer;
    private Market market;
    private Channel channel;
    private static int orderIdCounter = 1;
    private String customerId;
    private String status;
    private String bundleType;
    private String bundleComposition;


    public SolutionOrder(CustomerProfile cp) {
        solutionOfferOrderitems = new ArrayList<SolutionsOfferOrderItem>();
        customer = cp;
        //customer.addCustomerSolutionOrder(this); // we link the order to the customer
       
    }
    public SolutionOrder(String bundleType, String bundleComposition) {
        this.bundleType = bundleType;
        this.bundleComposition = bundleComposition;
        this.solutionOfferOrderitems = new ArrayList<SolutionsOfferOrderItem>();
    }

    public SolutionOrder(CustomerProfile customer, SolutionOfferCatalog solutionOfferCatalog) {
        this.solutionOfferOrderitems = new ArrayList<>();
        this.customer = customer;
        this.solutionOfferCatalog = solutionOfferCatalog;
    }

    public SolutionsOfferOrderItem createRandomSolutionsOfferOrderItem() {
        SolutionOffer randomSolutionOffer = getRandomSolutionOffer();
        int randomActualPrice = getRandom(100, 500);
        int randomQuantity = getRandom(1, 5);

        SolutionsOfferOrderItem solutionsOfferOrderItem = new SolutionsOfferOrderItem(randomSolutionOffer, randomActualPrice, randomQuantity);
        solutionOfferOrderitems.add(solutionsOfferOrderItem);
        return solutionsOfferOrderItem;
    }

    private SolutionOffer getRandomSolutionOffer() {
        return solutionOfferCatalog.getRandomSolutionOffer();
    }
    private int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }






    public SolutionOrder(CustomerProfile cp, Market m , Channel c) {
        solutionOfferOrderitems = new ArrayList<SolutionsOfferOrderItem>();
        customer = cp;
        customer.addCustomerSolutionOrder(this); // we link the order to the customer
        market = m;
        channel = c;
        this.customerId = generateCustomerId();
    }

    public SolutionsOfferOrderItem newSolutionOfferOrderItem(SolutionOffer so, int actualPrice, int q) {
        SolutionsOfferOrderItem sooi = new SolutionsOfferOrderItem(so, actualPrice, q);
        solutionOfferOrderitems.add(sooi);
        return sooi;
    }

    // Add a method to create a random SolutionsOfferOrderItem
    

    public SolutionOrder(CustomerProfile customer, MarketChannelAssignment marketChannelAssignment) {
        this.customer = customer;
        this.market = marketChannelAssignment.getSelectedmarket();
        this.channel = marketChannelAssignment.getSelectedchannel();
        this.customerId = generateCustomerId();
    }

    private String generateCustomerId() {
        return "C" + orderIdCounter++;
    }
    public ArrayList<SolutionsOfferOrderItem> getSolutionOfferOrderitems() {
        return solutionOfferOrderitems;
    }
    public CustomerProfile getCustomerProfile() {
        return customer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBundleType() {
        return bundleType;
    }
    public String getBundleComposition() {
        return bundleComposition;
    }

    public Market getMarket() {
        // Implement the logic to return the associated market
        return market;
    }

    public int getSolutionOrderTotal() {
        int sume = 0;
        for (SolutionsOfferOrderItem sooi : solutionOfferOrderitems) {
            sume = sume + sooi.getSolutionsOfferOrderItemTotal();
        }
        return sume;
    }
    public int getSolutionOrderPricePerformance() {
        int sume = 0;
        for (SolutionsOfferOrderItem sooi : solutionOfferOrderitems) {
            sume = sume + sooi.calculatePricePerformance();
        }
        return sume;
    }



    public void setMarketAndChannel(Market market, Channel channel) {
        // Set the market and channel for the solution order
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public SolutionsOfferOrderItem newSolutionOrderItem(SolutionOffer so, int actualprice, int q) {
        SolutionsOfferOrderItem sooi = new SolutionsOfferOrderItem(so, actualprice, q);
        solutionOfferOrderitems.add(sooi);
        return sooi;
    }


    public SolutionOrder() {
        solutionOfferOrderitems = new ArrayList<SolutionsOfferOrderItem>();
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    
   

    public void submit() {
        // Add any additional logic or validation before submitting the order
        this.status = "Submitted";
        System.out.println("Order submitted successfully!");
    }
    public SolutionOffer getSolutionOffer() {
        return solutionOfferCatalog.getRandomSolutionOffer();
    }
    




}
