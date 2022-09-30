package ua.com.solution.facade.impl;

import ua.com.solution.facade.UniversityFacade;
import ua.com.solution.persistence.entity.University;
import ua.com.solution.service.UniversityService;

import java.util.List;

public class UniversityFacadeImpl implements UniversityFacade {
    private UniversityService universityService;

    @Override
    public void saveAll(List<University> listUniversities) {
        universityService.saveAll(listUniversities);
    }

    @Override
    public List<University> findAll() {
        return universityService.findAll();
    }
}