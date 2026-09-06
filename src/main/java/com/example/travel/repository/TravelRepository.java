package com.example.travel.repository;

import com.example.travel.model.Travel;
import java.util.List;

public interface TravelRepository {

    void save(Travel travel);

    List<Travel> findAll();

    Travel findById(int id);

    void update(Travel travel);

    void delete(int id);
}

