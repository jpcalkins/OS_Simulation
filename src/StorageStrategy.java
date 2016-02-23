/**
 * Created by Jacob on 2/5/16.
 */
import java.lang.reflect.Array;
import java.util.*;

public class StorageStrategy {
    private int jobNumber;
    public Measurement stats;
    public Timer time;
    public ArrayList<Block> memory;
    public Queue<Job> readyQueue;

    public StorageStrategy(){
        this.jobNumber = 0;
        this.readyQueue = new LinkedList<Job>();
        this.stats = new Measurement();
        this.memory = new ArrayList<Block>();
        memory.add(new Block(1800));
        memory.add(new Block(new Job(200, 0, 0, false)));
    }

    public Block getLargestOpenBlock(){
        Block largestOpenBlock = memory.get(0);
        for(int i=1; i<memory.size()-1; i++){
            if(memory.get(i).size > largestOpenBlock.size && memory.get(i).occupied){
                largestOpenBlock = memory.get(i);
            }
        }
        return largestOpenBlock;
    }
    public Block getLargestBlock(){
        Block largestBlock = memory.get(0);
        for(int i=1; i<memory.size()-1; i++){
            if(memory.get(i).size > largestBlock.size){
                largestBlock = memory.get(i);
            }
        }
        return largestBlock;
    }
    public void addJob(Job incomingJob){
        for(int i=0; i<memory.size(); i++){
            if(memory.get(i).size >= incomingJob.size && !memory.get(i).occupied){
                //addJobToBlock returns a new empty block if block where job was placed wasn't completely filled.
                Block temp = memory.get(i).addJobToBlock(incomingJob);
                if(temp != null){
                    memory.add(i+1, temp);
                }
                break;
            }
        }
    }
    public void generateJobs(){
        this.time = Main.time;
        Job upcomingJob = Job.randJob();
        int largestBlockSize = this.getLargestBlock().size;
        //Checks that there is any possible block to place a job, checks if job was originated before the last event, & checks if any jobs are waiting for a block to empty its program.
        //This will need to be dependent upon memory allocation procedure since some jobs will be ejected based upon how memory is filled while those same jobs will fit in others.
        while(upcomingJob.size <= largestBlockSize && (upcomingJob.toa + time.previousTime) <= time.currentTime && readyQueue.peek() != null){
            //Increments time before latest event
            time.incrementPrevTime(upcomingJob.toa);
            try {
                readyQueue.add(upcomingJob);
            }catch(ConcurrentModificationException e){
                System.out.println("ConcurrentModificationException whatever that means.");
            }
            if(upcomingJob.size > this.getLargestOpenBlock().size){
                break;
            }
            upcomingJob = Job.randJob();
        }
        if(readyQueue.peek() != null){
            //readyQueue = processReadyQueue(readyQueue);
        }
        //time.returnToPresent();
        //jobNumber++;
        //addJobToMemory(upcomingJob);
        //time.incrementCurrentTime(firstJob.duration);
    }
}
