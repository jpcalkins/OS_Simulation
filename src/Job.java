import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jacob on 2/5/16.
 */
public class Job {
    public int size;
    public int duration;
    //time of arrival
    public int toa;
    public int startWaitTime;
    public boolean process;
    public long timeStamp;
    //public int priority;

    public Job(int size, int duration, int toa){
        this.size = size;
        this.duration = duration;
        this.toa = toa;
        this.process = true;
        this.timeStamp = System.currentTimeMillis();
    }
    public Job(int size, int duration, int toa, int time){
        this.size = size;
        this.duration = duration;
        this.toa = toa;
        this.process = true;
        this.startWaitTime = time;
        this.timeStamp = System.currentTimeMillis();
    }
    public Job(int size, int duration, int toa, boolean process){
        this.size = size;
        this.duration = duration;
        this.toa = toa;
        this.process = process;
        this.timeStamp = System.currentTimeMillis();
    }
    public Job(int size, int duration, int toa, boolean process, int time){
        this.size = size;
        this.duration = duration;
        this.toa = toa;
        this.process = true;
        this.process = process;
        this.timeStamp = time;
    }
    public int getSize(){
        return size;
    }
    public int getDuration(){
        return duration;
    }
    public int getTOA(){
        return toa;
    }
    public void setStartWaitTime(int time){
        this.startWaitTime = time;
    }

    public static Job randJob(int time){
        return new Job(randSize(), randDuration(), randTOA(), time);
    }
    public static Job randJob(){
        return new Job(randSize(), randDuration(), randTOA());
    }
    public static int randSize(){
        int minSize = 5;
        int maxSize = 31;
        return ThreadLocalRandom.current().nextInt(minSize, maxSize)*10;
    }
    public static int randDuration(){
        int minDuration = 1;
        int maxDuration = 13;
        return ThreadLocalRandom.current().nextInt(minDuration, maxDuration)*5;
    }
    public static int randTOA(){
        int minTOA = 1;
        int maxTOA = 11;
        return ThreadLocalRandom.current().nextInt(minTOA, maxTOA);
    }
}
