package src.controller;

import java.util.ArrayList;

import src.model.Car;
import src.view.Context;

public class CarController {
    private static int totalCars = 0;
    private static int totalLaps = 0;
    private static String text = "";
    private static String podium = "";
    private static float probCrash = 0;
    private static float probRefuel = 0;

    public static void setTotalCars(int totalCars) {
      CarController.totalCars = totalCars;
    }

    public static int getTotalCars() {
      return totalCars;
    }

    public static void setTotalLaps(int totalLaps) {
      CarController.totalLaps = totalLaps;
    }

    public static int getTotalLaps() {
      return totalLaps;
    }

    public static void setProbCrash(float probCrash) {
      CarController.probCrash = probCrash;
    }

    public static float getProbCrash() {
      return probCrash;
    }

    public static void setProbRefuel(float probRefuel) {
      CarController.probRefuel = probRefuel;
    }

    public static float getProbRefuel() {
      return probRefuel;
    }

    public static void setText(String text) {
      CarController.text = text;
    }

    public static String getText() {
      return text;
    }

    public static void setPodium(String podium) {
      CarController.podium = podium;
    }

    public static String getPodium() {
      return podium;
    }

    public static void startRace(){
      ArrayList<Car> list = new ArrayList<>();

      text = "";
      podium = "";

      for(int i=0; i<CarController.totalCars; i++) {
        list.add(new Car(
          i+1,
          CarController.totalLaps,
          CarController.probCrash,
          CarController.probRefuel
        ));
      }
      for(Car car: list) {
        car.start();
      }
      for(Car car: list) {
        try {
          car.join();
        } catch (InterruptedException e) {}
      }

      Context.getRaceLog().setText(text + podium);
    }
}
