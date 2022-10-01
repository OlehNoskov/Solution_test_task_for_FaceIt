package ua.com.solution.facade;

import org.springframework.web.multipart.MultipartFile;
import ua.com.solution.persistence.entity.BaseEntity;
import java.util.List;

public interface BaseFacade <ENTITY extends BaseEntity> {
    void saveAll(MultipartFile file);

    List<ENTITY> findAll();
}