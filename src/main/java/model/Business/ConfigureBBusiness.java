package model.Business;

import java.util.Random;

import com.github.javafaker.Faker;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
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
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

public class ConfigureBBusiness {
    static int upperPriceLimit = 50;
    static int lowerPriceLimit = 10;
    static int range = 5;
    static int productMaxQuantity = 5;
    static String[] productNames = {"iphone, ipad, Macbook, Airpods, Apple Watch"};


    static int[] age = {18, 24, 30, 40, 52};
    static String[] genders = {"Male", "Female"};
    static String[] countries = {"US", "EU"};
    static String[] jobs = {"Student", "Employee", "Umemployed"};
    static int[] income = {30000, 100000, 200000};

    static String [] channelTypes = {"Direct", "Indirect"};
    static String[] indirectChannels ={"BestBuy", "Amazon", "Walmart"};
    static String[] directChannels ={"Website", "Mobile App", "Physical Store"};

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
    





    public static Business createABusiness(String name, int marketCount, int productCount,
            int customerCount, int orderCount, int itemCount, int channelCount) {
        Business business = new Business(name);

        // Add Market +
        loadMarkets(business, marketCount);

        // Add Channels + 
        loadChannels(business, channelCount);

        // Add Channels +
        loadProducts(business, productCount);

        // Add Customers
        loadCustomers(business, customerCount);

        // Add Order
        //loadSolutionOrders(business, orderCount, itemCount);

        return business;
    }

    

    

    public static void loadMarkets(Business b, int MarketCount) {
    

    MarketCatalog marketCatalog = b.getMarketCatalog();
    if (marketCatalog == null) {
      marketCatalog = new MarketCatalog();
       
    }
    for (int index = 1; index <= MarketCount; index++) {
    
      int randomAge = generateRandomInt(age);
      String randomGender = generateRandomString(genders);
      String randomCountry = generateRandomString(countries);
      String randomJob = generateRandomString(jobs);
      int randomIncome = generateRandomInt(income);
      if (marketCatalog != null) {
        marketCatalog.newMarket(randomAge, randomGender, randomCountry, randomJob, randomIncome);
    } else {
        // Handle the case where marketCatalog is null
        System.out.println("MarketCatalog is null. Unable to create new market.");
    }
      
    }  
    }

    public static void loadChannels(Business b, int channelCount) {
    ChannelCatalog  channelCatalog = b.getChannelCatalog();
    if (channelCatalog == null) {
        channelCatalog = new ChannelCatalog();
           
    }
    for (int index = 1; index <= channelCount; index++) {
        
        String randomChannelType = generateRandomString(channelTypes);
        String randomIndirectChannel = generateRandomString(indirectChannels);
        String randomDirectChannel = generateRandomString(directChannels);
        if (channelCatalog != null) {
        channelCatalog.newChannel(randomChannelType, randomIndirectChannel, randomDirectChannel);
    } else {
            // Handle the case where marketCatalog is null
        System.out.println("channelCatalog is null. Unable to create new market.");
        }
          
        }  
    }

    static void loadProducts(Business b, int productCount) {
        SupplierDirectory supplierDirectory = b.getSupplierDirectory();

    for (Supplier supplier : supplierDirectory.getSupplierList()) {

      int randomProductNumber = getRandom(1, productCount);
      ProductCatalog productCatalog = supplier.getProductCatalog();
      //Product product = productCatalog.getProduct();

      for (int index = 1; index <= randomProductNumber; index++) {

        //String productName = "Product #" + index + " from " + supplier.getName();
        //String productName = product.getName();
        String productName = generateRandomString(productNames);
        int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
        int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
        int randomTarget = getRandom(randomFloor, randomCeiling);

        productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
      }
    }
    }



    static void loadCustomers(Business b, int customerCount) {
        CustomerDirectory customerDirectory = b.getCustomerDirectory();
        PersonDirectory personDirectory = b.getPersonDirectory();
    
        Faker faker = new Faker();
    
        for (int index = 1; index <= customerCount; index++) {
          Person newPerson = personDirectory.newPerson(faker.name().fullName());
          //Person newPerson = personDirectory.newPerson(id,name,sex,job,income,age);
          customerDirectory.newCustomerProfile(newPerson);
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


    public static String generateRandomString(String[] options) {
        Random random = new Random();
        int index = random.nextInt(options.length);
        return options[index];
    }

    public static int generateRandomInt(int[] options) {
        Random random = new Random();
        int index = random.nextInt(options.length);
        return options[index];
    }



    















}
