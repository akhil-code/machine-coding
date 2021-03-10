package com.services.org;

import com.services.org.model.UserRating;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Service responsible for handling ratings of customers and drivers.
 */
public class RatingHandler {

    final Map<String, UserRating> customersAverageRatings;
    final Map<String, UserRating> driversAverageRatings;
    final Map<String, Set<String>> blackListerDriversForCustomer;

    public RatingHandler(Map<String, UserRating> customersAverageRatings,
                         Map<String, UserRating> driversAverageRatings,
                         Map<String, Set<String>> blackListerDriversForCustomer) {
        this.customersAverageRatings = customersAverageRatings;
        this.driversAverageRatings = driversAverageRatings;
        this.blackListerDriversForCustomer = blackListerDriversForCustomer;
    }

    /**
     * Persists ratings for the completed rides.
     *
     * @param customerName name of customer
     * @param customerRating rating provided to ride taker
     * @param driverName name of driver
     * @param driverRating rating provided to driver by customer.
     */
    public void storeRating(final String customerName,
                            final Integer customerRating,
                            final String driverName,
                            final Integer driverRating) {
        // store customer average rating
        addUserRating(customersAverageRatings, customerName, customerRating);
        // store driver rating
        addUserRating(driversAverageRatings, driverName, driverRating);
        // Store blacklisted drivers
        if (customerRating == 1 || driverRating == 1) {
            blackListCustomerDriverPair(blackListerDriversForCustomer, customerName, driverName);
        }
    }

    /**
     * adds user rating to the map.
     *
     * @param ratingsMap map holding the data.
     * @param name name of the user.
     * @param rating rating received by the user.
     */
    private void addUserRating(final Map<String, UserRating> ratingsMap, final String name, final Integer rating) {
        final UserRating currentUserRating;
        if (ratingsMap.containsKey(name)) {
            currentUserRating = ratingsMap.get(name);
        } else {
            currentUserRating = new UserRating(name);
            ratingsMap.put(name, currentUserRating);
        }
        currentUserRating.addRating(rating);
    }


    /**
     * Stores the blacklisted pairs for customer and driver.
     *
     * @param blackListMap
     * @param customerName
     * @param driverName
     */
    private void blackListCustomerDriverPair(final Map<String, Set<String>> blackListMap,
                                             final String customerName,
                                             final String driverName) {
        if (blackListMap.containsKey(customerName)) {
            final Set<String> blackListedDrivers = blackListMap.get(customerName);
            blackListedDrivers.add(driverName);
        } else {
            blackListMap.put(customerName, new HashSet<>(Collections.singletonList(driverName)));
        }
    }
}
