package ua.com.solution.service.impl;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.solution.persistence.entity.University;
import ua.com.solution.persistence.repository.UniversityRepository;
import ua.com.solution.service.UniversityService;

import java.io.*;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public void saveAll(MultipartFile file) {
        try {
            InputStream initialStream = file.getInputStream();
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
            File tempFile = File.createTempFile("data", ".csv");

            try (OutputStream outStream = new FileOutputStream(tempFile)) {
                outStream.write(buffer);
                CsvMapper csvMapper = new CsvMapper();

                CsvSchema csvSchema = csvMapper
                        .typedSchemaFor(University.class)
                        .withHeader()
                        .withColumnSeparator(';')
                        .withComments();

                MappingIterator<University> listUniversities = csvMapper
                        .readerWithTypedSchemaFor(University.class)
                        .with(csvSchema)
                        .readValues(tempFile);

                universityRepository.saveAll(listUniversities.readAll());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }
}