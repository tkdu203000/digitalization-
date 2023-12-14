/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {
    ArrayList<Channel> channels;

    public ChannelCatalog() {
        channels = new ArrayList<Channel>();
    }

    public Channel newChannel(String channeltypes  ) {
        Channel channel = new Channel(channeltypes);
        channels.add(channel);
        return channel;
    }
    

    public Channel newChannel(String rct, String rdc, String ric  ) {
        Channel channel = new Channel(rct, rdc, ric);
        channels.add(channel);
        return channel;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        this.channels = channels;
    }

    public Channel getRandomChannel() {
        Random random = new Random();
        int randomIndex = random.nextInt(channels.size());
        return channels.get(randomIndex);
    }






}
