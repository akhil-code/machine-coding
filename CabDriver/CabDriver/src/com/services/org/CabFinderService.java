package com.services.org;

import com.services.org.model.UserRating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service responsible for finding rides for customers.
 */
public class CabFinderService {

    private final RatingHandler ratingHandler;
    final Map<String, UserRating> customersAverageRatings;
    final Map<String, UserRating> driversAverageRatings;
    final Map<String, Set<String>> blackListerDriversForCustomer;

    public CabFinderService(final RatingHandler ratingHandler,
                            Map<String, UserRating> customersAverageRatings,
                            Map<String, UserRating> driversAverageRatings,
                            Map<String, Set<String>> blackListerDriversForCustomer) {
        this.ratingHandler = ratingHandler;
        this.customersAverageRatings = customersAverageRatings;
        this.driversAverageRatings = driversAverageRatings;
        this.blackListerDriversForCustomer = blackListerDriversForCustomer;
    }

    /**
     * finds cab driver for a given customer.
     *
     * @param customerName name of the customer.
     * @return
     */
    public String findDriver(final String customerName) {
        // handle new customer case
        final double customerAverageRating = customersAverageRatings.get(customerName).getAverageRating();
        final List<UserRating> sortedDriverRatings = new ArrayList<>(driversAverageRatings.values());
        Collections.sort(sortedDriverRatings);
        for (UserRating driver : sortedDriverRatings) {
            if (driver.getAverageRating() > customerAverageRating
                    && !blackListerDriversForCustomer.get(customerName).contains(driver.getName())) {
                return driver.getName();
            }
        }
        System.out.println("Driver with good rating not found. Falling back to default driver");
        return sortedDriverRatings.get(sortedDriverRatings.size() - 1).getName();
    }

}
