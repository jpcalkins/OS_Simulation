/**
 * Created by Jacob on 2/5/16.
 */
public class Timer {
    //Current time keeps track of CPU events
    public int currentTime;
    //Previous time tracks events in memory
    public int previousTime;
    //Stats keeps track of fragmentation, rejected jobs, etc.
    public Measurement stats;

    public Timer(){
        this.currentTime = 0;
        this.previousTime = 0;
        this.stats = new Measurement();
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
        System.out.println("Previous Time: " + previousTime + "\tIncrement: " + increment);
        //This chain of ifs help me establish if time has passed a moment when statistics need to be printed.
        int temp = previousTime + increment;
        if(temp >= 5000){
            stats.output1000();
            System.out.println("System shutting down, have reached time limit.");
            System.exit(0);
        }
        int baseTime = previousTime % 1000;
        if(baseTime + increment >= 1000){
            if(temp >= 4000){
                stats.output4000();
            }
            stats.output1000();
        }else if(baseTime % 100 + increment >= 100){
            stats.output100();
        }
        this.previousTime += increment;
        if(this.previousTime > this.currentTime){
            System.out.println("ERROR! previous time has exceeded current time.");
        }
    }
    public void returnToPresent(){
        //Sets memory timeline equal to that of CPU timeline.
        System.out.println("HERE");
        if(previousTime < currentTime){
            this.previousTime = this.currentTime;
        }else if(previousTime > currentTime){
            System.out.println("ERROR! previous time has exceeded current time.");
        }
    }
}
