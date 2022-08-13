package src.model;

import javax.swing.JProgressBar;

import src.controller.CarController;

public class Car extends Thread {
    private int id;
    private int totalLaps;
    private float probCrash;
    private float probRefuel;
    private JProgressBar progressBar;
    private static Object lock1;
    private static Integer ranking = 1;

    public Car(int id, int totalLaps, float probCrash, float probRefuel, JProgressBar progressBar) {
        this.id = id;
        this.totalLaps = totalLaps; 
        this.probCrash = probCrash; 
        this.probRefuel = probRefuel; 
        this.progressBar = progressBar;
        lock1 = new Object();
        ranking = 1;
    }
  
    @Override
    public void run(){
        for(int i = 1; i <= totalLaps;) {
            synchronized (lock1) {
                if(Math.random() < probCrash) {
                    this.progressBar.setString("Quebrou");
                    CarController.setText(String.format("%s\nCarro #%04d - Quebrou nessa volta.", CarController.getText(),id));
                    continue;
                }
                if(Math.random() < probRefuel) {
                    this.progressBar.setString("Reabasteceu");
                    CarController.setText(String.format("%s\nCarro #%04d - Parou para abastecer nessa volta.", CarController.getText(), id));
                    continue;
                }

                this.progressBar.setValue(i);
                this.progressBar.setString(String.format("%d/%d", i, totalLaps));
                CarController.setText(String.format("%s\nCarro #%04d - %d de %d voltas completas.", CarController.getText(), id, i++, totalLaps));
            }
        }
        synchronized (ranking) {
            this.progressBar.setString(String.format("Chegou em %dº lugar", ranking));
            CarController.setPodium(String.format("%s\nCarro #%04d - Chegou em %sº lugar.", CarController.getPodium(), id, ranking++));
        }
    }
}
