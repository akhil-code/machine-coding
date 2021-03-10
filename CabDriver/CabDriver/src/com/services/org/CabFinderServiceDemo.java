package com.services.org;

import com.services.org.model.UserRating;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Demo implementation for question in https://www.youtube.com/watch?v=Naf8KCy2lgM
 */
public class CabFinderServiceDemo {
    private final Map<String, UserRating> customersAverageRatings = new HashMap<>();
    private final Map<String, UserRating> driversAverageRatings =  new HashMap<>();
    private final Map<String, Set<String>> blackListerDriversForCustomer = new HashMap<>();
    private final RatingHandler ratingHandler = new RatingHandler(customersAverageRatings,
            driversAverageRatings, blackListerDriversForCustomer);
    private final CabFinderService cabFinderService = new CabFinderService(ratingHandler, customersAverageRatings,
            driversAverageRatings, blackListerDriversForCustomer);

    public void testCabFinderService() {
        System.out.println("Driver for Ram is " + cabFinderService.findDriver("Ram"));
        System.out.println("Driver for Laxman is " + cabFinderService.findDriver("Laxman"));
        System.out.println("Driver for Bharat is " + cabFinderService.findDriver("Bharat"));
    }

    private void storeInputData() {
        ratingHandler.storeRating("Ram", 3, "Bheem", 5);
        ratingHandler.storeRating("Laxman", 5, "Nakul", 2);
        ratingHandler.storeRating("Ram", 4, "Sahadev", 2);
        ratingHandler.storeRating("Bharat", 3, "Bheem", 5);
        ratingHandler.storeRating("Ram", 3, "Bheem", 1);
        ratingHandler.storeRating("Laxman", 5, "Sahadev", 3);
        ratingHandler.storeRating("Bharat", 5, "Nakul", 5);
    }

    private void printAverageData(Map<String, UserRating> ratingsMap) {
        ratingsMap.values().forEach(user ->
                System.out.println(String.format("name: %s -> rating: %s", user.getName(), user.getAverageRating())));
    }

    private void printDataInMemory() {
        this.printAverageData(customersAverageRatings);
        this.printAverageData(driversAverageRatings);
    }

    public static void main(String[] args) {
        final CabFinderServiceDemo demoService = new CabFinderServiceDemo();
        demoService.storeInputData();
        demoService.printDataInMemory();
        demoService.testCabFinderService();
    }

}
