package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideRepository {
    private String userId;
    private Ride ride;
    public RideRepository(){}

    public RideRepository(String userId, Ride ride) {
        this.userId = userId;
        this.ride = ride;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
    List<RideRepository> rideRepositories = new ArrayList<>();

    public void addRidesToRepository(){
        rideRepositories.add(new RideRepository("1", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("1", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("1", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("2", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("3", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("4", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("5", new Ride(5, 2)));
        rideRepositories.add(new RideRepository("7", new Ride(5, 2)));
    }
    public List<Ride> getRideForUser(String userId) {
        addRidesToRepository();
        List<Ride> list = new ArrayList<>();
        List<Ride> rideList= rideRepositories.stream().filter(p->p.getUserId().equalsIgnoreCase(userId)).map(p-> new Ride( p.getRide().getDistance(),p.getRide().getTime())).collect(Collectors.toList());
        return rideList;
    }
}
