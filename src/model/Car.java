package src.model;

import src.controller.CarController;

public class Car extends Thread {
    private int id;
    private int totalLaps;
    private float probCrash;
    private float probRefuel;
    private static Object lock1;
    private static Integer ranking = 1;

    public Car(int id, int totalLaps, float probCrash, float probRefuel){
        this.id = id;
        this.totalLaps = totalLaps; 
        this.probCrash = probCrash; 
        this.probRefuel = probRefuel; 
        lock1 = new Object();
        ranking = 1;
    }
  
    @Override
    public void run(){
        for(int i = 1; i <= totalLaps;) {
            synchronized (lock1) {
                if(Math.random() < probCrash) {
                    CarController.setText(String.format("%s\nCarro#%4d - Houve um pequeno incidente nessa volta.", CarController.getText(),id));
                    continue;
                }
                if(Math.random() < probRefuel) {
                    CarController.setText(String.format("%s\nCarro#%4d - Parou para abastecer nessa volta.", CarController.getText(), id));
                    continue;
                }

                CarController.setText(String.format("%s\nCarro#%4d - %d de %d voltas completas.", CarController.getText(), id, i++, totalLaps));
            }
        }
        synchronized (ranking) {
            CarController.setPodium(String.format("%s\nCarro#%4d - Chegou em %sº lugar.", CarController.getPodium(), id, ranking++));
        }
    }
}
