package com.bridgelabz;

import java.util.List;

public class NormalRides implements CABServiceType {
    @Override
    public Invoice serviceTypeInvoice(List<Ride> rideList) {
        CabInvoice cabInvoice = new CabInvoice();
        return cabInvoice.listofRidesInvoice(rideList);
    }
}
