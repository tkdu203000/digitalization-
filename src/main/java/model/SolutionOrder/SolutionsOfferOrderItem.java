package model.SolutionOrder;

import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.ProductManagement.SolutionOffer;

public class SolutionsOfferOrderItem {

    SolutionOffer selectedoffer;
    int actualPrice;
    int quantity;
    int number;

    public SolutionsOfferOrderItem(SolutionOffer so, int paidprice, int q) {
        selectedoffer = so;
        so.addSolutionOfferOrderItem(this); // make sure product links back to the item
        quantity = q;
        this.actualPrice = paidprice;
    }

    

    public SolutionOffer getSolutionOffer() {
        return selectedoffer;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSolutionsOfferOrderItemTotal() {
        return actualPrice * quantity;
    }

    public void setMarketAndChannel(Market market, Channel channel) {
        // Set the market and channel for the sales solution offer order item
    }

    public int calculatePricePerformance() {
        return (actualPrice - selectedoffer.getTargetPrice()) * quantity;
    }

    

}
