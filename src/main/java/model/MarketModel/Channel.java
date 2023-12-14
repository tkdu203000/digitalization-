/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.SolutionOffer;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    ArrayList<SolutionOffer> so;
    ArrayList<MarketChannelAssignment> mcas;
    String channeltypes;
    String directChannels;
    String indirectChannels;

    public String getChannelType() {
        return channeltypes;
    }



   

    public Channel(String channeltypes) {
        this.channeltypes = channeltypes;
        //so = new ArrayList<SolutionOffer>();
        //mcas = new ArrayList<MarketChannelAssignment>();
    }

    public Channel(String rct, String rdc, String ric) {
        channeltypes = rct;
        directChannels = rdc;
        indirectChannels = ric;
        so = new ArrayList<SolutionOffer>();
        mcas = new ArrayList<MarketChannelAssignment>();
    }

    



    public ArrayList<SolutionOffer> getSo() {
        return so;
    }



    public void setSo(ArrayList<SolutionOffer> so) {
        this.so = so;
    }



    public ArrayList<MarketChannelAssignment> getMcas() {
        return mcas;
    }



    public void setMcas(ArrayList<MarketChannelAssignment> mcas) {
        this.mcas = mcas;
    }



    public String getChanneltypes() {
        return channeltypes;
    }



    public void setChanneltypes(String channeltypes) {
        this.channeltypes = channeltypes;
    }

    // test
    public void addMarketChannelAssignment(MarketChannelAssignment mca) {
        mcas.add(mca);
    }

     public String getDirectChannels() {
        return directChannels;
    }

    public void setDirectChannels(String directChannels) {
        this.directChannels = directChannels;
    }

    public String getIndirectChannels() {
        return indirectChannels;
    }

    public void setIndirectChannels(String indirectChannels) {
        this.indirectChannels = indirectChannels;
    }

   

    







}
