package ua.com.solution.service;

import ua.com.solution.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseService<ENTITY extends BaseEntity> {
    void saveAll(List<ENTITY> entity);

    List<ENTITY> findAll();
}