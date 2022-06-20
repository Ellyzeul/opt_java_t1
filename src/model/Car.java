package src.model;

public class Car extends Thread {
    private int totalLaps; 
    private float probCrash; 
    private float probRefuel; 
    private String text;

    public Car(int totalLaps, float probCrash, float probRefuel, String text){
        this.totalLaps = totalLaps; 
        this.probCrash = probCrash; 
        this.probRefuel = probRefuel; 
        this.text = text;
    }
  
    @Override
    public void run(){
        synchronized (text) {
            for(int i=1; i<=10;i++){
                text = String.format("%s\n%s", text, Integer.toString(i));
                System.out.println(text);
            }
        }
    }
}
