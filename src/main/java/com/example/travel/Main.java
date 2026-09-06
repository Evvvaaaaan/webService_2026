package com.example.travel;

import com.example.travel.repository.TravelMemoryRepository;
import com.example.travel.repository.TravelRepository;
import com.example.travel.service.TravelService;
import com.example.travel.view.ConsoleView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TravelRepository repository = new TravelMemoryRepository();
        TravelService service = new TravelService(repository);
        ConsoleView view = new ConsoleView(service);
        view.start();
    }
}