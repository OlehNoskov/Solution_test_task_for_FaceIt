package ua.com.solution.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.solution.facade.UniversityFacade;
import ua.com.solution.persistence.entity.University;
import ua.com.solution.service.UniversityService;

import java.util.List;


@Service
public class UniversityFacadeImpl implements UniversityFacade {
    private final UniversityService universityService;

    public UniversityFacadeImpl(UniversityService universityService) {
        this.universityService = universityService;
    }

    @Override
    public void saveAll(MultipartFile file) {
        universityService.saveAll(file);
    }

    @Override
    public List<University> findAll() {
        return universityService.findAll();
    }
}