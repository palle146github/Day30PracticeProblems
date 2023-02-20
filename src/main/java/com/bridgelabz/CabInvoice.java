package com.bridgelabz;

import java.util.List;

public class CabInvoice {
    final static double COST_PER_KILOMETER = 10;
    final static double COST_PER_MINUTE = 1;
    final static double MIN_FARE = 5;

    public double cabInvoice(double distance, double time) {
        double fare = COST_PER_KILOMETER * distance + COST_PER_MINUTE * time;
        return fare < 5 ? 5 : fare;
    }

    public double cabInvoiceAggregateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            double fare = cabInvoice(ride.getDistance(), ride.getTime());
            totalFare += fare;
        }
        return totalFare;
    }

    public Invoice invoice(Ride[] rides) {
        int totalRides = rides.length;
        double totalFare = cabInvoiceAggregateFare(rides);
        double aggregate = totalFare / totalRides;

        return new Invoice(totalRides, totalFare, aggregate);
    }

    public Invoice listofRidesInvoice(List<Ride> rideList) {
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


    public Invoice invoiceSeriveType(CABService serviceType, List<Ride> rideList) {
        CABServiceType cabServiceType;
        if(CABService.PREMIUM_RIDES.equals(serviceType)){
            cabServiceType = new PremiumRides();
        }
        else{
            cabServiceType = new NormalRides();
        }
        return cabServiceType.serviceTypeInvoice(rideList);
    }
}
