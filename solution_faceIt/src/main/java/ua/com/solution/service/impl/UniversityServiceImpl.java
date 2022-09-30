package ua.com.solution.service.impl;

import ua.com.solution.persistence.entity.University;
import ua.com.solution.persistence.repository.UniversityRepository;
import ua.com.solution.service.UniversityService;

import java.util.List;

public class UniversityServiceImpl implements UniversityService {

    private UniversityRepository universityRepository;

    @Override
    public void saveAll(List<University> listUniversities) {
        if (listUniversities.size() > 0) {
            universityRepository.saveAll(listUniversities);
        }
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }
}