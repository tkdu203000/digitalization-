/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.github.javafaker.Faker;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.SolutionOrder.MasterSolutionOrderList;
import model.SolutionOrder.SolutionOrder;
import model.SolutionOrder.SolutionsOfferOrderItem;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.Business.Inventory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  static int upperPriceLimit = 3000;
  static int lowerPriceLimit = 200;
  static int range = 1000;
  static int productMaxQuantity = 10;

  public static Business createABusinessAndLoadALotOfData(String name, int supplierCount, int productCount,
      int customerCount, int orderCount, int itemCount, int marketCount, int channelCount) {
    Business business = new Business("Amazon");
    // System.out.println(business.getName() );

    // Add Suppliers +
    loadSuppliers(business, supplierCount);

    // Add Products +
    loadProducts(business, productCount);

    // Add Customers
    loadCustomers(business, customerCount);

    // Add Order
    loadOrders(business, orderCount, itemCount);

    // Add Markets
    loadMarkets(business, marketCount);

    // Add Channels

    loadChannels(business, channelCount);

    // Create Market-Channel Combinations
    // createMarketChannelCombinations(business, marketCount * channelCount);

    // Add Solution Orders
    // loadSolutionOrders(business, orderCount, itemCount);

    // Add Solution Offers
    // loadSolutionOffers(business);

    return business;
  }

  public static void loadSuppliers(Business b, int supplierCount) {
    Faker faker = new Faker();

    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    for (int index = 1; index <= supplierCount; index++) {
      supplierDirectory.newSupplier(faker.company().name());
    }
  }

  static void loadProducts(Business b, int productCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();

    for (Supplier supplier : supplierDirectory.getSupplierList()) {

      int randomProductNumber = getRandom(1, productCount);
      ProductCatalog productCatalog = supplier.getProductCatalog();
      // Information store place class
      Inventory inventory = new Inventory();

      for (int index = 1; index <= randomProductNumber; index++) {

        int randomindex = getRandom(0, inventory.productNames.size());

        // String productName = inventory.productNames.get(randomindex) + " from " +
        // supplier.getName();

        // randomly generate a product name inventory class.
        String productName = inventory.productNames.get(randomindex);
        int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
        int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
        int randomTarget = getRandom(randomFloor, randomCeiling);

        productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);

      }
    }
  }

  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt(upper - lower);
    return randomInt;
  }

  static void loadCustomers(Business b, int customerCount) {
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();

    Faker faker = new Faker();

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      customerDirectory.newCustomerProfile(newPerson);
    }
  }

  static void loadOrders(Business b, int orderCount, int itemCount) {

    // reach out to masterOrderList
    MasterOrderList mol = b.getMasterOrderList();

    // pick a random customer (reach to customer directory)
    CustomerDirectory cd = b.getCustomerDirectory();
    SupplierDirectory sd = b.getSupplierDirectory();

    for (int index = 0; index < orderCount; index++) {

      CustomerProfile randomCustomer = cd.pickRandomCustomer();
      if (randomCustomer == null) {
        System.out.println("Cannot generate orders. No customers in the customer directory.");
        return;
      }

      // create an order for that customer
      Order randomOrder = mol.newOrder(randomCustomer);

      // add order items
      // -- pick a supplier first (randomly)
      // -- pick a product (randomly)
      // -- actual price, quantity

      int randomItemCount = getRandom(1, itemCount);
      for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

        Supplier randomSupplier = sd.pickRandomSupplier();
        if (randomSupplier == null) {
          System.out.println("Cannot generate orders. No supplier in the supplier directory.");
          return;
        }
        ProductCatalog pc = randomSupplier.getProductCatalog();
        Product randomProduct = pc.pickRandomProduct();
        if (randomProduct == null) {
          System.out.println("Cannot generate orders. No products in the product catalog.");
          return;
        }

        int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
        int randomQuantity = getRandom(1, productMaxQuantity);

        randomOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
      }
    }
    // Make sure order items are connected to the order

  }

  // start market and channel
  static void loadMarkets(Business b, int marketCount) {

    MarketCatalog marketCatalog = b.getMarketCatalog();
    Inventory inventory = new Inventory();
    // This set is likely intended to store unique combinations of market-related
    // strings.
    Set<String> generateMarektCombinations = new HashSet<>();

    for (int index = 1; index <= marketCount; index++) {
      

      int randomindex = getRandom(0, inventory.getCountryNames().size());
      int randomindex2 = getRandom(0, inventory.getMarketAge().size());
      double marketIncome = getRandom(0, inventory.getMarketIncome().size());
      int radomindex3 = getRandom(0, inventory.getChannelTypes().size());

      String marketCountry = inventory.getCountryNames().get(randomindex);
      int marketAge = inventory.getMarketAge().get(randomindex2);
      String channel = inventory.getChannelTypes().get(radomindex3);
      String marketCombinationKey = marketAge + channel + marketIncome;

      if (!generateMarektCombinations.contains(marketCombinationKey)) {
        // Set customer type based on age and channel type
        Market market = new Market(marketAge, channel, marketIncome);
        if (marketAge < 25 && marketIncome < 50000) {
          marketCatalog.newMarket(marketAge, channel, marketIncome, "Student Type");
        } else if (marketAge >= 25 && marketIncome > 50000 && marketIncome < 100000 && channel == "Direct") {
          marketCatalog.newMarket(marketAge, channel, marketIncome, "General Direct Type");
        } else if (marketAge >= 25 && marketIncome > 50000 && marketIncome < 100000 && channel == "indirect") {
          marketCatalog.newMarket(marketAge, channel, marketIncome, "General indirect Type");
        } else if (marketIncome >= 100000) {
          marketCatalog.newMarket(marketAge, channel, marketIncome, "Loyalty Type");
        } else {
          marketCatalog.newMarket(marketAge, channel, marketIncome, "General Type");
        }
        marketCatalog.newMarket(marketAge, channel, marketIncome);

        // Add the combination to the set to track uniqueness
        generateMarektCombinations.add(marketCombinationKey);
      }

    }
  }

  static void loadChannels(Business b, int channelCount) {
    ChannelCatalog channelCatalog = b.getChannelCatalog();

    for (int index = 1; index <= channelCount; index++) {
      String channeltypes;
      if (index % 2 == 0) {
        channeltypes = "Direct";
      } else {
        channeltypes = "Indirect";
      }

      // String additionalAttribute = "Additional Attribute #" + index;

      Channel channel = new Channel(channeltypes);
      channelCatalog.newChannel(channeltypes);
    }
  }

  static void loadSolutionOrders(Business b, int orderCount, int itemCount) {
    MasterSolutionOrderList masterSolutionOrderList = b.getMasterSolutionOrderList();
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();

    
    for (int index = 0; index < orderCount; index++) {
      CustomerProfile randomCustomer = customerDirectory.pickRandomCustomer();
      SolutionOrder randomOrder = new SolutionOrder(randomCustomer);

      // Generate solution order items based on the assigned market and channel
      for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
        Supplier randomSupplier = supplierDirectory.pickRandomSupplier();
        if (randomSupplier == null) {
          System.out.println("Cannot generate orders. No supplier in the supplier directory.");
          return;
        }

        ProductCatalog pc = randomSupplier.getProductCatalog();
        Product randomProduct = pc.pickRandomProduct();
        if (randomProduct == null) {
          System.out.println("Cannot generate orders. No products in the product catalog.");
          return;
        }

        int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
        int randomQuantity = getRandom(1, 5);

        SolutionOffer randomSolutionOffer = new SolutionOffer(randomProduct, randomPrice, randomQuantity);
        randomOrder.newSolutionOrderItem(randomSolutionOffer, randomPrice, randomQuantity);

        // Inventory inventory = b.getInventory(); // Use the existing inventory associated with the business
        // // List<Integer> marketAges = inventory.getMarketAge();
        // List<String> bundleTypes = inventory.getBundleTypes();
        // List<String> bundleComp = inventory.getBundleComposition();
        // if (!bundleTypes.isEmpty() && !bundleComp.isEmpty()) {
        //   // int randomindex = getRandom(0, marketAges.size() - 1);
        //   // int marketAge = marketAges.get(randomindex);
        //   int randomindex2 = getRandom(0, inventory.getBundleTypes().size() );
        //   int randomindex3 = getRandom(0, inventory.getBundleComposition().size() );

        //   String Bundle = inventory.getBundleTypes().get(randomindex2);
        //   String Comp = inventory.getBundleComposition().get(randomindex3);

        //   // String marketCombinationKey = marketAge + channel + marketIncome;
        // }

      }

      // Add the order to the master list or perform any other necessary actions
      masterSolutionOrderList.newSolutionOrder(randomOrder);
    }

  }

  static void loadSolutionOffers(Business b) {
    MarketChannelAssignment[] combinations = b.getMarketChannelAssignments();

    Inventory inventory = new Inventory();
    //int random = getRandom(0, inventory.getMarketIncome().size());

    for (MarketChannelAssignment combination : combinations) {
      int age = combination.getMarket().getAge();
      double income = combination.getMarket().getIncome();
      String channel = combination.getChannel().getChanneltypes();
      String consumertypes = combination.getconsumertypes(age, income, channel);

      // Example: Creating a generic solution offer
      SolutionOffer solutionOffer = new SolutionOffer(combination);

      // Add logic to customize solution offers based on market, channel, and customer
      // type

      // Example: Creating a solution offer for a student

      if ("Student Type".equals(consumertypes)) {
        System.out
            .println("Student Type" + age + "income" + income + "channel" + channel + "consumertypes" + consumertypes);
        solutionOffer.suggestStudentTypeBundledSolutions();
      } else if ("General Direct Type".equals(consumertypes)) {
        System.out.println(
            "General Direct" + age + " income" + income + " channel " + channel + " consumertypes " + consumertypes);
        solutionOffer.suggestGeneralDirectTypeBundledSolutions();
      } else if ("General Indirect Type".equals(consumertypes)) {
        System.out.println(
            "General Indirect " + age + " income" + income + " channel " + channel + " consumertypes " + consumertypes);
        solutionOffer.suggestGeneralInDirectTypeBundledSolutions();
      } else if ("Loyalty Type".equals(consumertypes)) {
        System.out
            .println("Loyalty " + age + " income" + income + " channel " + channel + " consumertypes " + consumertypes);
        solutionOffer.suggestLoyaltyTypeBundledSolutions();
      } else {
        System.out
            .println("age " + age + " income" + income + " channel " + channel + " consumertypes " + consumertypes);
        solutionOffer.suggestGeneralDirectTypeBundledSolutions();
      }

      b.addSolutionOffer(solutionOffer);
    }

  }
  // static void createMarketChannelCombinations(Business b, int combinationCount)
  // {
  // ChannelCatalog channelCatalog = b.getChannelCatalog();
  // MarketCatalog marketCatalog = b.getMarketCatalog();

  // for (int i = 1; i <= combinationCount; i++) {
  // Channel randomChannel = channelCatalog.getRandomChannel();
  // Market randomMarket = marketCatalog.getRandomMarket();

  // MarketChannelAssignment combination = new
  // MarketChannelAssignment(randomMarket, randomChannel);
  // b.addMarketChannelAssignment(combination);
  // }
  // }

  // static void loadSolutionOrders2(Business business, int orderCount, int
  // itemCount) {
  // MasterSolutionOrderList masterSolutionOrderList =
  // business.getMasterSolutionOrderList();
  // CustomerDirectory customerDirectory = business.getCustomerDirectory();
  // //SupplierDirectory supplierDirectory = business.getSupplierDirectory();
  // SolutionOfferCatalog solutionOfferCatalog =
  // business.getSolutionOfferCatalog();

  // for (int orderIndex = 0; orderIndex < orderCount; orderIndex++) {
  // CustomerProfile randomCustomer = customerDirectory.pickRandomCustomer();

  // if (randomCustomer == null) {
  // System.out.println("Unable to generate orders. No customers found in the
  // directory.");
  // return;
  // }

  // SolutionOrder randomOrder =
  // masterSolutionOrderList.newSolutionOrder(randomCustomer);
  // int randomItemCount = getRandom(1, itemCount);

  // for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {
  // SolutionOffer randomSolutionOffer =
  // solutionOfferCatalog.getRandomSolutionOffer();

  // if (randomSolutionOffer == null) {
  // System.out.println("Unable to generate orders. No solution offers found in
  // the catalog.");
  // // You can log a warning or take alternative actions here
  // continue; // Skip the current iteration and proceed to the next one
  // }

  // int randomQuantity = getRandom(1, productMaxQuantity); // Assuming
  // productMaxQuantity is defined
  // int randomPrice = getRandom(randomSolutionOffer.getFloorPrice(),
  // randomSolutionOffer.getCeilingPrice());

  // randomOrder.newSolutionOrderItem(randomSolutionOffer, randomPrice,
  // randomQuantity);
  // }
  // }
  // }

}