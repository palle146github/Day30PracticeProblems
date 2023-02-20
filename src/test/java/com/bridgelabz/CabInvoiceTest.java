package com.bridgelabz;
import com.bridgelabz.check.RideRepository1;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CabInvoiceTest {

    @Test
    public void whenDistanceandTimeGivenShouldReturnFare() {
        CabInvoice invoice = new CabInvoice();
        double fare = invoice.cabInvoice(5, 2);
        Assert.assertEquals(52, fare,0.0);
    }

    @Test
    public void whenMultipleRidesGivenShouldReturnAggreagateFare(){
        CabInvoice invoice = new CabInvoice();
        Ride[] rides = {new Ride(5,2),new Ride(5,2),new Ride(5,2)};
        double totalFare = invoice.cabInvoiceAggregateFare(rides);
        Assert.assertEquals(156,totalFare,0.0);

    }

    @Test
    public void whenMultilpleRidesGivenShouldReturnInvoice(){
        CabInvoice invoice = new CabInvoice();
        Ride[] rides = {new Ride(5,2),new Ride(5,2),new Ride(5,2)};
        Invoice actual = invoice.invoice(rides);
        Invoice expected = new Invoice(3,156,156/3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void whenUserIdGivenShouldReturnInvoice(){
        RideRepository rideRepository = new RideRepository();
        String userId = "2";
        List<Ride> rideList = rideRepository.getRideForUser(userId);
        CabInvoice invoice = new CabInvoice();
        Invoice actual = invoice.listofRidesInvoice(rideList);
        Invoice expected = new Invoice(1,52,52);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void whenUserIdAndServiceTpyeGivenShouldReturnInvoice(){
        RideRepository rideRepository = new RideRepository();
        String userId = "2";
        List<Ride> rideList = rideRepository.getRideForUser(userId);
        CabInvoice invoice = new CabInvoice();
        Invoice actual = invoice.invoiceSeriveType(CABService.PREMIUM_RIDES, rideList);
        Invoice expected = new Invoice(1,79,79);
        Assert.assertEquals(expected,actual);
    }
}
