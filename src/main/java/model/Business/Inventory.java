package model.Business;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {

    ArrayList<String> productNames;
    ArrayList<Integer> productPrice;
    ArrayList<String> CountryNames;
    ArrayList<Integer> marketAge;
    ArrayList<String> ChannelTypes;
    ArrayList<Integer> marketIncome;
    ArrayList<String> bundleTypes;
    ArrayList<String> bundleComposition;
    ArrayList<Integer> bundlePrice;
    ArrayList<String> AdTypes;

    
   

    

    public Inventory() {
        productNames = new ArrayList<String>(
                Arrays.asList("iPhone SE3", "iphone 15", "iphone 15", "iphone Pro  15", "iPhone 14", "iphone 14 Pro", "iphone SE2", "iphone 13",
                        "iphone 6S", "iphone 12"));
        productPrice = new ArrayList<Integer>(
                Arrays.asList(1000, 2000, 800, 500, 300, 200, 1500, 1200, 3000, 200));
        CountryNames = new ArrayList<String>(
                Arrays.asList("USA", "Germany", "South Korea", "China", " Canada ", " Japan ",  "France", "Australia",  "United Kingdom",
                 "Italy", "Spain"));
        marketAge = new ArrayList<Integer>(
                Arrays.asList(17, 20, 25, 33, 42, 50, 61));
        ChannelTypes = new ArrayList<String>(
                Arrays.asList("indirect", "direct"));
        marketIncome = new ArrayList<Integer>(
                Arrays.asList(30000, 50000, 100000, 150000, 200000, 250000, 300000 ));
        bundleTypes = new ArrayList<String>(
                Arrays.asList("Student(US)", "Student(EU)", "GeneralDirect(US)","GeneralIndirect(US)", "GeneralDirect(EU)","GeneralIndirect(EU)", "Loyalty(US)", "Loyalty(EU)" ));
        bundleComposition = new ArrayList<String>(
                Arrays.asList("Apple iPhone SE3 + Apple Fitness", "Apple iPhone 15 + Apple Music" , "Apple iPhone 15 Pro + Apple Arcade", "Apple iPhone 15 + Apple Care+", "Apple iPhone SE3 + Apple TV+", "Apple iPhone 15 + Apple Podcasts+", "Apple iphone Pro 15 + AppleCare Pro", "Apple iPhone 15 + Apple Podcasts",
                        "iphone 14 + Apple Music"));
        bundlePrice = new ArrayList<Integer>(
                Arrays.asList(1,299, 2,199, 899, 599, 349, 249, 2,999, 1099, 5,999));
        AdTypes = new ArrayList<String>(
                Arrays.asList("US_StudentBundleAdsType", "US_PremiumDirectBundleAdsType", "US_EverydayDirectBundleAdsType", "US_LoyaltyBundleAdsType","EU_StudentBundleAdsType,", "EU_PremiumDirectBundleAdsType", "EU_EverydayDirectBundleAdsType", "EU_LoyaltyBundleAdsType" ));

    }

    public ArrayList<String> getProductNames() {
        return productNames;
    }

    public ArrayList<Integer> getProductPrice() {
        return productPrice;
    }

    public ArrayList<String> getCountryNames() {
        return CountryNames;
    }

    public ArrayList<Integer> getMarketAge() {
        return marketAge;
    }

    public ArrayList<String> getChannelTypes() {
        return ChannelTypes;
    }
    public ArrayList<Integer> getMarketIncome() {
        return marketIncome;
    }
    public ArrayList<String> getBundleTypes() {
        return bundleTypes;
    }

    public ArrayList<String> getBundleComposition() {
        return bundleComposition;
    }

    public ArrayList<Integer> getBundlePrice() {
        return bundlePrice;
    }
    public ArrayList<String> getAdTypes() {
        return AdTypes;
    }


}
