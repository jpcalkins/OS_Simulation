/**
 * Created by Jacob on 2/5/16.
 */
public class Timer {
    public int currentTime;
    public int previousTime;
    public Measurement stats;

    public Timer(){
        this.currentTime = 0;
        this.previousTime = 0;
        this.stats = new Measurement();
    }
    public Timer(int time){
        this.currentTime = time;
        this.previousTime = 0;
    }
    public void incrementCurrentTime(int increment){
        this.currentTime += increment;
        if(this.currentTime > 5000){
            System.out.println("Time:\t" + currentTime);
            System.out.println("System shutting down, have reached time limit.");
            System.exit(0);
        }
    }
    public void incrementPrevTime(int increment){
        int temp = previousTime + increment;
        if(temp >= 5000){
            System.out.println("Time:\t" + previousTime);
            stats.output1000();
            System.exit(0);
        }
        int baseTime = previousTime % 1000;
        if(baseTime + increment >= 1000){
            System.out.println("Time:\t" + previousTime);
            if(temp >= 4000){
                stats.output4000();
            }
            stats.output1000();
            stats.output100();
        }else if(baseTime % 100 + increment >= 100){
            System.out.println("Time:\t" + previousTime);
            stats.output100();
        }
        this.previousTime += increment;
        if(this.previousTime > this.currentTime){
            System.out.println("ERROR! previous time has exceeded current time.");
        }
    }
    public void returnToPresent(){
        if(previousTime < currentTime){
            this.previousTime = this.currentTime;
        }else if(previousTime > currentTime){
            System.out.println("ERROR! previous time has exceeded current time.");
        }
    }
}
