package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double aggregate;
    public Invoice(int totalRides, double totalFare, double aggregate) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.aggregate = aggregate;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public void setTotalRides(int totalRides) {
        this.totalRides = totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getAggregate() {
        return aggregate;
    }

    public void setAggregate(double aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.aggregate, aggregate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, aggregate);
    }
}
