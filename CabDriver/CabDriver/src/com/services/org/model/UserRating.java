package com.services.org.model;

/**
 * Model class to store rating of a user.
 */
public class UserRating implements Comparable<UserRating> {
    /** Name of the person */
    private final String name;
    /** Average rating of the person */
    private double averageRating;
    /** Total rides taken */
    private Integer totalRides;
    /** Total rating */
    private Integer totalRating;

    public UserRating(final String name) {
        this.name = name;
        this.averageRating = 0.0;
        this.totalRides = 0;
        this.totalRating = 0;
    }

    public void addRating(final Integer newRating) {
        totalRides++;
        totalRating += newRating;
        averageRating = (float) totalRating / totalRides;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(UserRating o) {
        if (this.getAverageRating() == o.getAverageRating()) {
            return  0;
        } else if (this.getAverageRating() > o.getAverageRating()) {
            return 1;
        } else {
            return -1;
        }
    }
}
