/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;
import model.MarketModel.MarketChannelAssignment;


/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {
    ArrayList<SolutionOffer> solutionoffers;
    Business business;
    
    
    public SolutionOfferCatalog(){
        solutionoffers = new ArrayList<SolutionOffer>();
    }

    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }
    public Business getBusiness() {
        return business;
    }

    public SolutionOfferCatalog(Business b) {

        business = b;
        solutionoffers = new ArrayList<SolutionOffer>();

    }
    public int getSolutionOffersSize() {
        return solutionoffers.size();
    }

    // public SolutionOffer pickRandomSolutionOffer(String[]options) {
    //     Random rand = new Random();
    //     int n = rand.nextInt(options.length);
    //     return solutionoffers.get(n);
    // }

    public SolutionOffer getRandomSolutionOffer() {
        if (getSolutionOffersSize() == 0) {
            // Return a default solution offer or handle it in a different way
            return getDefaultSolutionOffer();
        }
    
        Random random = new Random();
        int randomIndex = random.nextInt(getSolutionOffersSize());
        
        // Ensure that the random index is within the bounds of the list
        if (randomIndex >= 0 && randomIndex < getSolutionOffersSize()) {
            return solutionoffers.get(randomIndex);
        } else {
            // Handle the case where the random index is out of bounds
            // This might happen in rare cases due to concurrent modification or other factors
            return getDefaultSolutionOffer();
        }
    }
    private SolutionOffer getDefaultSolutionOffer() {
        // Implement logic to provide a default solution offer
        // For example, return the first solution offer in the list
        return solutionoffers.get(0);
    }
    

   

    public void addSolutionOffer(SolutionOffer offer) {
        if (solutionoffers == null) {
            solutionoffers = new ArrayList<>();
        }
        solutionoffers.add(offer);
    }

    





    
}
