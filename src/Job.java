/**
 * f. This class simulates a process and can create random copies of itself for testing.
 * g. Class could have been named Process, as that is what it is mimicking, but this was already implemented before learning proper terminology.
 */
import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;

public class Job {
    public int size;
    public int duration;
    //time of arrival
    public int toa;
    //So that I may compute avg. wait time, I only track VTU at which job started waiting then calculate difference from CPU time when processing job.
    public int startWaitTime;
    public long timeStamp;
    public static Random myRandom = new Random((long)0.009);

    public Job(int size, int duration, int toa, int time){
        this.size = size;
        this.duration = duration;
        this.toa = toa;
        this.startWaitTime = time;
        this.timeStamp = System.currentTimeMillis();
    }
    public void setStartWaitTime(int time){
        this.startWaitTime = time;
    }

    //f. I pass time to the Random job creator for a timestamp so that I may keep track of when job was added to memory for wait time statistics.
    public static Job randJob(int time){
        return new Job(randSize(), randDuration(), randTOA(), time);
    }
    //f. returns a number between 50 and 300 for Job sizes
    public static int randSize(){
        int min = 5;
        int max = 30;
        return (myRandom.nextInt(max-min+1)+min) * 10;
    }
    //f. returns a number between 5 and 60 for Job durations
    public static int randDuration(){
        int min = 1;
        int max = 12;
        return (myRandom.nextInt(max-min+1)+min) * 5;
    }
    //f. return a number between 1 and 10 for job time of arrivals.
    public static int randTOA(){
        int min = 1;
        int max = 10;
        return myRandom.nextInt(max-min+1)+min;
    }
}
