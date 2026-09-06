package com.example.travel.service;

import com.example.travel.model.Travel;
import com.example.travel.repository.TravelRepository;
import java.util.List;

public class TravelService {
    private final TravelRepository repository;

    public TravelService(TravelRepository repository) {
        this.repository = repository;
    }

    public void addTravel(Travel travel) {
        if(travel.getDestination() == null || travel.getDestination().isEmpty())  {
            throw new IllegalArgumentException("목적지를 입력해주세요.");
        }
        if(travel.getCost() < 0) {
            throw new IllegalArgumentException("비용이 0원 이상이어야 합니다.");
        }
        if(travel.getRating() < 0 || travel.getRating() > 5) {
            throw new IllegalArgumentException("평점은 0~5점 사이어야 합니다.");
        }
        if(travel.getTravelDate() == null) {
            throw new IllegalArgumentException("여행 날짜를 입력해주세요.");
        }
        repository.save(travel);
    }
    public List<Travel> getAllTravels() {
        return repository.findAll();
    }

    public Travel getTravelById(int id) {
        return repository.findById(id);
    }

    public void updateTravel(Travel travel) {
        Travel existingTravel = repository.findById(travel.getId());
        if(existingTravel == null) {
            throw new IllegalArgumentException("해당 여행이 존재하지 않습니다.");
        }
        repository.update(travel);
    }
    public void deleteTravel(int id) {
        Travel existingTravel = repository.findById(id);
        if(existingTravel == null) throw new IllegalArgumentException("해당 여행이 존재하지 않습니다.");
        repository.delete(id);
    }
}
