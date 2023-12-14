/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import model.Business.Inventory;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.OrderItem;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Market {
    ArrayList<SolutionOffer> so;
    ArrayList<MarketChannelAssignment> mcas;
    Inventory inventory;
   
    ArrayList<String> characteristics;
    ArrayList<Market> submarkets;
    ArrayList<CustomerProfile> customerlist;
    MarketCatalog marketCatalog;
    int size;
    String marketgroup;
    int age;
    String genders;
    String countries;
    String jobs;
    int income;
    String name;
    



    
   

    public Market(String s) {
        characteristics = new ArrayList<String>();
        characteristics.add(s);
    }

    public Market(int ra, String rg, String rc, String rj, int ri ) {
       age = ra;
       genders = rg;
       countries = rc;
       jobs = rj;
       income = ri;
       mcas = new ArrayList<MarketChannelAssignment>();

    }
    // 12 7
    public Market(String name, int age, String country, double income) {
        this.name = name;
        this.age = age;
        this.countries = country;
        this.income = (int) income;
        mcas = new ArrayList<MarketChannelAssignment>();
        
    }
    public Market( int age, String country, double income) {
        this.age = age;
        this.countries = country;
        this.income = (int) income;
        mcas = new ArrayList<MarketChannelAssignment>();
        
    }

    

    



   
    // get set start
    public ArrayList<SolutionOffer> getSo() {
        return so;
    }
     public String getName() {
        return name;
    }

    public void setSo(ArrayList<SolutionOffer> so) {
        this.so = so;
    }

    public ArrayList<MarketChannelAssignment> getMca() {
        return mcas;
    }

    public void setMca(ArrayList<MarketChannelAssignment> mca) {
        this.mcas = mca;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    public ArrayList<Market> getSubmarkets() {
        return submarkets;
    }

    public void setSubmarkets(ArrayList<Market> submarkets) {
        this.submarkets = submarkets;
    }

    public ArrayList<CustomerProfile> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(ArrayList<CustomerProfile> customerlist) {
        this.customerlist = customerlist;
    }

    public MarketCatalog getMarketCatalog() {
        return marketCatalog;
    }

    public void setMarketCatalog(MarketCatalog marketCatalog) {
        this.marketCatalog = marketCatalog;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMarketgroup() {
        return marketgroup;
    }

    public void setMarketgroup(String marketgroup) {
        this.marketgroup = marketgroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenders() {
        return genders;
    }

    public void setGenders(String genders) {
        this.genders = genders;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    // connect to market channel assignment
    public void addMarketChannelAssignment(MarketChannelAssignment mca) {
        mcas.add(mca);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Market market = (Market) obj;
        return Objects.equals(name, market.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static String generateRandomString(String[] options) {
        Random random = new Random();
        int index = random.nextInt(options.length);
        return options[index];
    }



    

    





    

    


}
