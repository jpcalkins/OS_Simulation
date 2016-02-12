import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static Timer time = new Timer();
    public static StorageStrategy test = new StorageStrategy();
    public static BestFitStorage bestFit = new BestFitStorage();
    public static FirstFitStorage firstFit = new FirstFitStorage();
    public static WorstFitStorage worstFit = new WorstFitStorage();

    public static void main(String[] args) {
        int jobNumber = 0;
        Queue readyQueue = new LinkedList();
        Job firstJob = Job.randJob();
        time.incrementCurrentTime(firstJob.toa+firstJob.duration);
        while (time.currentTime <= 5000) {
            Job upcomingJob = Job.randJob();
            while(upcomingJob.size <= test.getLargestBlock().size && (upcomingJob.toa + time.previousTime) <= time.currentTime){
                time.incrementPrevTime(upcomingJob.toa);
                readyQueue.add(upcomingJob);
            }
            readyQueue = processReadyQueue(readyQueue);
            //jobNumber++;
            //addJobToMemory(upcomingJob);
            //time.incrementCurrentTime(firstJob.duration);
        }
    }
    public static void addJobToMemory(Job job){
        bestFit.addJob(job);
        firstFit.addJob(job);
        worstFit.addJob(job);
    }
    public static Queue processReadyQueue(Queue input){
       return input;
    }
}
