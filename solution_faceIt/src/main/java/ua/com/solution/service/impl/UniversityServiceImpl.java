package ua.com.solution.service.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.hibernate.hql.internal.ast.ParseErrorHandler;
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
        universityRepository.saveAll(Parser.returnListEntity(file));
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }
}