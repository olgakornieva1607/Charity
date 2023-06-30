package pl.coderslab.charity.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{

    private final InstitutionRepository institutionRepository;

    @Override
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public void add(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public Institution get(Long id) {
        Optional<Institution> foundInstitution = institutionRepository.findById(id);
        return foundInstitution.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void update(Institution institution) {
        institutionRepository.save(institution);
    }
}
