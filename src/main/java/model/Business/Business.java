/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Channel;
import model.MarketModel.ChannelCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketCatalog;
import model.MarketModel.MarketChannelAssignment;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;
import model.SolutionOrder.MasterSolutionOrderList;
import model.Business.Inventory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory;
    MasterOrderList masterorderlist;
    SupplierDirectory suppliers;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
    SolutionOfferCatalog solutionoffercatalog;
    CustomerDirectory customerdirectory;
    EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;
    MasterSolutionOrderList mastersolutionorderlist;
    Inventory inventory;
    private List<SolutionOffer> solutionOffers = new ArrayList<>();
    

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();
//        solutionoffercatalog = new SolutionOfferCatalog();
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        employeedirectory = new EmployeeDirectory(this);
        marketcatalog = new MarketCatalog();
        channelcatalog = new ChannelCatalog();
        mastersolutionorderlist = new MasterSolutionOrderList();
        solutionoffercatalog = new SolutionOfferCatalog();
        inventory = new Inventory();

    }

    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }
    public void addSolutionOffer(SolutionOffer solutionOffer) {
        solutionOffers.add(solutionOffer);
    }

    
    public List<SolutionOffer> getSolutionOffers() {
        return solutionOffers;
    }

    public SolutionOffer[] getSolutionOffers2() {
        return solutionOffers.toArray(new SolutionOffer[0]);
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }
    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }
    public MarketCatalog getMarketCatalog() {
        return marketcatalog;
    }
    public ChannelCatalog getChannelCatalog() {
        return channelcatalog;
    }
    public MasterSolutionOrderList getMasterSolutionOrderList() {
        return mastersolutionorderlist;
    }
    public SolutionOfferCatalog getSolutionOfferCatalog() {
        return solutionoffercatalog;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }
        public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public void printShortInfo(){
        System.out.println("Checking what's inside the business hierarchy.");
        suppliers.printShortInfo();
        customerdirectory.printShortInfo();
        masterorderlist.printShortInfo();
        //marketcatalog.printShortInfo();
    }
    //test
    public void printMarketCatalog(int marketCount){
        //Business business = ConfigureBBusiness.createABusiness(
        MarketCatalog marketCatalog = getMarketCatalog();
        //ArrayList market = marketCatalog.getMarkets(); 
        int age = marketCatalog.getMarkets().get(0).getAge();
        String genders = marketCatalog.getMarkets().get(0).getGenders();
        String countries = marketCatalog.getMarkets().get(0).getCountries();
        String jobs = marketCatalog.getMarkets().get(0).getJobs();
        int income = marketCatalog.getMarkets().get(0).getIncome();

        for(int i =0; i<marketCount; i++){
            System.out.println("Market: " +"Age: " +  marketCatalog.getMarkets().get(i).getAge() + ", gender : " + marketCatalog.getMarkets().get(i).getGenders() + ", countries: " + marketCatalog.getMarkets().get(i).getCountries() + ", job :" + marketCatalog.getMarkets().get(i).getJobs() + ", income :" + marketCatalog.getMarkets().get(i).getIncome());
        }
    }

    // test
    public void printMarketChannelAssign(){
        MarketCatalog marketCatalog = getMarketCatalog();
        ChannelCatalog channelCatalog = getChannelCatalog();
        int marketage = marketCatalog.getMarkets().get(0).getAge();
        String marketgenders = marketCatalog.getMarkets().get(0).getGenders();
        String marketcountries = marketCatalog.getMarkets().get(0).getCountries();
        String marketjobs = marketCatalog.getMarkets().get(0).getJobs();
        int marketincome = marketCatalog.getMarkets().get(0).getIncome();
        String channeltypes = channelCatalog.getChannels().get(0).getChanneltypes();
        
    }

    // test

    public void printChannelCatalog2(int channelCount){
        ChannelCatalog channelCatalog = getChannelCatalog();

        if (channelCatalog != null && channelCatalog.getChannels() != null) {
            List<Channel> channels = channelCatalog.getChannels();

            for (int i = 0; i < Math.min(channelCount, channels.size()); i++) {
                Channel currentChannel = channels.get(i);
                String channelType = currentChannel.getChanneltypes();
                String directChannel = currentChannel.getDirectChannels();
                String indirectChannel = currentChannel.getIndirectChannels();

                System.out.println("Channel: " + channelType + " " + directChannel + " " + indirectChannel);
            }
        } else {
            System.out.println("ChannelCatalog is null or does not contain channels.");
        }
    }
    public void printChannelCatalog(int channelCount){
        ChannelCatalog channelCatalog = getChannelCatalog();
       
        for (int i = 0; i < channelCount; i++) {
            Channel currentChannel = channelCatalog.getChannels().get(i);
            String channelType = currentChannel.getChanneltypes();
            String directChannel = currentChannel.getDirectChannels();
            String indirectChannel = currentChannel.getIndirectChannels();
            System.out.println("Channel: " + channelType + " " + directChannel + " " + indirectChannel);
        }

           
    }
    // public void printSolutionOffer2(int marketChannelAssignmentCount){
    //     MarketCatalog marketCatalog = getMarketCatalog();
    //     ChannelCatalog channelCatalog = getChannelCatalog();
    //     MarketChannelAssignment marketChannelAssignment = new MarketChannelAssignment(marketCatalog.getMarkets().get(0), channelCatalog.getChannels().get(0));
    //     ArrayList<SolutionOffer> solutionoffers = new ArrayList<>();
    //     for ( int i =0; i<10; i++){
    //         Market currentMarket = marketCatalog.getMarkets().get(i);
    //         Channel currentChannel = channelCatalog.getChannels().get(i);
    //         int marketage = currentMarket.getAge();
    //         String marketgenders = currentMarket.getGenders();
    //         String marketcountries = currentMarket.getCountries();
    //         String marketjobs = currentMarket.getJobs();
    //         int marketincome = currentMarket.getIncome();
    //         String channeltypes = currentChannel.getChanneltypes();
    //         String directChannel = currentChannel.getDirectChannels();
    //         System.out.println(marketChannelAssignment.assign1(marketage, marketjobs,  channeltypes));
    //         if (marketChannelAssignment.assign1() == "Comfort Type"){
    //             for (SolutionOffer solutionOffer : solutionoffers) {
    //                solutionOffer.suggestStudentTypeBundledSolutions();
                  
    //             }
                
    //         } else {
    //             for (SolutionOffer solutionOffer : solutionoffers) {
    //                 solutionOffer.suggestGeneralTypeTypeBundledSolutions();
    //             }
    //         }
            
        
    //     }
    // }
    // public void printSolutionOffer(int marketChannelAssignmentCount) {
    //     MarketCatalog marketCatalog = getMarketCatalog();
    //     ChannelCatalog channelCatalog = getChannelCatalog();
    //     ArrayList<SolutionOffer> solutionoffers = new ArrayList<>();
    
    //     // Assuming marketCatalog.getMarkets() and channelCatalog.getChannels() have at least 10 elements
    //     for (int i = 0; i < marketChannelAssignmentCount; i++) {
    //         Market currentMarket = marketCatalog.getMarkets().get(i);
    //         Channel currentChannel = channelCatalog.getChannels().get(i);
    
    //         int marketage = currentMarket.getAge();
    //         String marketgenders = currentMarket.getGenders();
    //         String marketcountries = currentMarket.getCountries();
    //         String marketjobs = currentMarket.getJobs();
    //         int marketincome = currentMarket.getIncome();
    //         String channeltypes = currentChannel.getChanneltypes();
    //         String directChannel = currentChannel.getDirectChannels();
    
    //         // Create a single instance of MarketChannelAssignment
    //         MarketChannelAssignment marketChannelAssignment = new MarketChannelAssignment(currentMarket, currentChannel);
    
    //         // Add SolutionOffer instances to the list
    //         SolutionOffer solutionOffer = new SolutionOffer(marketChannelAssignment);
    //         solutionoffers.add(solutionOffer);
    
    //         // Call assign1 method
    //         String assignmentResult = marketChannelAssignment.assign1(marketage, marketjobs, channeltypes);
    //         System.out.println(assignmentResult);
    
    //         // Check the result and invoke the appropriate suggestion method
    //         if ("Comfort Type".equals(assignmentResult)) {
    //             for (SolutionOffer offer : solutionoffers) {
    //                 offer.suggestStudentTypeBundledSolutions();
    //             }
    //         } else {
    //             for (SolutionOffer offer : solutionoffers) {
    //                 offer.suggestFamilyOrientedTypeBundledSolutions();
    //             }
    //         }
    //     }
    // }
    // 12 07 test
    private List<MarketChannelAssignment> marketChannelAssignments = new ArrayList<>();

    // ... Other existing code ...

    public void addMarketChannelAssignment(MarketChannelAssignment assignment) {
        marketChannelAssignments.add(assignment);
    }

    public MarketChannelAssignment[] getMarketChannelAssignments() {
        return marketChannelAssignments.toArray(new MarketChannelAssignment[0]);
    }

    public MarketChannelAssignment getRandomMarketChannelAssignment() {
        Random random = new Random();
        int index = random.nextInt(marketChannelAssignments.size());
        return marketChannelAssignments.get(index);
    }

    


    
    
    
    





    

}
