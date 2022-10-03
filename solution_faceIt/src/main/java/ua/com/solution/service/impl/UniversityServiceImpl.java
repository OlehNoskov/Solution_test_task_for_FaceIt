package ua.com.solution.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.solution.persistence.entity.University;
import ua.com.solution.persistence.repository.UniversityRepository;
import ua.com.solution.service.UniversityService;
import ua.com.solution.util.Parser;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public void saveAll(MultipartFile file) {
        universityRepository.saveAll(Parser.returnListUniversities(file));
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }
}