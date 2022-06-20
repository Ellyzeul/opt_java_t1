package src.controller;

import java.util.ArrayList;

public class CarController {
    private static int totalCars = 0;
    private static int totalLaps;
    private static String text = "";
    private static float probCrash;
    private static float probRefuel;

    public static void setCars(int totalCars) {
      CarController.totalCars = totalCars;
    }

    public static int getTotalCars() {
      return CarController.totalCars;
    }

    public static void setProbCrash(float probCrash) {
      CarController.probCrash = probCrash;
    }

    public static float getProbCrash() {
      return CarController.probCrash;
    }

    public static void setProbRefuel(float probRefuel) {
      CarController.probRefuel = probRefuel;
    }

    public static float getProbRefuel() {
      return CarController.probRefuel;
    }

    public static String setText(String text) {
      CarController.text = text;
    }

    public static void startRace(){
      ArrayList<Car> list = new ArrayList<>();
      for(int i=0; i<CarController.totalCars; i++) {
        list.add(new Car(
          CarController.totalLaps, 
          CarController.probCrash, 
          CarController.probRefuel, 
          CarController.text
        ));
      }
      for(Car car: list) {
        car.start();
      }
    }
}
