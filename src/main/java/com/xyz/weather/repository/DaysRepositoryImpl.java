package com.xyz.weather.repository;

import com.xyz.weather.model.Day;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DaysRepositoryImpl implements DaysRepository {

    private final EntityManager entityManager;

    public DaysRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Day day) {
        entityManager.persist(day);
    }
}
