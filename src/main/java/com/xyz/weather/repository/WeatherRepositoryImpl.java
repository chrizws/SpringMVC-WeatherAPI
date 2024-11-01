package com.xyz.weather.repository;

import com.xyz.weather.model.Weather;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Transactional
public class WeatherRepositoryImpl implements WeatherRepository {

    private final EntityManager entityManager;

    @Autowired
    public WeatherRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Weather saveWeather(Weather weather) {

            entityManager.getTransaction().begin();
            entityManager.persist(weather);
            entityManager.getTransaction().commit();
            return weather;

    }

    @Override
    public List<Weather> getAllWeather() {

            List<Weather> weatherList = entityManager.createQuery("select e from Weather e", Weather.class).getResultList();
            return weatherList;
    }

    @Override
    public Weather getWeatherById(String id) {

            Weather weather = entityManager.find(Weather.class, id);
            return weather;

    }

    @Override
    public boolean deleteWeatherById(String id) {

            entityManager.getTransaction().begin();
            int returnVal = entityManager.createQuery("delete from Weather where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();

            if (returnVal == 0) {
                throw new OptimisticLockException("Cannot remove due to concurrent modification");
            } else {
                return true;
            }

    }
}
