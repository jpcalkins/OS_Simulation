/**
 * Created by Jacob on 2/5/16.
 */
import java.util.*;

abstract public class StorageStrategy {
    //public Measurement stats;
    public Timer time;
    public static ArrayList<Block> memory;
    public Queue<Job> readyQueue;
    //Keeps track of the position in memory of waiting processes by keeping a queue of process timestamps.
    public Queue<Long> processQueue;

    abstract public void addJob(Job incomingJob);

    public StorageStrategy(){
        //this.stats = new Measurement();
        time = new Timer();
        this.processQueue = new LinkedList<Long>();
        this.readyQueue = new LinkedList<Job>();
        memory = new ArrayList<Block>();
        memory.add(new Block(1800));
    }

    public void startComputer(){
        Job firstJob = Job.randJob();
        addJob(firstJob);
        time.incrementCurrentTime(firstJob.toa+firstJob.duration);
        ejectFromMemory(processQueue.poll());
        while(true){
            generateJobs();
            if(processQueue.peek() != null){
                runProcess(processQueue.poll());
            }
//            else if(time.getCurrentTime() == time.getPreviousTime()){
//                firstJob = Job.randJob();
//                addJob(firstJob);
//                time.incrementCurrentTime(firstJob.toa + firstJob.duration);
//                ejectFromMemory(processQueue.poll());
//            }
        }
    }

    public void generateJobs(){
        //Checks if there are any jobs that have been waiting for a memory hole to open.
        if(readyQueue.size() >= 1) {
            //Sets memory timeline to present CPU event
            time.returnToPresent();
            Job temp = readyQueue.poll();
            temp.setStartWaitTime(time.getPreviousTime());
            addJob(temp);
            if(readyQueue.size() >= 1) {
                //job is still waiting for hole to open so no need to make more jobs.
                return;
            }
        }
        Job upcomingJob = Job.randJob(time.getPreviousTime());
        int largestBlockSize = getLargestBlock().size;
        if(time.getCurrentTime() == time.getPreviousTime() && readyQueue.peek() == null){
            while(upcomingJob.size > largestBlockSize) {
                time.stats.rejectedJobs++;
                upcomingJob = Job.randJob(time.getPreviousTime());
                time.incrementCurrentTime(upcomingJob.toa);
                time.incrementPrevTime(upcomingJob.toa);
                try {
                    readyQueue.add(upcomingJob);
                } catch (ConcurrentModificationException e) {
                    System.out.println("ConcurrentModificationException whatever that means.");
                }
            }
        }else{
            //Checks that there is any possible block to place a job & checks if job was originated before the last event
            while (upcomingJob.toa + time.getPreviousTime() <= time.getCurrentTime()) {
                //Increments time before latest event
                time.incrementPrevTime(upcomingJob.toa);
                if (upcomingJob.size > largestBlockSize) {
                    time.stats.rejectedJobs++;
                    upcomingJob = Job.randJob(time.getPreviousTime());
                    continue;
                }
                try {
                    readyQueue.add(upcomingJob);
                } catch (ConcurrentModificationException e) {
                    System.out.println("ConcurrentModificationException whatever that means.");
                }
                if (upcomingJob.size > this.getLargestOpenBlock().size) {
                    break;
                }
                upcomingJob = Job.randJob(time.getPreviousTime());
            }
        }
        if(readyQueue.peek() != null){
            //time.returnToPresent();
            processReadyQueue();
        }
    }

    public void processReadyQueue(){
        //Moves jobs to memory from ready Queue
        while(readyQueue.size() > 0){
            //adds job to memory if there is an open block.
            if(readyQueue.peek().size <= this.getLargestOpenBlock().size){
                addJob(readyQueue.poll());
            //Clears everything after the first job in readyQueue because it is waiting for an occupied block to open
            }else if(readyQueue.peek().size <= this.getLargestBlock().size){
                Job temp = readyQueue.poll();
                time.stats.rejectedJobs += readyQueue.size();
                readyQueue.clear();
                readyQueue.add(temp);
                return;
            //rejects job if there is not a large enough block in memory
            }else{
                readyQueue.poll();
                time.stats.rejectedJobs++;
            }
        }
    }

    public Block getLargestOpenBlock(){
        Block largestOpenBlock = memory.get(0);
        for(int i=1; i<memory.size(); i++){
            if(memory.get(i).size > largestOpenBlock.size && !memory.get(i).occupied){
                largestOpenBlock = memory.get(i);
            }
        }
        return largestOpenBlock;
    }

    public Block getLargestBlock(){
        Block largestBlock = memory.get(0);
        for(int i=1; i<memory.size(); i++){
            if(memory.get(i).size > largestBlock.size){
                largestBlock = memory.get(i);
            }
        }
        return largestBlock;
    }
    //Simulates a job entering the CPU and moves my program to the next event, process leaving the CPU.
    public void runProcess(long id){
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).occupied && memory.get(i).job.timeStamp == id){
                time.stats.totalJobs++;
                time.stats.totalWaitTime += time.getCurrentTime()-memory.get(i).job.startWaitTime;
                time.stats.totalProcessingTime += memory.get(i).job.duration;
                time.incrementCurrentTime(memory.get(i).job.duration);
                ejectFromMemory(id);
                break;
            }
        }
    }
    //Clears a job from memory since it has been processed through the CPU
    public void ejectFromMemory(long id){
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).occupied && memory.get(i).job.timeStamp == id){
                memory.get(i).removeJob();
                break;
            }
        }
    }

    public static ArrayList<Block> getMemory(){
        return memory;
    }
}
