package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> getAllInstitutions();

    void add(Institution institution);

    void delete(Long id);

    Institution get(Long id);

    void update(Institution institution);

}
