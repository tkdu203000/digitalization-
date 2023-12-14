/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.SolutionOrder.SolutionsOfferOrderItem;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    ArrayList<SolutionsOfferOrderItem> solutionsOfferOrderItems;
    SolutionOfferCatalog solutionOfferCatalog;
    private int price;// floor, ceiling, and target ideas
    private int quantity;
    MarketChannelAssignment mca;
    private String name;

    private Market market;
    private String channelType;

    private int targetPrice;
    private int floorPrice;
    private int ceilingPrice;

    public SolutionOffer(MarketChannelAssignment m) {
        mca = m;
        products = new ArrayList<Product>();

    }

    public SolutionOffer(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        solutionsOfferOrderItems = new ArrayList<SolutionsOfferOrderItem>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void setPrice(int p) {
        price = p;

    }

    public SolutionOffer(Product p, int price, int quantity) {
        this.products = new ArrayList<Product>();
        this.products.add(p);
        this.price = price;
        this.quantity = quantity;
        solutionsOfferOrderItems = new ArrayList<SolutionsOfferOrderItem>();

    }

    public SolutionOffer(String name) {
        this.name = name;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    // revenue for the solution offer
    public int getSolutionOfferPricePerformance() {
        int sum = 0;
        for (SolutionsOfferOrderItem sooi : solutionsOfferOrderItems) {
            sum = sum + sooi.calculatePricePerformance(); // positive and negative values
        }
        return sum;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public int getSolutionOfferTotal() {
        int sum = 0;
        for (SolutionsOfferOrderItem sooi : solutionsOfferOrderItems) {
            sum = sum + sooi.getSolutionsOfferOrderItemTotal(); // positive and negative values
        }
        return sum;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

    public Product getProduct() {
        return products.get(0);
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void addSolutionOfferOrderItem(SolutionsOfferOrderItem solutionsOfferOrderItem) {
        solutionsOfferOrderItems.add(solutionsOfferOrderItem);

    }

    public SolutionsOfferOrderItem pickRandoSolutionsOfferOrderItem() {
        int randomIndex = (int) (Math.random() * solutionsOfferOrderItems.size());
        return solutionsOfferOrderItems.get(randomIndex);
    }

    // public void suggestYoungTrendBundles() {
    // // Suggest bundled solutions for Young Trend Setter Type
    // String[] youngTrendBundledSolutions = {
    // "Bundled Solution 1: Trendy Laptop + Trendy Accessories A",
    // "Bundled Solution 3: Stylish Tablet + Trendy Accessories B",
    // "Bundled Solution 5: Fashionable Smartwatch + Trendy Accessories C",
    // "Bundled Solution 6: High-Performance Smartphone + Trendy Accessories D",
    // "Bundled Solution 8: Cutting-edge Headphones + Trendy Accessories E",
    // "Bundled Solution 11: Trendy Camera + Trendy Accessories F"
    // };
    // double[] pricesInDollar = { 1800.0, 1200.0, 1000.0, 1500.0, 1300.0, 2000.0 };

    // String[] advertisements = {
    // "Boost your productivity with the sleek Trendy Laptop and a collection of
    // Trendy Accessories A.",
    // "Unleash your creativity with the stylish Trendy Tablet and a set of Trendy
    // Accessories B.",
    // "Stay connected and in style with the fashionable Trendy Smartwatch and
    // Trendy Accessories C.",
    // "Experience the power of innovation with the high-performance Trendy
    // Smartphone and Trendy Accessories D.",
    // "Immerse yourself in premium audio quality with the cutting-edge Trendy
    // Headphones and Trendy Accessories E.",
    // "Capture every moment with the advanced Trendy Camera and a bundle of Trendy
    // Accessories F."
    // };

    // // Print the suggested bundled solutions for Young Trend Setter Type
    // System.out.println();
    // System.out.println("Suggested Young Trend Setter Type Bundled Solutions:");
    // System.out.println();
    // for (int i = 0; i < youngTrendBundledSolutions.length; i++) {
    // System.out.println(youngTrendBundledSolutions[i] + " - Price: $" +
    // pricesInDollar[i]);
    // System.out.println("Ads: " + advertisements[i]);
    // System.out.println();
    // }
    // }

    // type start
    public void suggestStudentTypeBundledSolutions() {
        // Suggest bundled solutions for Comfort Type
        String[] StudentTypeBundledSolutions = {
                "Bundled Solution 1: Apple iphone 13 + AppleCare X",
                "Bundled Solution 3: Apple iphone 14 + Apple One Z",
                "Bundled Solution 5: Apple iphone 14 + Apple Music",
                "Bundled Solution 6: Apple iphone 15 + Apple Arcade",
                "Bundled Solution 8: Apple iphone SE3 + Apple Fitness",
                "Bundled Solution 11: Apple iphone 13 + Apple Podcasts"
        };
        double[] pricesInDollar = { 1000.0, 1200.0, 800.0, 1200.0, 1400.0, 1800.0 };

        String[] advertisements = {
                "Experience the power of creativity with the sleek Apple Mac 13, now with extended AppleCare support!",
                "Unlock new possibilities with the versatile Apple iPad C and the all-in-one Apple One Z subscription.",
                "Stay active and entertained with the Apple Watch E and a harmonious blend of Apple Music.",
                "Immerse yourself in the world of gaming and productivity with the Apple iPhone F and Apple Arcade.",
                "Achieve your fitness goals and stay connected with the Apple iPhone SE3 and Apple Fitness.",
                "Unleash the potential of multimedia with the advanced Apple iPhone 13 and Apple Podcasts."
        };

        // Print the suggested bundled solutions for Comfort Type
        System.out.println();
        System.out.println("Suggested StudentTypeBundledSolutions :");
        System.out.println();
        for (int i = 0; i < StudentTypeBundledSolutions.length; i++) {
            System.out.println(StudentTypeBundledSolutions[i] + " - Price: $" + pricesInDollar[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }

    }

    public void suggestStudentTypeBundledSolutions2() {
        // Suggest bundled solutions for Comfort Type
        String[] StudentTypeBundledSolutions = {
                "Gebündelte Lösung 1: Apple iphone 13 + AppleCare X",
                "Gebündelte Lösung 3: Apple iphone 14 + Apple One Z",
                "Gebündelte Lösung 5: Apple iphone 14 + Apple Music",
                "Gebündelte Lösung 6: Apple iphone 15 + Apple Arcade",
                "Gebündelte Lösung 8: Apple iPhone SE3 + Apple Fitness",
                "Gebündelte Lösung 11: Apple iPhone 13 + Apple Podcasts"
        };
        double[] pricesInEuro = { 700.0, 1000.0, 600.0, 1000.0, 1200.0, 1500.0 };

        String[] advertisements = {
                "Erleben Sie die Kraft der Kreativität mit dem eleganten Apple Mac 13, jetzt mit erweitertem AppleCare-Support!",
                "Entdecken Sie neue Möglichkeiten mit dem vielseitigen Apple iPad C und dem All-in-One Apple One Z-Abonnement.",
                "Bleiben Sie aktiv und unterhalten Sie sich mit der Apple Watch E und einer harmonischen Mischung aus Apple Music.",
                "Tauchen Sie ein in die Welt des Spielens und der Produktivität mit dem Apple iPhone F und Apple Arcade.",
                "Erreichen Sie Ihre Fitnessziele und bleiben Sie verbunden mit dem Apple iPhone SE3 und Apple Fitness.",
                "Entfesseln Sie das Potenzial von Multimedia mit dem fortschrittlichen Apple iPhone 13 und Apple Podcasts."
        };

        System.out.println();
        System.out.println("Suggested Student Type BundledSolutions:");
        System.out.println();
        for (int i = 0; i < StudentTypeBundledSolutions.length; i++) {
            System.out.println(StudentTypeBundledSolutions[i] + " - Price: €" + pricesInEuro[i]);
            System.out.println("Ads: " + advertisements[i]);
        }
    }

    public void suggestGeneralDirectTypeBundledSolutions() {
        // Suggest bundled solutions for middle income Type
        String[] GeneralDirectTypeBundledSolutions = {
                "Bundled Solution 1: Apple iPhone SE3+ Apple Fitness",
                "Bundled Solution 3: Apple iPhone 15+Apple Music",
                "Bundled Solution 5: Apple iPhone 15 Pro+Apple Arcade",
                "Bundled Solution 6: Apple iPhone 15+ Apple Care+",
                "Bundled Solution 8: Apple  iPhone SE3+Apple TV+",
                "Bundled Solution 11: Apple iPhone 15 + Apple Podcasts+"
        };
        double[] pricesInDollar = { 1699.99, 1999.99, 2399.99, 2699.99, 1799.99, 1899.99 };

        String[] advertisements = {
                "Elevate your fitness journey with the Apple iPhone SE3 bundle. Unleash the full potential of your workouts with Apple Fitness+. Your path to a healthier you starts here.",
                "Indulge your senses with the iPhone 15 bundle. Immerse yourself in a world of sound with Apple Music. Elevate every moment with the perfect soundtrack.",
                "Level up your gaming experience with the iPhone 15 Pro bundle. Dive into a realm of endless adventures with Apple Arcade. Your next gaming saga awaits.",
                "Protect your investment with the iPhone 15 bundle. Enjoy peace of mind with Apple Care+. Unmatched performance meets unmatched care.",
                "Entertainment at your fingertips with the iPhone SE3 bundle. Immerse yourself in captivating shows and movies with Apple TV+. Elevate your downtime.",
                "Dive into a world of exclusive content with the iPhone 15 bundle. Enjoy premium podcasts with Apple Podcasts+. Elevate your listening experience."
        };

        System.out.println("Suggested General Direct Type Bundled Solutions with dollars Prices and Advertisements:");
        for (int i = 0; i < GeneralDirectTypeBundledSolutions.length; i++) {
            System.out.println(GeneralDirectTypeBundledSolutions[i] + " - Price: $" + pricesInDollar[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }
    }

    public void suggestGeneralDirectTypeBundledSolutions2() {
        // Suggest bundled solutions for middle income Type
        String[] GeneralDirectTypeBundledSolutions = {
                "Gebündelte Lösung 1: Apple iPhone SE3 + Apple Fitness",
                "Gebündelte Lösung 3: Apple iPhone 15 + Apple Music",
                "Gebündelte Lösung 5: Apple iPhone 15 Pro + Apple Arcade",
                "Gebündelte Lösung 6: Apple iPhone 15 + Apple Care+",
                "Gebündelte Lösung 8: Apple iPhone SE3 + Apple TV+",
                "Gebündelte Lösung 11: Apple iPhone 15 + Apple Podcasts+"
        };
        double[] pricesInEuro = { 1499.99, 999.99, 2099.99, 2399.99, 1499.99, 1599.99 };

        String[] advertisements = {
                "Steigern Sie Ihre Fitnessreise mit dem Apple iPhone SE3 Bundle. Entfesseln Sie das volle Potenzial Ihrer Workouts mit Apple Fitness+. Ihr Weg zu einem gesünderen Lebensstil beginnt hier.",
                "Verwöhnen Sie Ihre Sinne mit dem iPhone 15 Bundle. Tauchen Sie ein in eine Klangwelt mit Apple Music. Heben Sie jeden Moment mit dem perfekten Soundtrack hervor.",
                "Verbessern Sie Ihr Spielerlebnis mit dem iPhone 15 Pro Bundle. Tauchen Sie ein in eine Welt endloser Abenteuer mit Apple Arcade. Ihre nächste Gaming-Saga erwartet Sie.",
                "Schützen Sie Ihre Investition mit dem iPhone 15 Bundle. Genießen Sie sorgenfreie Momente mit Apple Care+. Unerreichte Leistung trifft auf unübertroffene Pflege.",
                "Unterhaltung direkt zur Hand mit dem iPhone SE3 Bundle. Tauchen Sie ein in fesselnde Shows und Filme mit Apple TV+. Steigern Sie Ihre Freizeit.",
                "Tauchen Sie ein in eine Welt exklusiven Inhalts mit dem iPhone 15 Bundle. Genießen Sie Premium-Podcasts mit Apple Podcasts+. Steigern Sie Ihr Hörerlebnis."
        };

        System.out.println("Empfohlene General-Bundle-Lösungen mit Dollar-Preisen und Anzeigen:");
        for (int i = 0; i < GeneralDirectTypeBundledSolutions.length; i++) {
            System.out.println(GeneralDirectTypeBundledSolutions[i] + " - Price: €" + pricesInEuro[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }
    }

    public void suggestGeneralInDirectTypeBundledSolutions() {
        // Suggest bundled solutions for middle income Type
        String[] GeneralInDirectTypeBundledSolutions = {
                "Bundled Solution 1: Apple iPhone SE3+ Apple Fitness",
                "Bundled Solution 3: Apple iPhone 15+Apple Music",
                "Bundled Solution 5: Apple iPhone 15 Pro+Apple Arcade",
                "Bundled Solution 6: Apple iPhone 15+ Apple Care+",
                "Bundled Solution 8: Apple  iPhone SE3+Apple TV+",
                "Bundled Solution 11: Apple iPhone 15 + Apple Podcasts+"
        };
        double[] pricesInDollar = { 1399.99, 1799.99, 2099.99, 2399.99, 1399.99, 1599.99 };

        String[] advertisements = {
                "Embark on a fitness journey with the Apple iPhone SE3 bundle. Transform your workouts with Apple Fitness+ and embark on a path to a healthier you.",
                "Savor the iPhone 15 bundle experience. Immerse yourself in a symphony of sound with Apple Music, adding the perfect soundtrack to elevate every moment.",
                "Take your gaming to new heights with the iPhone 15 Pro bundle. Immerse yourself in a world of endless adventures through Apple Arcade—your next gaming saga awaits.",
                "Safeguard your investment with the iPhone 15 bundle. Find peace of mind with Apple Care+ as unmatched performance meets unparalleled care.",
                "Unlock entertainment with the iPhone SE3 bundle. Immerse yourself in captivating shows and movies with Apple TV+, bringing a touch of magic to your downtime.",
                "Explore exclusive content with the iPhone 15 bundle. Delve into premium podcasts with Apple Podcasts+, elevating your listening experience to new heights."
        };

        System.out.println("Suggested General InDirect Type Bundled Solutions with dollars Prices and Advertisements:");
        for (int i = 0; i < GeneralInDirectTypeBundledSolutions.length; i++) {
            System.out.println(GeneralInDirectTypeBundledSolutions[i] + " - Price: $" + pricesInDollar[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }
    }
    public void suggestGeneralInDirectTypeBundledSolutions2() {
        // Suggest bundled solutions for middle income Type
        String[] GeneralInDirectTypeBundledSolutions = {
                "Gebündelte Lösung 1: Apple iPhone SE3 + Apple Fitness",
                "Gebündelte Lösung 3: Apple iPhone 15 + Apple Music",
                "Gebündelte Lösung 5: Apple iPhone 15 Pro + Apple Arcade",
                "Gebündelte Lösung 6: Apple iPhone 15 + Apple Care+",
                "Gebündelte Lösung 8: Apple iPhone SE3 + Apple TV+",
                "Gebündelte Lösung 11: Apple iPhone 15 + Apple Podcasts+"
        };
        double[] pricesInEuro = { 1099.99, 1299.99, 1799.99, 2099.99, 1099.99, 1299.99 };

        String[] advertisements = {
                "Embark on a fitness journey with the Apple iPhone SE3 bundle. Transform your workouts with Apple Fitness+ and embark on a path to a healthier you.",
                "Savor the iPhone 15 bundle experience. Immerse yourself in a symphony of sound with Apple Music, adding the perfect soundtrack to elevate every moment.",
                "Take your gaming to new heights with the iPhone 15 Pro bundle. Immerse yourself in a world of endless adventures through Apple Arcade—your next gaming saga awaits.",
                "Safeguard your investment with the iPhone 15 bundle. Find peace of mind with Apple Care+ as unmatched performance meets unparalleled care.",
                "Unlock entertainment with the iPhone SE3 bundle. Immerse yourself in captivating shows and movies with Apple TV+, bringing a touch of magic to your downtime.",
                "Explore exclusive content with the iPhone 15 bundle. Delve into premium podcasts with Apple Podcasts+, elevating your listening experience to new heights."
        };

        System.out.println("Suggested General InDirect Type Bundled Solutions with dollars Prices and Advertisements:");
        for (int i = 0; i < GeneralInDirectTypeBundledSolutions.length; i++) {
            System.out.println(GeneralInDirectTypeBundledSolutions[i] + " - Price: $" + pricesInEuro[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }
    }


    public void suggestLoyaltyTypeBundledSolutions() {
        // Suggest bundled solutions for middle income Type
        String[] LoyaltyTypeBundledSolutions = {
                "Bundled Solution 1: Apple iphone Pro 15 + AppleCare Pro",
                "Bundled Solution 3: Apple iphone SE3 + Apple Fitness+",
                "Bundled Solution 5: Apple iphone 15 + Apple Music",
                "Bundled Solution 6: Apple iPhone 15 Pro + Apple Arcade",
                "Bundled Solution 8: Apple iPhone SE3 + Apple TV+",
                "Bundled Solution 11: Apple iPhone 15 + Apple Podcasts+"
        };
        double[] pricesInDollar = { 2999.99, 2199.99, 1899.99, 1799.99, 999.99, 2699.99 };

        String[] advertisements = {
                "Unleash the power of creativity with the stunning Apple Macbook Pro and comprehensive AppleCare Pro support.",
                "Achieve your fitness goals with the powerful Apple iPad Air and complimentary Apple Fitness+ subscription.",
                "Stay connected and entertained with the stylish Apple Watch Series 7 and a harmonious blend of Apple Music.",
                "Experience gaming like never before with the advanced Apple iPhone 13 Pro and access to an array of games on Apple Arcade.",
                "Enjoy premium content on-the-go with the compact Apple iPhone SE3 and a complimentary Apple TV+ subscription.",
                "Discover the future of mobile technology with the revolutionary Apple iPhone 14 and exclusive content on Apple Podcasts+."
        };

        System.out.println("Suggested Loyalty Type Bundled Solutions with dollars Prices and Advertisements:");
        for (int i = 0; i < LoyaltyTypeBundledSolutions.length; i++) {
            System.out.println(LoyaltyTypeBundledSolutions[i] + " - Price: $" + pricesInDollar[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }
    }

    public void suggestLoyaltyTypeBundledSolutions2() {

        String[] LoyaltyTypeBundledSolutions = {
                "Gebündelte Lösung 1: Apple iPhone Pro 15 + AppleCare Pro",
                "Gebündelte Lösung 3: Apple iPhone SE3 + Apple Fitness",
                "Gebündelte Lösung 5: Apple iPhone 15 + Apple Music",
                "Gebündelte Lösung 6: Apple iPhone 15 Pro + Apple Arcade",
                "Gebündelte Lösung 8: Apple iPhone SE3 + Apple TV",
                "Gebündelte Lösung 11: Apple iPhone 15 + Apple Podcasts"
        };
        double[] pricesInEuro = { 2549.99, 1869.99, 1614.99, 1529.99, 849.99, 2294.99 };

        String[] advertisements = {
                "Liberatez la puissance de la créativité avec le superbe Apple MacBook Pro et un support complet d'AppleCare Pro.",
                "Ateignez vos objectifs fitness avec la puissante Apple iPad Air et un abonnement gratuit à Apple Fitness+.",
                "Restez connecté et divertissez-vous avec la élégante Apple Watch Series 7 et une fusion harmonieuse d'Apple Music.",
                "Découvrez le jeu comme jamais auparavant avec l'Apple iPhone 13 Pro avancé et un accès à une multitude de jeux sur Apple Arcade.",
                "Profitez de contenus premium en déplacement avec le compact Apple iPhone SE3 et un abonnement gratuit à Apple TV+.",
                "Découvrez le futur de la technologie mobile avec le révolutionnaire Apple iPhone 14 et un contenu exclusif sur Apple Podcasts+."
        };

        System.out.println();
        System.out.println("<Empfohlene mittlere gebündelte Lösungen mit Euro-Preisen und Werbung:>");
        System.out.println();
        for (int i = 0; i < LoyaltyTypeBundledSolutions.length; i++) {
            System.out.println(LoyaltyTypeBundledSolutions[i] + " - Price: €" + pricesInEuro[i]);
            System.out.println("Ads: " + advertisements[i]);
            System.out.println();
        }
    }

    // public void suggestFamilyOrientedTypeBundledSolutions() {
    // // Suggest bundled solutions for Comfort Type
    // String[] familyOrientedTypeBundledSolutions = {
    // "Bundled Solution 1: Apple Mac 13 + AppleCare X",
    // "Bundled Solution 3: Apple ipad C + Apple One Z",
    // "Bundled Solution 5: Apple Watch E + Apple Music",
    // "Bundled Solution 6: Apple iphone F + Apple Arcade",
    // "Bundled Solution 8: Apple iphone SE3 + Apple Fitness",
    // "Bundled Solution 11: Apple iphone 13 + Apple Podcasts"
    // };

    // // Print the suggested bundled solutions for Comfort Type
    // System.out.println("Suggested familyOrientedTypeBundledSolutions:");
    // for (String solution : familyOrientedTypeBundledSolutions) {
    // System.out.println(solution);
    // }
    // }

    // public void suggestHealthConsciousmensTypeBundledSolutions() {
    // // Suggest bundled solutions for Comfort Type
    // String[] healthmensTypeBundledSolutions = {
    // "Bundled Solution 1: Apple Mac 13 + AppleCare X",
    // "Bundled Solution 3: Apple ipad C + Apple One Z",
    // "Bundled Solution 5: Apple Watch E + Apple Music",
    // "Bundled Solution 6: Apple iphone F + Apple Arcade",
    // "Bundled Solution 8: Apple iphone SE3 + Apple Fitness",
    // "Bundled Solution 11: Apple iphone 13 + Apple Podcasts"
    // };

    // // Print the suggested bundled solutions for Comfort Type
    // System.out.println("Suggested healthmensTypeBundledSolutions:");
    // for (String solution : healthmensTypeBundledSolutions) {
    // System.out.println(solution);
    // }
    // }

    // public void suggestBudgetConsciousGenerationTypeBundledSolutions() {
    // // Suggest bundled solutions for Uncomfort Type
    // String[] budgetTypeBundledSolutions = {
    // "Bundled Solution 2: Apple iphone XS B + iCloud Y",
    // "Bundled Solution 4: Apple Airpods D + Apple TV",
    // "Bundled Solution 7: Apple Mac 15 + Apple News",
    // "Bundled Solution 9: Apple iphone SE2 + Apple Card",
    // "Bundled Solution 10: Apple iphone 15 + Apple Books"
    // };

    // // Print the suggested bundled solutions for Uncomfort Type
    // System.out.println("Suggested budgetTypeBundledSolutions:");
    // for (String solution : budgetTypeBundledSolutions) {
    // System.out.println(solution);
    // }
    // }

    // public void suggestConvenienceDrivenWomenTypeBundledSolutions() {
    // // Suggest bundled solutions for Uncomfort Type
    // String[] convenienceWomenTypeBundledSolutions = {
    // "Bundled Solution 2: Apple iphone XS B + iCloud Y",
    // "Bundled Solution 4: Apple Airpods D + Apple TV",
    // "Bundled Solution 7: Apple Mac 15 + Apple News",
    // "Bundled Solution 9: Apple iphone SE2 + Apple Card",
    // "Bundled Solution 10: Apple iphone 15 + Apple Books"
    // };

    // // Print the suggested bundled solutions for Uncomfort Type
    // System.out.println("Suggested convenienceWomenTypeBundledSolutions:");
    // for (String solution : convenienceWomenTypeBundledSolutions) {
    // System.out.println(solution);
    // }
    // }

    // public void suggestGeneralTypeTypeBundledSolutions() {
    // // Suggest bundled solutions for Uncomfort Type
    // String[] generalTypeBundledSolutions = {
    // "Bundled Solution 2: Apple iphone XS B + iCloud Y",
    // "Bundled Solution 4: Apple Airpods D + Apple TV",
    // "Bundled Solution 7: Apple Mac 15 + Apple News",
    // "Bundled Solution 9: Apple iphone SE2 + Apple Card",
    // "Bundled Solution 10: Apple iphone 15 + Apple Books"
    // };

    // // Print the suggested bundled solutions for Uncomfort Type
    // System.out.println("Suggested generalTypeBundledSolutions:");
    // for (String solution : generalTypeBundledSolutions) {
    // System.out.println(solution);
    // }
    // }

}
