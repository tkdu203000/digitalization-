/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.OrderManagement.OrderItem;
import model.ProductManagement.Product;
import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {
    
    private Market selectedmarket;
    private Channel selectedchannel;
    int adPrice;
    ArrayList<SolutionOffer> solutionoffers;
    private String customerType;
    private String consumertypes;
    
    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }

    public MarketChannelAssignment(Market m, Channel c){
        
        selectedmarket = m;
        selectedchannel = c;
        //m.addMarketChannelAssignment(this);
        //c.addMarketChannelAssignment(this);
        solutionoffers = new ArrayList<SolutionOffer>();
        
    }

    public MarketChannelAssignment(ArrayList<SolutionOffer> solutionOffers) {
        this.solutionoffers = solutionOffers;
    }

    public Market getMarket() {
        return selectedmarket;
    }

    public Channel getChannel() {
        return selectedchannel;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType(int age, double income, String channel) {
        return customerType;
    }

    






    

    // public String assign1(int age, String job, String channelType ) {
    //     // Use marketModel and channelModel to make decisions
    //     if (age < 20 && "Student".equalsIgnoreCase(job) && "Direct".equalsIgnoreCase(channelType)  ) {
    //         for (SolutionOffer solutionOffer : solutionoffers) {
    //             solutionOffer.suggestBudgetConsciousGenerationTypeBundledSolutions();
    //         }
    //         //suggestComfortTypeBundledSolutions();
    //         return "TrendSetter Type";
    //     } else {
    //         for (SolutionOffer solutionOffer : solutionoffers) {
    //             solutionOffer.suggestGeneralTypeTypeBundledSolutions();
    //         }
    //         //suggestUncomfortTypeBundledSolutions();
    //         return "GeneralType";
    //     }
    // }
    // public String assign1( ) {
    //     // Use marketModel and channelModel to make decisions
    //     if (selectedmarket.getAge() < 20 && "Student".equalsIgnoreCase(selectedmarket.getJobs()) && "Direct".equalsIgnoreCase(selectedchannel.getChanneltypes()) && selectedmarket.getCountries().equalsIgnoreCase("Asia") ) {
    //         for (SolutionOffer solutionOffer : solutionoffers) {
    //             solutionOffer.suggestBudgetConsciousGenerationTypeBundledSolutions();   
    //         }
    //         //suggestComfortTypeBundledSolutions();
    //         return "BudgetConscious Type";
    //     } else {
    //         for (SolutionOffer solutionOffer : solutionoffers) {
    //             solutionOffer.suggestConvenienceDrivenWomenTypeBundledSolutions();
    //         }
    //         //suggestUncomfortTypeBundledSolutions();
    //         return "ConvenienceDrivenWomen Type";
    //     }
        
    // }
    public String getconsumertypes  (int age, double income, String channel) {
        if (selectedmarket.getAge() <= 24 && selectedmarket.getIncome() < 50000   ) {
            for (SolutionOffer solutionOffer : solutionoffers) {
                solutionOffer.suggestStudentTypeBundledSolutions();
            }
            
            return "Student Type";
        }
        if ( selectedmarket.getIncome() > 50000  && selectedmarket.getIncome() < 100000 && "Direct".equalsIgnoreCase(selectedchannel.getChanneltypes())  ) {
            for (SolutionOffer solutionOffer : solutionoffers) {
                solutionOffer.suggestGeneralDirectTypeBundledSolutions();
            }
            
            return "General Direct Type";
        }
        if ( selectedmarket.getIncome() > 50000  && selectedmarket.getIncome() < 100000 && "Indirect".equalsIgnoreCase(selectedchannel.getChanneltypes())  ) {
            for (SolutionOffer solutionOffer : solutionoffers) {
                solutionOffer.suggestGeneralInDirectTypeBundledSolutions();
            }
            
            return "General Indirect Type";
        }
        if ( selectedmarket.getIncome() >= 100000     ) {
            for (SolutionOffer solutionOffer : solutionoffers) {
                solutionOffer.suggestLoyaltyTypeBundledSolutions();
            }
            //suggestComfortTypeBundledSolutions();
            return "Loyalty Type";
        } else {
            for (SolutionOffer solutionOffer : solutionoffers) {
                solutionOffer.suggestGeneralDirectTypeBundledSolutions();
            }
           
            return "General Type";
        }
    }









    private void suggestComfortTypeBundledSolutions2() {
        // Suggest bundled solutions for Comfort Type
        String[] comfortTypeBundledSolutions = {
                "Bundled Solution 1: Apple Mac 13 + AppleCare X",
                "Bundled Solution 3: Apple ipad C + Apple One Z",
                "Bundled Solution 5: Apple Watch E + Apple Music",
                "Bundled Solution 6: Apple iphone F + Apple Arcade",
                "Bundled Solution 8: Apple iphone SE3 + Apple Fitness",
                "Bundled Solution 11: Apple iphone 13 + Apple Podcasts"
        };

        // Print the suggested bundled solutions for Comfort Type
        System.out.println("Suggested Comfort Type Bundled Solutions:");
        for (String solution : comfortTypeBundledSolutions) {
            System.out.println(solution);
        }
    }

    private void suggestUncomfortTypeBundledSolutions2() {
        // Suggest bundled solutions for Uncomfort Type
        String[] uncomfortTypeBundledSolutions = {
                "Bundled Solution 2: Apple iphone XS B + iCloud Y",
                "Bundled Solution 4: Apple Airpods D + Apple TV",
                "Bundled Solution 7: Apple Mac 15 + Apple News",
                "Bundled Solution 9: Apple iphone SE2 + Apple Card",
                "Bundled Solution 10: Apple iphone 15 + Apple Books"
        };

        // Print the suggested bundled solutions for Uncomfort Type
        System.out.println("Suggested Uncomfort Type Bundled Solutions:");
        for (String solution : uncomfortTypeBundledSolutions) {
            System.out.println(solution);
        }
    }












    public Market getSelectedmarket() {
        return selectedmarket;
    }

    public void setSelectedmarket(Market selectedmarket) {
        this.selectedmarket = selectedmarket;
    }

    public Channel getSelectedchannel() {
        return selectedchannel;
    }

    public void setSelectedchannel(Channel selectedchannel) {
        this.selectedchannel = selectedchannel;
    }

    public int getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(int adPrice) {
        this.adPrice = adPrice;
    }

    public void addSolutionOffer(SolutionOffer so) {
        solutionoffers.add(so);
    }






    
    
}
