package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService{

    private final DonationRepository donationRepository;

    @Override
    public Integer getTotalQuantity() {
        return donationRepository.countTotalQuantity();
    }

    @Override
    public Long getTotalDonations() {
        return donationRepository.count();
    }

    @Override
    public void add(Donation donation) {
        donationRepository.save(donation);
    }

}
