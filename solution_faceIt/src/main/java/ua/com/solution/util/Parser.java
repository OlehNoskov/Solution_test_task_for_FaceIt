package ua.com.solution.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.web.multipart.MultipartFile;
import ua.com.solution.persistence.entity.University;

import java.io.*;
import java.util.List;

public class Parser {
   public static List <University> returnListEntity(MultipartFile file){
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

                return listUniversities.readAll();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}