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
        syncronized(text){ //error
            for(int i=1; i<=10;i++){
                text = text +i+" hello\n";
                System.out.println(text);
            }            
        }
    }
}
