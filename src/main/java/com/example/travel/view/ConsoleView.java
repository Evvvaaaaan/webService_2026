package com.example.travel.view;
import com.example.travel.repository.TravelRepository;
import com.example.travel.service.TravelService;

import com.example.travel.model.Travel;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final TravelService service;
    private final Scanner scanner;

    public ConsoleView(TravelService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("===== 여행 기록 관리 =====");
            System.out.println("1. 여행 등록");
            System.out.println("2. 여행 전체 조회");
            System.out.println("3. 여행 조회");
            System.out.println("4. 여행 수정");
            System.out.println("5. 여행 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    addTravel();
                    break;
                case 2:
                    showAllTravels();
                    break;
                case 3:
                    showTravel();
                    break;
                case 4:
                    updateTravel();
                    break;
                case 5:
                    deleteTravel();
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");


            }


        }
    }
    private void addTravel() {
        System.out.println("여행지를 입력하세요: ");
        String destination = scanner.nextLine();
        System.out.println("여행 날짜를 입력하세요. (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();

        LocalDate travelDate = LocalDate.parse(dateInput);

        System.out.println("여행 비용을 입력하세요: ");
        int cost = scanner.nextInt();
        scanner.nextLine();
        System.out.println("여행 평점을 입력하세요 (0~5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("메모를 입력하세요: ");
        String memo = scanner.nextLine();


        Travel travel = new Travel(
                0,
                destination,
                travelDate,
                cost,
                rating,
                memo
        );
        service.addTravel(travel);
    }
    private void showAllTravels() {
        List<Travel> travels = service.getAllTravels();
        for(Travel travel : travels) {
            System.out.println(travel);
        }
    }
    public void showTravel(){
        System.out.print("조회할 여행 ID를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Travel travel = service.getTravelById(id);
        if(travel == null) {
            System.out.println("해당 여행이 존재하지 않습니다.");
            return;
        }
        System.out.println(travel);
    }
    private void updateTravel() {
        System.out.print("수정할 여행 ID를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Travel existingTravel = service.getTravelById(id);

        if (existingTravel == null) {
            System.out.println("해당 여행이 존재하지 않습니다.");
            return;
        }

        System.out.print("새로운 여행지를 입력하세요: ");
        String destination = scanner.nextLine();

        System.out.print("새로운 여행 날짜를 입력하세요. (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate travelDate = LocalDate.parse(dateInput);

        System.out.print("새로운 여행 비용을 입력하세요: ");
        int cost = scanner.nextInt();
        scanner.nextLine();

        System.out.print("새로운 여행 평점을 입력하세요 (0~5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("새로운 메모를 입력하세요: ");
        String memo = scanner.nextLine();

        Travel travel = new Travel(
                id,
                destination,
                travelDate,
                cost,
                rating,
                memo
        );

        service.updateTravel(travel);

        System.out.println("여행 정보가 수정되었습니다.");
    }
    private void deleteTravel() {
        System.out.print("삭제할 여행 ID를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Travel travel = service.getTravelById(id);

        if (travel == null) {
            System.out.println("해당 여행이 존재하지 않습니다.");
            return;
        }

        service.deleteTravel(id);

        System.out.println("여행 정보가 삭제되었습니다.");
    }
}
