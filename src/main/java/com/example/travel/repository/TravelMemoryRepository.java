package com.example.travel.repository;

import com.example.travel.model.Travel;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TravelMemoryRepository implements TravelRepository {

    private List<Travel> travels = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void save(Travel travel) {
        travel.setId(nextId);
        nextId++;
        travels.add(travel);
    }
    @Override
    public List<Travel> findAll() {
        return travels;
    }

    public Travel findById(int id) {
        for (Travel travel : travels) {
            if(travel.getId() == id) {
                return travel;
            }
        }
        return null;
    }

    @Override
    public void update(Travel travel) {

        Travel existingTravel = findById(travel.getId());
        existingTravel.setCost(travel.getCost());
        existingTravel.setTravelDate(travel.getTravelDate());
        existingTravel.setDestination(travel.getDestination());
        existingTravel.setRating(travel.getRating());
        existingTravel.setMemo(travel.getMemo());
    }

    @Override
    public void delete(int id) {
        Iterator<Travel> iterator = travels.iterator();

        while (iterator.hasNext()) {
            Travel travel = iterator.next();

            if (travel.getId() == id) {
                iterator.remove();
            }
        }
    }

}
