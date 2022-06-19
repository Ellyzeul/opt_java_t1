package src.controller;

public class CarController {
    private static int totalCars = 0;

    public static void setCars(int totalCars) {
      CarController.totalCars = totalCars;
    }

    public static int getTotalCars() {
      return CarController.totalCars;
    }
}
