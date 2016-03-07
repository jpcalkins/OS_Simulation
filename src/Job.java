/**
 * a. Jacob Calkins
 * b. CS 4323
 * c. Simulation Project, Phase 1
 * d. Sarath Kumar Maddinani
 * e. timeStamp is used to id processes and keep track of arrival so they may be executed in that same order.
 * f. This class simulates a process and can create random copies of itself for testing.
 * g. Class could have been named Process, as that is what it is mimicking, but this was already implemented before learning proper terminology.
 */
import java.util.concurrent.ThreadLocalRandom;

public class Job {
    public int size;
    public int duration;
    //time of arrival
    public int toa;
    //So that I may compute avg. wait time, I only track VTU at which job started waiting then calculate difference from CPU time when processing job.
    public int startWaitTime;
    public long timeStamp;

//    public Job(int size, int duration, int toa){
//        this.size = size;
//        this.duration = duration;
//        this.toa = toa;
//        this.timeStamp = System.currentTimeMillis();
//    }
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

    //I pass time to the Random job creator for a timestamp so that I may keep track of when job was added to memory for wait time statistics.
    public static Job randJob(int time){
        return new Job(randSize(), randDuration(), randTOA(), time);
    }
    //public static Job randJob(){
        //return new Job(randSize(), randDuration(), randTOA());
    //}
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
