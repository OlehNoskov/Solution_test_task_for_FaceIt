package ua.com.solution.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ua.com.solution.persistence.entity.BaseEntity;

@NoRepositoryBean
public interface AbstractRepository <E extends BaseEntity> extends JpaRepository<E, Long> {
}