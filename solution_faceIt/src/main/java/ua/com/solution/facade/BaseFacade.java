package ua.com.solution.facade;

import ua.com.solution.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseFacade <ENTITY extends BaseEntity> {
    void saveAll(List<ENTITY> entity);

    List<ENTITY> findAll();
}