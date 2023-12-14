/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.github.javafaker.Faker;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.Business.ConfigureBBusiness;
import model.Business.Inventory;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.OrderManagement.Order;
import model.OrderManagement.OrderItem;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOffer;
import model.SolutionOrder.MasterSolutionOrderList;
import model.SolutionOrder.SolutionOrder;
import model.SolutionOrder.SolutionsOfferOrderItem;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  static String[] bundledSolutions = {
      "Bundled Solution 1: Apple Mac 13 + AppleCare X",
      "Bundled Solution 3: Apple ipad C + Apple One Z",
      "Bundled Solution 4: Apple Airpods D + Apple TV",
      "Bundled Solution 5: Apple Watch E + Apple Music",
      "Bundled Solution 7: Apple Mac 15 + Apple News",
      "Bundled Solution 6: Apple iphone F + Apple Arcade",
      "Bundled Solution 2: Apple iphone XS B + iCloud Y",
      "Bundled Solution 8: Apple iphone SE3 + Apple Fitness",
      "Bundled Solution 9: Apple iphone SE2 + Apple Card",
      "Bundled Solution 10: Apple iphone 15 + Apple Books",
      "Bundled Solution 11: Apple iphone 13 + Apple Podcasts"

  };

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    // 1. Populate the model +

    // Business business =
    // ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 50, 10, 30, 100,
    // 10);
    //Business business2 = ConfigureBBusiness.createABusiness("Apple", 10, 10, 10, 10, 10, 10);

    // 2. Maybe some interaction with the user (optional)

    Scanner scanner = new Scanner(System.in);

    boolean exitCode = false;
    String channels = "";
    String country = "";
    // String gender = "";
    double annualSalary = 0.0;
    int age = 0;

    List<String> productPreferences = new ArrayList<>();

    while (!exitCode) {
      System.out.println("0. Enter user information:");
      System.out.println("1. Search for products/services");
      System.out.println("2. Display bundled solutions");
      System.out.println("3. Auto-generate sales orders");
      System.out.println("4. Sales Revenue Report");
      System.out.println("5. Exit");

      System.out.print("Please enter your choice: ");
      int choice = scanner.nextInt();

      // String input = sc.next();

      // System.out.println(input);
      switch (choice) {
        case 0:
          System.out.print("Enter your country:");
          country = scanner.next();
          System.out.print("What channel do you use between indirect or direct: ");
          channels = scanner.next();
          System.out.print("Enter your age: ");
          age = scanner.nextInt();
          System.out.print("Enter your annual salary: ");
          annualSalary = scanner.nextDouble();
          System.out.println("Your information [" + country + ", " + channels + ", " + age + ", " + annualSalary
              + "]has been saved, please search for prodcuts/services.");
          break;
        case 1:
          System.out.println("Enter the products you want to buy (comma-separated): ");
          scanner.nextLine();
          String productsInput = scanner.nextLine();
          productPreferences = Arrays.asList(productsInput.split(","));
          System.out.println("Your product preferences: " + productPreferences);
          System.out.println("if you want to see the recommendation bundles packages, please input 2 : ");

          break;
        case 2:
          displayBundledSolutions(country, channels, age, annualSalary, productPreferences);
          break;
        case 3:
          Business business3 = ConfigureABusiness.createABusinessAndLoadALotOfData("Apple", 20, 10, 30, 30, 30, 10,
              10);
          

          System.out.println();

          // total sales per consumer(complete)
          // Autogenerate sales orders with different pricing options as well as product,
          // people, markets, and channel perspectives. Populate your application with
          // data.
          printSalesOrders(business3);
          System.out.println();

          // total sales per product with different supplier
          // hold for a while
          //printSalesOrders2(business3);

          System.out.println();

          break;
        case 4:
          Business business4 = ConfigureABusiness.createABusinessAndLoadALotOfData("Apple", 20, 10, 30, 30, 30, 10,
              10);
          // Revenue report by market and channel
          generateRevenueReports1(business4);
          System.out.println();
          // Revenue report by bundle item
          generateRevenueReports2(business4);


          System.out.println();
          generateAdSalesReports(business4);
         

          break;
        case 5:
          exitCode = true;
          System.out.println("Exiting the application. Goodbye!");
        default:
          // System.out.println("Invalid choice");
          break;
      }

    }

    // System.out.println("Thank you, have a nice day.");

    scanner.close();

  }

  private static void displayBundledSolutions(String country, String channels, int age, double annualSalary,
      List<String> productPreferences) {
    // Customize bundled solutions based on user information and product preferences
    System.out.println("Displaying bundled solutions based on user information and product preferences:");
    Business business = ConfigureBBusiness.createABusiness("Apple", 10, 10, 10, 10, 10, 10);
    MarketCatalog marketCatalog = business.getMarketCatalog();
    ChannelCatalog channelCatalog = business.getChannelCatalog();
    
    ArrayList<SolutionOffer> solutionoffers = new ArrayList<>();

    for (String product : productPreferences) {
      System.out.println("User wants to buy: " + product);
    }
    for (int i = 0; i < 1; i++) {
      Market currentMarket = marketCatalog.getMarkets().get(i);
      Channel currentChannel = channelCatalog.getChannels().get(i);
      MarketChannelAssignment marketChannelAssignment = new MarketChannelAssignment(currentMarket, currentChannel);
      SolutionOffer solutionOffer = new SolutionOffer(marketChannelAssignment);
      solutionoffers.add(solutionOffer);
      // marketChannelAssignment.consumertypes();
      // String assignmentResult = marketChannelAssignment.assign1();
      // System.out.println(assignmentResult);

    }
    for (SolutionOffer solutionOffer : solutionoffers) {
      if (country.contains("us") && productPreferences.contains("iphone") && age < 25 && annualSalary < 50000) {
        solutionOffer.suggestStudentTypeBundledSolutions();
      } else if (country.contains("eu") && productPreferences.contains("iphone") && age < 25 && annualSalary < 50000) {
        solutionOffer.suggestStudentTypeBundledSolutions2();
      } else if (country.contains("us") && productPreferences.contains("iphone") && age >= 25 && annualSalary > 50000
          && annualSalary < 100000) {
        if (channels.contains("indirect")) {
          solutionOffer.suggestGeneralInDirectTypeBundledSolutions();
        } else if (channels.contains("direct")) {
          solutionOffer.suggestGeneralDirectTypeBundledSolutions();
        }
      } else if (country.contains("eu") && productPreferences.contains("iphone") && age >= 25 && annualSalary > 50000
          && annualSalary < 100000 && channels.contains("direct")) {
        solutionOffer.suggestGeneralDirectTypeBundledSolutions2();
      } else if (country.contains("eu") && productPreferences.contains("iphone") && age >= 25 && annualSalary > 50000
          && annualSalary < 100000 && channels.contains("indirect")) {
        solutionOffer.suggestGeneralInDirectTypeBundledSolutions2();
      } else if (country.contains("us") && productPreferences.contains("iphone") && annualSalary >= 100000) {
        solutionOffer.suggestLoyaltyTypeBundledSolutions();
      } else if (country.contains("eu") && productPreferences.contains("iphone") && annualSalary >= 100000) {
        solutionOffer.suggestLoyaltyTypeBundledSolutions2();
      }
    }

   

  }

  private static void printSalesOrders(Business business3) {
    MasterOrderList masterOrderList = business3.getMasterOrderList();

    System.out.println("Random Sales Orders:");
    int lineNumber = 1;
    // avoid duplicate customer IDs
    Set<String> printedCustomerIDs = new HashSet<>();
    Inventory inventory = new Inventory();

    for (Order order : masterOrderList.getOrders()) {
      String customerID = order.getCustomerId();
      int randomindex = new Random().nextInt(0, inventory.getMarketAge().size());
      int randomindex2 = new Random().nextInt(0, inventory.getChannelTypes().size());
      int randomindex3 = new Random().nextInt(0, inventory.getCountryNames().size());
      int randomindex4 = new Random().nextInt(0, inventory.getMarketIncome().size());
      int cusomterAge = inventory.getMarketAge().get(randomindex);
      String channelType = inventory.getChannelTypes().get(randomindex2);
      String CountryNames = inventory.getCountryNames().get(randomindex3);
      double customerIncome = inventory.getMarketIncome().get(randomindex4);

      // Print the customer ID only if it hasn't been printed for this customer yet
      if (!printedCustomerIDs.contains(customerID)) {
        System.out.println(lineNumber + " " + "Order ID: " + customerID + ", Age: " + cusomterAge + ", Channel Type: "
            + channelType + ", Country: " + CountryNames + ", Income: " + customerIncome);
        printedCustomerIDs.add(customerID);
        lineNumber++;
      }

      for (OrderItem orderItem : order.getOrderItems()) {
        //System.out.println(
        // " Product: " + orderItem.getSelectedProduct().getName() + " Price: $" +
        // orderItem.getActualPrice()
        // + " Quantity: " + orderItem.getQuantity() + " Total: $" +
        // orderItem.getOrderItemTotal());
      }
      System.out.println("Order Total: $" + order.getOrderTotal());
      // System.out.println("======================");
    }

  }

  // private static void printSalesOrders2(Business business3) {
  //   MasterOrderList masterOrderList = business3.getMasterOrderList();
  //   SupplierDirectory supplierDirectory = business3.getSupplierDirectory();
  //   Supplier supplier = supplierDirectory.getSupplierList().get(0);
  //   System.out.println("Sales Orders Grouped by Product:");

  //   // Create a map to group orders by product
  //   Map<Product, List<OrderItem>> productOrderMap = new HashMap<>();

  //   for (Order order : masterOrderList.getOrders()) {
  //     for (OrderItem orderItem : order.getOrderItems()) {
  //       Product product = orderItem.getSelectedProduct();
  //       productOrderMap.computeIfAbsent(product, k -> new ArrayList<>()).add(orderItem);
  //     }
  //   }

  //   // Print orders for each product
  //   for (Map.Entry<Product, List<OrderItem>> entry : productOrderMap.entrySet()) {
  //     Product product = entry.getKey();
  //     List<OrderItem> orderItems = entry.getValue();

  //     //System.out.println("Product: " + product.getName() + " from " + supplier.getName());
  //     for (OrderItem orderItem : orderItems) {
  //       System.out.println(""
  //           + " Price: $" + orderItem.getActualPrice() + " Quantity: " +
  //           orderItem.getQuantity()
  //           + " Total: $" + orderItem.getOrderItemTotal());
  //     }
  //     System.out
  //         .println("Total Orders for " + product.getName() + " from " + supplier.getName() + ": " + orderItems.size());
  //     System.out.println(
  //         "Total Sales for " + product.getName() + ": $" + product.getSalesVolume() + " from " + supplier.getName());
  //     System.out.println("======================");
  //   }
  // }

  private static void generateRevenueReports1(Business business) {
    MasterOrderList masterOrderList = business.getMasterOrderList();
    System.out.println();
    System.out.println("Sales Revenue Reports Grouped by Market and Channel:");
    System.out.println();

    // Create maps to group orders by market age, country, income, and channel
    Map<Integer, Double> totalRevenueByAge = new HashMap<>();
    Map<String, Double> totalRevenueByCountry = new HashMap<>();
    Map<Double, Double> totalRevenueByIncome = new HashMap<>();
    Map<String, Double> totalRevenueByChannel = new HashMap<>();

    Map<Integer, Double> totalSalesOrderByAge = new HashMap<>();
    Map<String, Double> totalSalesOrderByCountry = new HashMap<>();
    Map<Double, Double> totalSalesOrderByIncome = new HashMap<>();
    Map<String, Double> totalSalesOrderByChannel = new HashMap<>();
    Inventory inventory = new Inventory();

    for (Order order : masterOrderList.getOrders()) {
      // CustomerProfile customerProfile = order.getCustomerProfile();
      int randomindex = new Random().nextInt(0, inventory.getMarketAge().size());
      int randomindex2 = new Random().nextInt(0, inventory.getMarketIncome().size());
      int randomindex3 = new Random().nextInt(0, inventory.getCountryNames().size());
      int randomindex4 = new Random().nextInt(0, inventory.getChannelTypes().size());

      int randomAge = inventory.getMarketAge().get(randomindex);
      double randomIncome = inventory.getMarketIncome().get(randomindex2);
      String marketCountry = inventory.getCountryNames().get(randomindex3);
      // String marketKey = randomAge + "," + marketCountry + "," + randomIncome;
      String channelKey = inventory.getChannelTypes().get(randomindex4);

      // Add order total to the corresponding maps
      totalRevenueByAge.put(randomAge,
          totalRevenueByAge.getOrDefault(randomAge, 0.0) + order.getOrderPricePerformance());
      totalRevenueByCountry.put(marketCountry,
          totalRevenueByCountry.getOrDefault(marketCountry, 0.0) + order.getOrderPricePerformance());
      totalRevenueByIncome.put(randomIncome,
          totalRevenueByIncome.getOrDefault(randomIncome, 0.0) + order.getOrderPricePerformance());
      totalRevenueByChannel.put(channelKey,
          totalRevenueByChannel.getOrDefault(channelKey, 0.0) + order.getOrderPricePerformance());

      totalSalesOrderByAge.put(randomAge,
          totalSalesOrderByAge.getOrDefault(randomAge, 0.0) + order.getOrderTotal());
      totalSalesOrderByCountry.put(marketCountry,
          totalSalesOrderByCountry.getOrDefault(marketCountry, 0.0) + order.getOrderTotal());
      totalSalesOrderByIncome.put(randomIncome,
          totalSalesOrderByIncome.getOrDefault(randomIncome, 0.0) + order.getOrderTotal());
      totalSalesOrderByChannel.put(channelKey,
          totalSalesOrderByChannel.getOrDefault(channelKey, 0.0) + order.getOrderTotal());
    }

    // Print total revenue values by market age

    // print market age revenue without having 0 Sales
    // System.out.println("Revenue Value by Market Age:");
    // for (Map.Entry<Integer, Double> ageEntry : totalRevenueByAge.entrySet()) {
    // int age = ageEntry.getKey();
    // Double totalRevenue = ageEntry.getValue();
    // Double totalSales = totalSalesOrderByAge.get(age);
    // System.out.println(" Market Age: " + age + " Revenue: $" + totalRevenue + "Sales: $" + totalSales);
    // }

    System.out.println("Revenue Value by Market Age:");
    for (int age : inventory.getMarketAge()) {
      Double totalRevenue = totalRevenueByAge.getOrDefault(age, 0.0);
      Double totalSales = totalSalesOrderByAge.getOrDefault(age, 0.0);
      System.out.println("  Market Age: " + age + "  Revenue: $" + totalRevenue + "  Sales: $" + totalSales);
    }

    // Print total revenue values by market country
    // System.out.println("Revenue Value by Market Country:");
    // for (Map.Entry<String, Double> countryEntry :
    // totalRevenueByCountry.entrySet()) {
    // String country = countryEntry.getKey();
    // Double totalRevenue = countryEntry.getValue();
    // Double totalSales = totalSalesOrderByCountry.get(country);
    // System.out.println(" Market Country: " + country + " Revenue: $" +
    // totalRevenue + " Sales: $" + totalSales);
    // }
    System.out.println("Revenue Value by Market Country:");
    for (String country : inventory.getCountryNames()) {
      Double totalRevenue = totalRevenueByCountry.getOrDefault(country, 0.0);
      Double totalSales = totalSalesOrderByCountry.getOrDefault(country, 0.0);
      System.out.println("  Market Country: " + country + "  Revenue: $" + totalRevenue + "  Sales: $" + totalSales);
    }

    // Print total revenue values by market income
    // System.out.println("Revenue Value by Market Income:");
    // for (Map.Entry<Double, Double> incomeEntry : totalRevenueByIncome.entrySet())
    // {
    // Double income = incomeEntry.getKey();
    // Double totalRevenue = incomeEntry.getValue();
    // Double totalSales = totalSalesOrderByIncome.get(income);
    // System.out.println(" Market Income: $" + income + " Revenue: $" +
    // totalRevenue + " Sales: $" + totalSales);
    // }
    System.out.println("Revenue Value by Market Income:");
    for (double income : inventory.getMarketIncome()) {
      Double totalRevenue = totalRevenueByIncome.getOrDefault(income, 0.0);
      Double totalSales = totalSalesOrderByIncome.getOrDefault(income, 0.0);
      System.out.println("  Market Income: $" + income + "  Revenue: $" + totalRevenue + "  Sales: $" + totalSales);
    }

    // Print total revenue values by channel
    // System.out.println("Revenue Value by Channel:");
    // for (Map.Entry<String, Double> channelEntry :
    // totalRevenueByChannel.entrySet()) {
    // String channelKey = channelEntry.getKey();
    // Double totalRevenue = channelEntry.getValue();
    // Double totalSales = totalSalesOrderByChannel.get(channelKey);
    // System.out.println(" Channel: " + channelKey + " Revenue: $" + totalRevenue +
    // " Sales: $ " + totalSales);
    // }
    System.out.println("Revenue Value by Channel:");
    for (String channelKey : inventory.getChannelTypes()) {
      Double totalRevenue = totalRevenueByChannel.getOrDefault(channelKey, 0.0);
      Double totalSales = totalSalesOrderByChannel.getOrDefault(channelKey, 0.0);
      System.out.println("  Channel: " + channelKey + "  Revenue: $" + totalRevenue + "  Sales: $ " + totalSales);
    }
  }

  private static void generateRevenueReports2(Business business) {
    MasterOrderList masterOrderList = business.getMasterOrderList();
    System.out.println("Sales Reports Grouped by Bundle Item:");

    // Create maps to group orders by market age, country, income, and channel

    Map<String, Double> totalRevenueByBundle = new HashMap<>();
    Map<String, Double> totalRevenueByComposition = new HashMap<>();

    Map<String, Double> totalSalesOrderByBundle = new HashMap<>();
    Map<String, Double> totalSalesOrderByComposition = new HashMap<>();
    Inventory inventory = new Inventory();

    for (Order order : masterOrderList.getOrders()) {
      // CustomerProfile customerProfile = order.getCustomerProfile();
      int randomindex3 = new Random().nextInt(inventory.getBundleTypes().size());
      int randomindex4 = new Random().nextInt(0, inventory.getBundleComposition().size());

      String BundleType = inventory.getBundleTypes().get(randomindex3);
      // String marketKey = randomAge + "," + marketCountry + "," + randomIncome;

      String Composition = inventory.getBundleComposition().get(randomindex4);

      // Add order total to the corresponding maps

      totalRevenueByBundle.put(BundleType,
          totalRevenueByBundle.getOrDefault(BundleType, 0.0) + order.getOrderPricePerformance());
      totalRevenueByComposition.put(Composition,
          totalRevenueByComposition.getOrDefault(Composition, 0.0) + order.getOrderPricePerformance());

      totalSalesOrderByBundle.put(BundleType,
          totalSalesOrderByBundle.getOrDefault(BundleType, 0.0) + order.getOrderTotal());
      totalSalesOrderByComposition.put(Composition,
          totalSalesOrderByComposition.getOrDefault(Composition, 0.0) + order.getOrderTotal());

    }

    // Print total revenue values by market age

    // Print total revenue values by market country
    System.out.println();
    System.out.println("Revenue Value by Bundle Types:");
    for (String bundle : inventory.getBundleTypes()) {
      Double totalRevenue = totalRevenueByBundle.getOrDefault(bundle, 0.0);
      Double totalSales = totalSalesOrderByBundle.getOrDefault(bundle, 0.0);
      System.out.println("  Bundle Type: " + bundle + "  Revenue: $" + totalRevenue + "  Sales: $" + totalSales);
    }
    // for (Map.Entry<String, Double> countryEntry :
    // totalRevenueByBundle.entrySet()) {
    // String bundle = countryEntry.getKey();
    // Double totalRevenue = countryEntry.getValue();
    // Double totalSales = totalSalesOrderByBundle.get(bundle);
    // System.out.println(" Bundle Type: " + bundle + " Revenue: $" + totalRevenue +
    // " Sales: $" + totalSales);
    // }

    // Print total revenue values by channel
    System.out.println("Revenue Value by Composition:");
    for (String composition : inventory.getBundleComposition()) {
      Double totalRevenue = totalRevenueByComposition.getOrDefault(composition, 0.0);
      Double totalSales = totalSalesOrderByComposition.getOrDefault(composition, 0.0);
      System.out
          .println("  Bundle Composition: " + composition + ",  Revenue: $" + totalRevenue + "  Sales: $" + totalSales);
    }
    // for (Map.Entry<String, Double> channelEntry :
    // totalRevenueByComposition.entrySet()) {
    // String composition = channelEntry.getKey();
    // Double totalRevenue = channelEntry.getValue();
    // Double totalSales = totalSalesOrderByComposition.get(composition);
    // System.out.println(" Bundle Composition: " + composition + ", Revenue: $" +
    // totalRevenue + " Sales: $ " + totalSales);
    // }
  }

  private static void generateAdSalesReports(Business business) {
    MasterOrderList masterOrderList = business.getMasterOrderList();
    System.out.println("Ad Sales Reports Grouped by Advertisement:");

    Map<String, Double> totalRevenueByAd = new HashMap<>();
    Map<String, Double> totalSalesByAd = new HashMap<>();
    Inventory inventory = new Inventory();

    for (Order order : masterOrderList.getOrders()) {
        int randomAdIndex = new Random().nextInt(inventory.getAdTypes().size());
        String adType = inventory.getAdTypes().get(randomAdIndex);

        totalRevenueByAd.put(adType,
            totalRevenueByAd.getOrDefault(adType, 0.0) + order.getOrderPricePerformance());
        totalSalesByAd.put(adType,
            totalSalesByAd.getOrDefault(adType, 0.0) + order.getOrderTotal());
    }

    // Print total revenue values by ad type
    System.out.println("Revenue Value by Ad Type:");
    for (String adType : inventory.getAdTypes()) {
        Double totalRevenue = totalRevenueByAd.getOrDefault(adType, 0.0);
        Double totalSales = totalSalesByAd.getOrDefault(adType, 0.0);
        System.out.println("  Ad Type: " + adType + "  Revenue: $" + totalRevenue + "  Sales: $" + totalSales);
    }
}

  

  // static void loadSolutionOrders(Business b, int orderCount, int itemCount) {
  //   MasterSolutionOrderList masterSolutionOrderList = b.getMasterSolutionOrderList();
  //   CustomerDirectory customerDirectory = b.getCustomerDirectory();
  //   SupplierDirectory supplierDirectory = b.getSupplierDirectory();

  //   Map<Integer, Double> totalSalesByAge = new HashMap<>();
  //   Map<String, Double> totalSalesByCountry = new HashMap<>();
  //   Map<String, Double> totalSalesByChannel = new HashMap<>();

  //   for (int index = 0; index < orderCount; index++) {
  //     CustomerProfile randomCustomer = customerDirectory.pickRandomCustomer();
  //     SolutionOrder randomOrder = new SolutionOrder(randomCustomer);

  //     // Generate solution order items based on the assigned market and channel
  //     for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
  //       Supplier randomSupplier = supplierDirectory.pickRandomSupplier();
  //       if (randomSupplier == null) {
  //         System.out.println("Cannot generate orders. No supplier in the supplier directory.");
  //         return;
  //       }

  //       ProductCatalog pc = randomSupplier.getProductCatalog();
  //       Product randomProduct = pc.pickRandomProduct();
  //       if (randomProduct == null) {
  //         System.out.println("Cannot generate orders. No products in the product catalog.");
  //         return;
  //       }

  //       int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
  //       int randomQuantity = getRandom(1, 5);

  //       SolutionOffer randomSolutionOffer = new SolutionOffer(randomProduct, randomPrice, randomQuantity);
  //       randomOrder.newSolutionOrderItem(randomSolutionOffer, randomPrice, randomQuantity);

  //       Inventory inventory = b.getInventory(); // Use the existing inventory associated with the business
  //       List<Integer> marketAges = inventory.getMarketAge();
  //       List<String> channelTypes = inventory.getChannelTypes();
  //       List<String> countryNames = inventory.getCountryNames();
  //       if (!marketAges.isEmpty() && !channelTypes.isEmpty() && !countryNames.isEmpty()) {
  //         int randomindex = getRandom(0, marketAges.size() - 1);
  //         int marketAge = marketAges.get(randomindex);
  //         int randomindex2 = getRandom(0, inventory.getCountryNames().size() - 1);
  //         int randomindex3 = getRandom(0, inventory.getChannelTypes().size() - 1);

  //         String Country = inventory.getCountryNames().get(randomindex2);
  //         String channel = inventory.getChannelTypes().get(randomindex3);
  //         totalSalesByAge.put(marketAge,
  //             totalSalesByAge.getOrDefault(marketAge, 0.0) + randomOrder.getSolutionOrderPricePerformance());
  //         totalSalesByCountry.put(Country,
  //             totalSalesByCountry.getOrDefault(Country, 0.0) + randomOrder.getSolutionOrderPricePerformance());
  //         totalSalesByChannel.put(channel,
  //             totalSalesByChannel.getOrDefault(channel, 0.0) + randomOrder.getSolutionOrderPricePerformance());
  //       }

  //     }

  //     // Add the order to the master list or perform any other necessary actions
  //     masterSolutionOrderList.newSolutionOrder(randomOrder);
  //   }

  //   // Print or use the total sales results as needed
  //   System.out.println("Total Revenue by Age: " + totalSalesByAge);
  //   System.out.println("Total Revenue by Country: " + totalSalesByCountry);
  //   System.out.println("Total Revenue by Channel: " + totalSalesByChannel);

  // }

  

  
  

  private static int getRandom(int lower, int upper) {
    Random random = new Random();
    return random.nextInt(upper - lower + 1) + lower;
  }

}
