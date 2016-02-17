import java.util.ConcurrentModificationException;
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
        Queue<Job> readyQueue = new LinkedList<Job>();
        Job firstJob = Job.randJob();
        time.incrementCurrentTime(firstJob.toa+firstJob.duration);
        while (time.currentTime <= 5000) {
            Job upcomingJob = Job.randJob();
            int largestBlockSize = test.getLargestBlock().size;
            //Checks that there is any possible block to place a job, checks if job was originated before the last event, & checks if any jobs are waiting for a block to empty its program.
            while(upcomingJob.size <= largestBlockSize && (upcomingJob.toa + time.previousTime) <= time.currentTime && readyQueue.peek() != null){
                //Increments time before latest event
                time.incrementPrevTime(upcomingJob.toa);
                try {
                    readyQueue.add(upcomingJob);
                }catch(ConcurrentModificationException e){
                    System.out.println("ConcurrentModificationException whatever that means.");
                }
                if(upcomingJob.size > test.getLargestOpenBlock().size){
                    break;
                }
                upcomingJob = Job.randJob();
            }
            if(readyQueue.peek() != null){
                readyQueue = processReadyQueue(readyQueue);
            }
            time.returnToPresent();

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
    public static Queue<Job> processReadyQueue(Queue<Job> input){
        while(input.peek() != null && input.peek().size <= test.getLargestOpenBlock().size){
            test.addJob(input.poll());
        }
       return input;
    }
}
