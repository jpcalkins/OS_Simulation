/**
 * Created by Jacob on 2/5/16.
 */
public class Timer {
    public int currentTime;
    public int previousTime;

    public Timer(){
        this.currentTime = 0;
        this.previousTime = 0;
    }
    public Timer(int time){
        this.currentTime = time;
        this.previousTime = 0;
    }
    public void incrementCurrentTime(int increment){
        this.currentTime += increment;
    }
    public void incrementPrevTime(int increment){
        this.previousTime += increment;
    }
    public void returnToPresent(){
        if(previousTime < currentTime){
            this.previousTime = this.currentTime;
        }
        //this.previousTime = this.currentTime;
    }
}
