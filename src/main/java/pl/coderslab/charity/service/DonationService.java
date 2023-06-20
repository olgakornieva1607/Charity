package pl.coderslab.charity.service;


import pl.coderslab.charity.model.Donation;

public interface DonationService {

    Integer getTotalQuantity();

    Long getTotalDonations();

    void add(Donation donation);

}
