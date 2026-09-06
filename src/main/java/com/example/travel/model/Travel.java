package com.example.travel.model;
import java.time.LocalDate;

public class Travel {
    private int id;
    private String destination;
    private LocalDate travelDate;
    private int cost;
    private double rating;
    private String memo;

    public void setId(int id) {
        this.id = id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Travel(int id, String destination, LocalDate travelDate, int cost, double rating, String memo) {
        this.id = id;
        this.destination = destination;
        this.travelDate = travelDate;
        this.cost = cost;
        this.rating = rating;
        this.memo = memo;
    }


    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public int getCost() {
        return cost;
    }

    public double getRating() {
        return rating;
    }

    public String getMemo() {
        return memo;
    }

    @Override
    public String toString() {
        return "여행 ID: " + id +
                ", 여행지: " + destination +
                ", 여행 날짜: " + travelDate +
                ", 비용: " + cost +
                ", 평점: " + rating +
                ", 메모: " + memo;
    }
}
