package com.bridgelabz;

import java.util.List;

public class PremiumRides implements CABServiceType {

    final static double COST_PER_KILOMETER = 15;
    final static double COST_PER_MINUTE = 2;
    final static double MIN_FARE = 20;
    @Override
    public Invoice serviceTypeInvoice(List<Ride> rideList) {
        int totalRides = rideList.size();
        double totalFare = cabInvoiceAggregateFareList(rideList);
        double aggregate = totalFare / totalRides;
        return new Invoice(totalRides, totalFare, aggregate);
    }

    private double cabInvoiceAggregateFareList(List<Ride> rideList) {
        double totalFare = 0;
        for (Ride ride : rideList) {
            double fare = cabInvoice(ride.getDistance(), ride.getTime());
            totalFare += fare;
        }
        return totalFare;
    }

    private double cabInvoice(double distance, double time) {
        double fare = COST_PER_KILOMETER * distance + COST_PER_MINUTE * time;
        return fare < 20 ? 20 : fare;
    }
}
